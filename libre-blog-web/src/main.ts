import {createApp} from 'vue'
import {createPinia} from 'pinia'
import '@/styles/index.scss'
import App from './App.vue'
import router from './router'
import i18n from './locales'
import VueClickAway from 'vue3-click-away'
import VueLazyLoad from 'vue3-lazyload'
import UndrawUi from 'undraw-ui'
import 'undraw-ui/dist/style.css'
import './router/guard' // router guards
import 'virtual:svg-icons-register'
import {registerObSkeleton} from '@/components/LoadingSkeleton'
import {registerScrollSpy} from 'vue3-scroll-spy'
import defaultCover from '@/assets/default-cover.jpg'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App)
  .use(createPinia())
  .use(router)
  .use(ElementPlus)
  .use(i18n)
  .use(UndrawUi)
  .use(VueClickAway)
  .use(VueLazyLoad, {
    loading: defaultCover,
    error: defaultCover
  })

registerObSkeleton(app)
registerScrollSpy(app)

app.mount('#app')
