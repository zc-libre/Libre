import {defineStore} from 'pinia'
import {login} from '@/api'
import {BlogUser} from '@/models/User.class'
import {setToken, getToken, setClient} from '@/utils/auth'

export const useUserStore = defineStore({
  id: 'userStore',
  state: () => ({
    blogUser: new BlogUser(),
    token: getToken(),
    clientId: ''
  }),
  getters: {
    getToken: state => state.token,
    getClientId: state => state.clientId
  },
  actions: {
    async login(client: any, code: string, state: string) {
      const {data} = await login(client, code, state)
      return new Promise(resolve => {
        this.blogUser = new BlogUser(data.data)
        if (this.blogUser && this.blogUser.token) {
          setToken(this.blogUser.token)
        }
        resolve(this.blogUser)
      })
    },
    setClientId(clientId: string) {
      this.clientId = clientId
      setClient(clientId)
    }
  }
})
