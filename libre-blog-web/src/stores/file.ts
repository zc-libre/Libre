import {defineStore} from 'pinia'

const baseUrl = import.meta.env.VITE_APP_BASE_API
export const useFileStore = defineStore({
  id: 'fileStore',
  state: () => ({
    localFileApi: baseUrl + '/file/',
  }),
  getters: {
    getLocalFileApi: state => state.localFileApi
  },
  actions: {}
})
