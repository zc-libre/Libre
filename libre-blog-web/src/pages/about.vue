<template>
  <div class="mt-20">
    <Breadcrumbs :current="pageTitle"/>
    <PageContent :post="pageData" :enable-status="false" :title="pageTitle"/>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, onUnmounted, ref} from 'vue'
import {useArticleStore} from '@/stores/article'
import PageContent from '@/components/PageContent.vue'
import Breadcrumbs from '@/components/Breadcrumbs.vue'
import {useI18n} from 'vue-i18n'
import usePageTitle from '@/hooks/usePageTitle'
import {useCommonStore} from '@/stores/common'
import defaultCover from '@/assets/default-cover.jpg'
import {Post} from '@/models/Post.class'

export default defineComponent({
  name: 'ARAbout',
  components: {PageContent, Breadcrumbs},
  setup() {
    const commonStore = useCommonStore()
    const articleStore = useArticleStore()
    const pageData = ref(new Post())
    const {t} = useI18n()
    const {pageTitle, updateTitle} = usePageTitle()
    const fetchArticle = async () => {
      pageData.value = await articleStore.fetchAbout()
      commonStore.setHeaderImage(defaultCover)
      updateTitle()
      console.log(pageTitle)
      console.log(pageTitle.value)
    }

    onMounted(fetchArticle)
    onUnmounted(() => {
      commonStore.resetHeaderImage()
    })
    return {
      pageTitle,
      pageData,
      t
    }
  }
})
</script>

<style lang="scss" scoped></style>
