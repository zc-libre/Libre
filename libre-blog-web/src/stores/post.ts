import {defineStore} from 'pinia'
import {
  Archives,
  FeaturePosts,
  Post,
  PostList,
  SpecificPostsList
} from '@/models/Post.class'
import {
  fetchFeature,
  fetchPostsList,
  fetchPostBySlug,
  fetchPostsListByCategory,
  fetchPostsListByTag,
  fetchArchivesList
} from '@/api'

export const usePostStore = defineStore({
  // id is the name of the store
  // it is used in devtools and allows restoring state
  id: 'postStore',
  state: () => ({
    featurePosts: new FeaturePosts(),
    posts: new PostList(),
    postTotal: 0,
    size: 10,
    cachePost: {
      title: '',
      body: '',
      uid: ''
    }
  }),
  getters: {},
  actions: {
    async fetchFeaturePosts() {
      const {data} = await fetchFeature()
      return new Promise(resolve =>
        setTimeout(() => {
          this.featurePosts = new FeaturePosts(data.data)
          resolve(this.featurePosts)
        }, 200)
      )
    },
    async fetchPostsList(page?: any): Promise<PostList> {
      const {data} = await fetchPostsList(page)
      return new Promise(resolve =>
        setTimeout(() => {
          this.posts = new PostList(data.data)
          this.postTotal = this.posts.total
          resolve(this.posts)
        }, 200)
      )
    },
    async fetchArchives(page?: any): Promise<Archives> {
      const {data} = await fetchArchivesList(page)
      return new Promise(resolve =>
        setTimeout(() => {
          resolve(new Archives(data.data))
        }, 200)
      )
    },
    async fetchPost(id: string): Promise<Post> {
      const {data} = await fetchPostBySlug(id)
      return new Promise(resolve =>
        setTimeout(() => {
          resolve(new Post(data.data))
        }, 200)
      )
    },
    async fetchPostsByCategory(param: any): Promise<SpecificPostsList> {
      const {data} = await fetchPostsListByCategory(param)
      return new Promise(resolve =>
        setTimeout(() => {
          resolve(new SpecificPostsList(data.data))
        }, 200)
      )
    },
    async fetchPostsByTag(param: any): Promise<SpecificPostsList> {
      const {data} = await fetchPostsListByTag(param)
      return new Promise(resolve => {
        setTimeout(() => {
          resolve(new SpecificPostsList(data.data))
        }, 200)
      })
    },
    /**
     * Setting the cache post data
     * @param data Cache data
     */
    setCache(data: { title: string; body: string; uid: string }) {
      this.cachePost = data
    }
  }
})
