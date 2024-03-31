<template>
  <div class="flex flex-col mt-20">
    <div class="main-grid">
      <div class="post-header">
        <span class="post-labels">
          <ob-skeleton v-if="loading" tag="b" height="20px" width="35px"/>
          <b
            v-else-if="!loading && post.category"
            @click="navigateToCategory(post.category.id)"
          >
            <span>{{ post.category.categoryName }}</span>
          </b>
          <b v-else>{{ t('settings.default-category') }}</b>
          <ul>
            <ob-skeleton
              v-if="loading"
              :count="2"
              tag="li"
              height="16px"
              width="35px"
              class="mr-2"
            />
            <template v-else-if="!loading && post.tags && post.tags.length > 0">
              <li
                v-for="tag in post.tags"
                :key="tag.id"
                @click="navigateToTag(tag.id)"
              >
                <em class="opacity-50">#</em>
                {{ tag.tagName }}
              </li>
            </template>
            <template v-else>
              <li>
                <b class="opacity-50">#</b>
                {{ t('settings.default-tag') }}
              </li>
            </template>
          </ul>
        </span>

        <h1 v-if="post.articleName" class="post-title text-white">
          {{ post.articleName }}
        </h1>
        <ob-skeleton
          v-else
          class="post-title text-white uppercase"
          width="100%"
          height="clamp(1.2rem, calc(1rem + 3.5vw), 4rem)"
        />

        <div class="flex flex-row items-center justify-start mt-8 mb-4">
          <div class="post-footer" v-if="post.author && readTime">
            <img
              :class="avatarClasses"
              v-lazy="post.author.avatar || ''"
              :alt="`author-${post.author.name}`"
              @click="handleAuthorClick(post.author.link)"
            />
            <span class="text-white opacity-80">
              <strong
                class="text-white pr-1.5 hover:opacity-50 cursor-pointer"
                @click="handleAuthorClick(post.author.link)"
              >
                {{ post.author.name }}
              </strong>
              <span class="opacity-70">
                {{ t('settings.shared-on') }} {{ post.date.month }}
                {{ post.date.day }}, {{ post.date.year }}
              </span>
            </span>
          </div>

          <div class="post-footer" v-else>
            <div class="flex flex-row items-center">
              <ob-skeleton
                class="mr-2"
                height="28px"
                width="28px"
                :circle="true"
              />
              <span class="text-ob-dim mt-1">
                <ob-skeleton height="20px" width="150px"/>
              </span>
            </div>
          </div>

          <PostStats
            :post-word-count="wordNum"
            :post-time-count="readTime"
            :post-title="post.articleName"
            :current-path="currentPath"
            :plugin-configs="pluginConfigs"
            :comments="enabledComments"
            ref="postStatsRef"
          />
        </div>
      </div>
    </div>
    <div class="main-grid">
      <div>
        <template v-if="post.content">
          <div
            class="post-html"
            v-html="post.content"
            v-scroll-spy="{ sectionSelector: 'h1, h2, h3, h4, h5, h6' }"
          />
        </template>
        <div
          v-else
          class="bg-ob-deep-800 px-14 py-16 rounded-2xl shadow-xl block min-h-screen"
        >
          <ob-skeleton
            tag="div"
            :count="1"
            height="36px"
            width="150px"
            class="mb-6"
          />
          <br/>
          <ob-skeleton
            tag="div"
            :count="35"
            height="16px"
            width="100px"
            class="mr-2"
          />
          <br/>
          <br/>
          <ob-skeleton
            tag="div"
            :count="25"
            height="16px"
            width="100px"
            class="mr-2"
          />
        </div>
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols2 gap-6 mt-6">
          <div
            class="flex flex-col w-full h-full mr-0 lg:mr-4"
            v-if="post.preArticle && post.preArticle.articleName"
          >
            <SubTitle
              title="settings.paginator.prev"
              icon="arrow-left-circle"
            />
            <ArticleCard :data="post.preArticle"/>
          </div>
          <div class="flex flex-col w-full h-full" v-if="post.nextArticle && post.nextArticle.articleName">
            <SubTitle
              title="settings.paginator.next"
              :side="!isMobile ? 'right' : 'left'"
              icon="arrow-right-circle"
            />
            <ArticleCard :data="post.nextArticle"/>
          </div>
        </div>
        <div>
          <div v-if='enabledComments'>
            <Comment
              :title="post.articleName"
              :body="post.summary"
              :uid="post.id"
            />
          </div>
        </div>
      </div>
      <div>
        <Sidebar>
          <Profile :author="post.author.id || ''"/>
          <Toc :toc="post.toc" :comments="enabledComments"/>
        </Sidebar>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import '@/styles/prism-aurora-future.css'
import {Sidebar, Toc, Profile} from '@/components/Sidebar'
import {Post} from '@/models/Post.class'
import {usePostStore} from '@/stores/post'
import {useFileStore} from '@/stores/file'
import {
  Ref,
  computed,
  defineComponent,
  nextTick,
  ref,
  watch,
  reactive,
  toRefs
} from 'vue'
import {useRoute, useRouter} from 'vue-router'
import {useI18n} from 'vue-i18n'
import Comment from '@/components/Comment.vue'
import LComment from '@/components/LComment.vue'
import {SubTitle} from '@/components/Title'
import {ArticleCard} from '@/components/ArticleCard'
import {useMetaStore} from '@/stores/meta'
import {useAppStore} from '@/stores/app'
import {useCommonStore} from '@/stores/common'
import SvgIcon, {SvgTypes} from '@/components/SvgIcon/index.vue'
import PostStats from '@/components/Post/PostStats.vue'
import useCommentPlugin from '@/hooks/useCommentPlugin'
import useLightBox from '@/hooks/useLightBox'

declare const Prism: any

interface PostStatsExpose extends Ref<InstanceType<typeof PostStats>> {
  getCommentCount(): void

  getPostView(): void
}

export default defineComponent({
  name: 'ARPost',
  components: {
    Sidebar,
    Toc,
    Comment,
    LComment,
    SubTitle,
    ArticleCard,
    Profile,
    SvgIcon,
    PostStats
  },
  setup() {
    const metaStore = useMetaStore()
    const postStore = usePostStore()
    const appStore = useAppStore()
    const commonStore = useCommonStore()
    const fileStore = useFileStore()
    const route = useRoute()
    const router = useRouter()
    const {t} = useI18n()
    const post = ref(new Post())
    const loading = ref(true)
    const postStatsRef = ref<PostStatsExpose>()
    const {enabledCommentPlugin} = useCommentPlugin()
    const {initializeLightBox} = useLightBox()
    const reactiveData = reactive({
      wordNum: '' as any,
      readTime: '' as any
    })
    const deleteHTMLTag = (content: any) => {
      return content
        .replace(/<\/?[^>]*>/g, '')
        .replace(/[|]*\n/, '')
        .replace(/&npsp;/gi, '')
    }

    const fetchData = async () => {
      loading.value = true
      post.value = new Post()
      window.scrollTo({
        top: 0
      })
      let articleId = String(route.params.articleId)

      await postStore.fetchPost(articleId).then(response => {
        post.value = response
        metaStore.setTitle(post.value.articleName)
        const coverUrl = fileStore.localFileApi + response.cover
        commonStore.setHeaderImage(coverUrl)
        reactiveData.wordNum =
          Math.round(deleteHTMLTag(post.value.content).length / 100) / 10 + 'k'
        reactiveData.readTime =
          Math.round(deleteHTMLTag(post.value.content).length / 400) + 'mins'
        loading.value = false
      })

      await nextTick()
      initializeLightBox()
      postStatsRef.value?.getCommentCount()
      postStatsRef.value?.getPostView()
      Prism.highlightAll()
    }

    watch(
      () => route.params,
      toParams => {
        if (toParams.articleId && route.fullPath.indexOf('#') === -1)
          fetchData()
      }
    )

    const handleAuthorClick = (link: string) => {
      if (link === '') link = window.location.href
      window.location.href = link
    }

    const navigateToTag = (id: string) => {
      router.push({name: 'search', query: {tag: id}})
    }

    const navigateToCategory = (id: string) => {
      router.push({name: 'search', query: {category: id}})
    }

    return {
      avatarClasses: computed(() => {
        return {
          'hover:opacity-50 cursor-pointer': true,
          [appStore.themeConfig.theme.profile_shape]: true
        }
      }),
      isMobile: computed(() => commonStore.isMobile),
      currentPath: computed(() => route.path),
      pluginConfigs: computed(() => appStore.themeConfig.plugins),
      enabledComments: computed(() => post.value.enableComment !== 0),
      postStatsRef,
      SvgTypes,
      commonStore,
      fetchData,
      handleAuthorClick,
      navigateToTag,
      navigateToCategory,
      loading,
      post,
      t,
      ...toRefs(reactiveData)
    }
  },
  mounted() {
    this.fetchData()
  },
  beforeUnmount() {
    this.commonStore.resetHeaderImage()
  }
})
</script>
