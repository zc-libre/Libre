import {fetchAuthorPost} from '@/api'
import {AuthorPosts} from '@/models/Post.class'
import {defineStore} from 'pinia'

export const useAuthorStore = defineStore({
  // id is the name of the store
  // it is used in devtools and allows restoring state
  id: 'authorStore',
  state: () => ({}),
  getters: {},
  actions: {
    /** Fetching author's info */
    async fetchAuthorData(): Promise<AuthorPosts> {
      const {data} = await fetchAuthorPost()
      return new Promise(resolve => {
        resolve(new AuthorPosts(data.data))
      })
    }
  }
})
