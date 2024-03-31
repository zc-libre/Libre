/* eslint-disable */
import {createRouter, createWebHistory} from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../pages/index.vue')
  },
  {
    path: '/article/:articleId',
    name: 'article',
    component: () => import('../pages/Article.vue')
  },
  {
    path: '/article/search',
    name: 'search',
    component: () => import('../pages/post/search/index.vue')
  },
  {
    path: '/archives',
    name: 'Archives',
    component: () => import('../pages/archives.vue')
  },
  {
    path: '/tags',
    name: 'Tags',
    component: () => import('../pages/tags.vue')
  },
  {
    path: '/about',
    name: 'About',
    i18n: {
      'zh-CN': '关于',
      'zh-TW': '關於',
      en: 'About'
    },
    component: () => import('../pages/about.vue')
  },
  {
    path: '/message-board',
    name: 'messageBoard',
    i18n: {
      'zh-CN': '留言板',
      'zh-TW': '留言板',
      en: 'messageBoard'
    },
    component: () => import('../pages/MessageBoard.vue')
  },
  {
    path: '/links',
    name: 'Links',
    component: () => import('../pages/links.vue')
  },
  {
    path: '/404',
    name: '404',
    component: () => import('../pages/404.vue')
  },
  {
    path: '/:catchAll(.*)',
    redirect: '/404',
    hidden: true
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
