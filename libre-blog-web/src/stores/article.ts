import {defineStore} from 'pinia'
import {fetchImplicitPageBySource, fetchAbout} from '@/api'
import {Link, Page} from '@/models/Article.class'
import {Post} from '@/models/Post.class'

export const useArticleStore = defineStore({
  // id is the name of the store
  // it is used in devtools and allows restoring state
  id: 'articleStore',
  state: () => ({}),
  getters: {},
  actions: {

    async fetchArticle(source: string): Promise<any> {
      const {data} = await fetchImplicitPageBySource(source)
      return new Promise(resolve =>
        setTimeout(() => {
          resolve(new Page(data))
        }, 200)
      )
    },

    async fetchAbout(): Promise<Post> {
      const {data} = await fetchAbout()
      return new Promise(resolve =>
        setTimeout(() => {
          resolve(new Post(data.data))
        }, 200)
      )
    }
  }
})
