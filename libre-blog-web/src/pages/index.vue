<template>
  <div class="block mt-8">
    <Feature v-if="themeConfig.theme.feature" :data="topFeature">
      <FeatureList :data="featurePosts"/>
    </Feature>
    <template v-else>
      <horizontal-article class="mb-8" :data="posts.records[0] || {}"/>
    </template>
    <div class="main-grid" id="article-list">
      <div class="flex flex-col relative">
        <ul :class="tabClass">
          <li
            :class="{ active: activeTab === '' }"
            @click="handleTabChange('')"
          >
            <span class="first-tab" :style="activeTabStyle('')">
              {{ t('settings.button-all') }}
            </span>
          </li>
          <template v-if="categories && categories.length > 0">
            <li
              v-for="category in categories"
              :key="category.id"
              :class="{ active: activeTab === category.categoryName }"
              @click="handleTabChange(category.id)"
            >
              <span :style="activeTabStyle(category.id)">
                {{ category.categoryName }}
              </span>
              <b>
                {{ category.count }}
              </b>
            </li>
          </template>
          <template v-else-if="categories !== null">
            <li v-for="i in 6" :key="i" style="position: relative; top: -4px">
              <ob-skeleton tag="span" width="60px" height="33px"/>
            </li>
          </template>
        </ul>

        <span :class="expanderClass" @click="expandHandler">
          <SvgIcon
            icon-class="chevron"
            height="1.2rem"
            width="1.2rem"
            fill="var(--text-normal)"
            stroke="var(--text-normal)"
          />
        </span>

        <ul class="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-6">
          <template v-if="posts.records.length === 0">
            <li v-for="n in 6" :key="n">
              <ArticleCard :data="{}"/>
            </li>
          </template>

          <template v-else-if="!themeConfig.theme.feature">
            <template v-for="(post, key) in posts.records" :key="post.id">
              <li v-if="key !== 0">
                <ArticleCard :data="post"/>
              </li>
            </template>
          </template>

          <template v-else>
            <li v-for="post in posts.records" :key="post.id">
              <ArticleCard :data="post"/>
            </li>
          </template>
        </ul>

        <Paginator
          :pageSize="pagination.size"
          :pageTotal="pagination.total"
          :page="pagination.current"
          @pageChange="pageChangeHanlder"
        />
      </div>
      <div>
        <Sidebar>
          <Profile author="blog-author"/>
          <RecentComment/>
          <Sticky
            :stickyTop="32 + 63"
            :endingElId="endEleId"
            dynamicElClass="#sticky-tag-box"
          >
            <TagBox/>
          </Sticky>
        </Sidebar>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent, onMounted, ref} from 'vue'
import {Feature, FeatureList} from '@/components/Feature'
import {ArticleCard, HorizontalArticle} from '@/components/ArticleCard'
import {MainTitle} from '@/components/Title'
import {Sidebar, TagBox, RecentComment, Profile} from '@/components/Sidebar'
import {usePostStore} from '@/stores/post'
import {FeaturePosts, PostList} from '@/models/Post.class'
import {useAppStore} from '@/stores/app'
import {useI18n} from 'vue-i18n'
import {useCategoryStore} from '@/stores/category'
import Paginator from '@/components/Paginator.vue'
import {useMetaStore} from '@/stores/meta'
import SvgIcon from '@/components/SvgIcon/index.vue'
import usePageTitle from '@/hooks/usePageTitle'
import Sticky from '@/components/Sticky.vue'


export default defineComponent({
  name: 'ARHome',
  components: {
    Feature,
    FeatureList,
    ArticleCard,
    HorizontalArticle,
    MainTitle,
    Sidebar,
    TagBox,
    Paginator,
    RecentComment,
    Profile,
    SvgIcon,
    Sticky
  },
  setup() {
    useMetaStore().setTitle('home')
    const postStore = usePostStore()
    const appStore = useAppStore()
    const categoryStore = useCategoryStore()
    const {updateTitleByText} = usePageTitle()
    const {t} = useI18n()

    /** Variables Section */

    const topFeature = ref(new FeaturePosts().topArticle)
    const featurePosts = ref(new FeaturePosts().features)
    const posts = ref(new PostList())
    const expanderClass = ref({
      'tab-expander': true,
      expanded: false
    })
    const tabClass = ref({
      tab: true,
      'expanded-tab': false
    })
    const activeTab = ref('')
    const articleOffset = ref(0)
    const pagination = ref({
      size: 12,
      total: 0,
      current: 1
    })

    /** Function section */

    const fetchData = async () => {
      await postStore.fetchFeaturePosts().then(() => {
        topFeature.value = postStore.featurePosts.topArticle
        featurePosts.value = postStore.featurePosts.features
      })
      await categoryStore.fetchCategories()
      await fetchPostData()
      updateTitleByText(appStore.themeConfig.site.subtitle)

      const articleListEl = document.getElementById('article-list')
      // 150 is the height of the header element
      articleOffset.value =
        articleListEl && articleListEl instanceof HTMLElement
          ? articleListEl.offsetTop
          : 0
    }
    onMounted(fetchData)

    const expandHandler = () => {
      expanderClass.value.expanded = !expanderClass.value.expanded
      tabClass.value['expanded-tab'] = !tabClass.value['expanded-tab']
    }

    const handleTabChange = (id: string) => {
      activeTab.value = id
      backToArticleTop()
      if (id !== '') {
        posts.value = new PostList()
        const param = {
          categoryId: id,
          size: pagination.value.size,
          current: pagination.value.current
        }
        postStore.fetchPostsByCategory(param).then(postList => {
          posts.value.records = postList.data
          pagination.value.total = postList.total
        })
      } else {
        fetchPostData()
      }
    }

    const backToArticleTop = () => {
      window.scrollTo({
        top: articleOffset.value,
        behavior: 'smooth'
      })
    }

    const activeTabStyle = (id: string) => {
      if (id === activeTab.value)
        return {background: appStore.themeConfig.theme.header_gradient_css}
      return {}
    }

    const fetchPostData = async () => {
      posts.value = new PostList()
      const param = {
        size: pagination.value.size,
        current: pagination.value.current,
        top: 0,
        featured: 0
      }
      await postStore.fetchPostsList(param).then(() => {
        posts.value = postStore.posts
        pagination.value.total = postStore.posts.total
        pagination.value.size = postStore.posts.size
      })
    }

    const pageChangeHanlder = async (page: number) => {
      pagination.value.current = page
      backToArticleTop()
      await fetchPostData()
    }

    return {
      endEleId: computed(() =>
        appStore.themeConfig.footerLinks.data.length > 0
          ? 'footer-link'
          : 'footer'
      ),
      gradientText: computed(
        () => appStore.themeConfig.theme.background_gradient_style
      ),
      gradientBackground: computed(() => {
        return {background: appStore.themeConfig.theme.header_gradient_css}
      }),
      themeConfig: computed(() => appStore.themeConfig),
      categories: computed(() => {
        if (categoryStore.isLoaded && categoryStore.categories.length === 0) {
          return null
        }
        return categoryStore.categories
      }),
      expanderClass,
      tabClass,
      expandHandler,
      handleTabChange,
      topFeature,
      featurePosts,
      posts,
      activeTabStyle,
      activeTab,
      pagination,
      pageChangeHanlder,
      t
    }
  }
})
</script>

<style lang="scss" scoped></style>
