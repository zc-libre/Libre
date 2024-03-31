import {defineStore} from 'pinia'
import {fetchCommentInfo, fetchMessageBoard, fetchRecentComment} from '@/api'
import {CommentPage, RecentComment} from '@/models/Comment.class'
import {Post} from '@/models/Post.class'

export const useCommentStore = defineStore({
  id: 'commentStore',
  state: () => ({
    recentComment: new RecentComment().data,
    messageBoard: new Post()
  }),
  actions: {
    async fetchRecentComment() {
      const {data} = await fetchRecentComment()
      return new Promise(resolve => {
        this.recentComment = new RecentComment(data.data).data
        resolve(this.recentComment)
      })
    },

    async fetchCommentInfo(param: any): Promise<any> {
      const {data} = await fetchCommentInfo(param)
      return new Promise(resolve =>
        setTimeout(() => {
          resolve(new CommentPage(data.data))
        }, 200)
      )
    },

    async fetchMessageBoard(): Promise<Post> {
      const {data} = await fetchMessageBoard()
      return new Promise(resolve => {
        setTimeout(() => {
          resolve(new Post(data.data))
        }, 200)
      })
    }

  }
})
