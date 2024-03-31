<template>
  <div class="sidebar-box">
    <SubTitle :title="'titles.recent_comment'" icon="quote"/>
    <ul>
      <template v-if="comments.length > 0">
        <li
          class="bg-ob-deep-900 px-2 py-2 mb-1.5 rounded-lg shadow-sm transition-all duration-300 ease-in-out hover:scale-105"
          v-for="comment in comments"
          :key="comment.id"
        >
          <a
            :href="`${comment.html_url}#${comment.id}`"
            class="flex flex-row justify-items-center items-stretch cursor-pointer hover:opacity-100"
          >
            <div class="flex justify-start items-start">
              <img
                :class="avatarClass"
                :src="comment.user.avatar"
                alt="comment-avatar"
              />
            </div>
            <div class="flex-1 text-xs">
              <div class="text-xs mb-2 pt-1">
                  <span class="text-ob-secondary pr-2">
                    <a class="font-bold" :href="comment.user.html_url">{{
                        comment.user.username
                      }}</a>
                    <b
                      class="ml-2 text-ob bg-ob-deep-800 py-0.5 px-1.5 rounded-md"
                      v-if="comment.is_admin"
                    >
                      {{ t('settings.admin-user') }}
                    </b>
                  </span>
                <span class="text-ob-dim text-[0.65rem]">{{
                    comment.createTime
                  }}</span>
              </div>
              <div class="text-xs pb-1">
                {{ comment.content }}
              </div>
            </div>
          </a>
        </li>
      </template>
      <div
        v-else
        class="flex flex-row justify-center items-center text-ob-dim"
      >
        <SvgIcon
          class="mr-2"
          icon-class="warning"
          :svgType="SvgTypes.stroke"
          stroke="var(--text-dim)"
        />
        {{ t('settings.empty-recent-comments') }}
      </div>
    </ul>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent, watch, ref} from 'vue'
import {SubTitle} from '@/components/Title'
import SvgIcon from '@/components/SvgIcon/index.vue'
import {useAppStore} from '@/stores/app'
import {useI18n} from 'vue-i18n'
import {SvgTypes} from '@/components/SvgIcon/index.vue'
import {useCommentStore} from '@/stores/comment'
import {RecentComment} from '@/models/Comment.class'

export default defineComponent({
  name: 'ArRecentComment',
  components: {SubTitle, SvgIcon},
  setup() {
    const appStore = useAppStore()
    const commentStore = useCommentStore()
    const {t} = useI18n()
    const recentComment = ref(new RecentComment().data)

    const fetchRecentComment = async () => {
      await commentStore.fetchRecentComment().then(() => {
        recentComment.value = commentStore.recentComment
        console.log(recentComment.value)
      })
    }

    /** Wait for config is ready */
    watch(
      () => appStore.configReady,
      (newValue, oldValue) => {
        if (!oldValue && newValue) {
          fetchRecentComment()
        }
      }
    )

    return {
      avatarClass: computed(() => {
        return {
          'col-span-1 mr-2 h-6 w-6': true,
          [appStore.themeConfig.theme.profile_shape]: true
        }
      }),
      comments: computed(() => recentComment.value),
      isConfigReady: computed(() => appStore.configReady),
      SvgTypes,
      fetchRecentComment,
      t
    }
  },
  mounted() {
    if (this.isConfigReady) {
      this.fetchRecentComment()
    }
  }
})
</script>

<style lang="scss" scoped></style>
