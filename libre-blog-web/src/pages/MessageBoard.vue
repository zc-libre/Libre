<template>
  <div class="mt-20">
    <Breadcrumbs :current="'留言板'"/>
    <PageContent :post="messageBoard" :enable-status="false" :title="'留言板'">
      <div id="comments">
        <Comment :body="messageBoard.content" :comment-type="3"/>
      </div>
    </PageContent>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent, onBeforeMount, ref, watch} from 'vue'
import {Page} from '@/models/Article.class'
import {useI18n} from 'vue-i18n'
import {useRoute} from 'vue-router'
import {useAppStore} from '@/stores/app'
import {useMetaStore} from '@/stores/meta'
import {useCommentStore} from '@/stores/comment'
import PageContent from '@/components/PageContent.vue'
import Breadcrumbs from '@/components/Breadcrumbs.vue'
import Comment from '@/components/Comment.vue'
import {Locales} from '@/models/ThemeConfig.class'
import {Post} from '@/models/Post.class'

export default defineComponent({
  name: 'ARPage',
  components: {PageContent, Breadcrumbs, Comment},
  setup() {
    const appStore = useAppStore()
    const metaStore = useMetaStore()
    const pageData = ref(new Page())
    const route = useRoute()
    const {t} = useI18n()
    const pageTitle = ref()
    const commentStore = useCommentStore()
    const messageBoard = ref(new Post())

    const fetchMessageBoard = async () => {
      await commentStore.fetchMessageBoard().then(response => {
        messageBoard.value = response
        messageBoard.value.enableComment = 1
        updateTitle()
      })
    }
    const updateTitle = (locale?: Locales) => {
      const currentLocale = locale ?? 'zh-CN'
      const routeInfo = appStore.themeConfig.menu.menus['messageBoard']
      console.log(pageTitle.value)
      pageTitle.value =
        (routeInfo.i18n && routeInfo.i18n[currentLocale]) || routeInfo.name
      metaStore.setTitle(pageTitle.value)
    }

    watch(
      () => appStore.locale,
      value => {
        if (value) {
          updateTitle(value)
        }
      }
    )

    onBeforeMount(fetchMessageBoard)

    return {
      enabledComment: computed(() => pageData.value.comments),
      pageTitle: computed(() => pageTitle.value),
      pageData,
      t,
      messageBoard
    }
  }
})
</script>

<style lang="scss" scoped></style>
