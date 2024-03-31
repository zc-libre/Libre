<template>
  <div id="footer" class="relative w-full pt-1" :style="gradientBackground">
    <span class="bg-ob-deep-800 flex justify-center">
      <div
        class="bg-ob-deep-800 rounded-lg max-w-10/12 lg:max-w-screen-2xl text-sm text-ob-normal w-full py-6 px-6 grid grid-rows-1 lg:grid-rows-none lg:grid-cols-4 justify-center items-center gap-8"
        style='display:flex; justify-content: center'
      >
        <div
          class="flex flex-col lg:flex-row gap-6 lg:gap-12 row-span-1 lg:col-span-3 text-center lg:text-center"

        >
          <div class="flex flex-col gap-1.5">
            <div>
              Copyright © 2019 - {{ currentYear }}
              <b class="font-extrabold">{{ themeConfig.site.author }}</b>
              . All Rights Reserved.
            </div>
          </div>
          <div class="flex flex-col flex-1 gap-1.5">
            <div v-if="runningDays" class="flex flex-row max-w-[11rem]">
              <span>
                <SvgIcon
                  icon-class="date"
                  class="mr-1 text-lg inline-block"
                  stroke="currentColor"
                />
                {{ t('settings.site-running-for') }}
              </span>
              <span class="flex-1 text-right"
              >{{ runningDays }}
                {{ t('settings.site-running-for-unit') }}</span
              >
            </div>
          </div>
        </div>
      </div>
    </span>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent, nextTick, watch} from 'vue'
import {useAppStore} from '@/stores/app'
import {useI18n} from 'vue-i18n'
import SvgIcon, {SvgTypes} from '@/components/SvgIcon/index.vue'
import beianImg from '@/assets/gongan-beian-40-40.png'
import {getDaysTillNow} from '@/utils'
import useCommentPlugin from '@/hooks/useCommentPlugin'

export default defineComponent({
  name: 'ObFooter',
  components: {SvgIcon},
  setup() {
    const appStore = useAppStore()
    const {t} = useI18n()
    const {enabledCommentPlugin, intiCommentPluginPageView} =
      useCommentPlugin()

    watch(
      () => appStore.configReady,
      async (newValue, oldValue) => {
        if (!oldValue && newValue) {
          await nextTick()
          intiCommentPluginPageView('/')
        }
      }
    )

    return {
      SvgTypes,
      beianImg,
      avatarClass: computed(() => {
        return {
          'footer-avatar': true,
          [appStore.themeConfig.theme.profile_shape]: true
        }
      }),
      gradientText: computed(
        () => appStore.themeConfig.theme.background_gradient_style
      ),
      gradientBackground: computed(() => {
        return {background: appStore.themeConfig.theme.header_gradient_css}
      }),
      currentYear: computed(() => new Date().getUTCFullYear()),
      themeConfig: computed(() => appStore.themeConfig),
      configReady: computed(() => appStore.configReady),
      runningDays: computed(() => {
        if (appStore.themeConfig.site.started_date === '') return undefined
        return getDaysTillNow(`${appStore.themeConfig.site.started_date}`)
      }),
      intiCommentPluginPageView,
      enabledPlugin: computed(() => enabledCommentPlugin.value.plugin),
      t
    }
  }
})
</script>

<style lang="scss" scoped></style>
