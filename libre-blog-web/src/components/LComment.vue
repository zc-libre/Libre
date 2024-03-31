<template>
  <div>
    <u-comment-scroll :disable="disable" @more="more">
      <u-comment
        :config="config"
        @submit="submit"
        @like="like"
        @show-info="getUser"
        relative-time
        class="comment"
      >
        <template>导航栏卡槽</template>
        <!--        <template #info>
                  <div class="wl-meta" aria-hidden="true">
                    <span class="wl-addr" data-value="香港">{{ commentUser.address }}</span
                    ><span class="wl-browser" data-value="Edge119.0">{{ commentUser.browser }}</span
                    ><span class="wl-os" data-value="Windows 10">{{ commentUser.os }}</span>
                  </div>
                </template>-->
        <template #card>用户信息卡片卡槽</template>
        <template #opearte>操作栏卡槽</template>
        <template #func>功能区域卡槽</template>
      </u-comment>
    </u-comment-scroll>
  </div>
</template>
<script lang="ts">
import {defineComponent, onMounted, reactive, ref, toRefs} from 'vue'
import emoji from '@/assets/emoji/emoji'
import {saveComment} from '@/api'
import {useCommentStore} from '@/stores/comment'
import {ConfigApi, createObjectURL, SubmitParamApi, UToast} from 'undraw-ui'
import {
  CommentInfo,
  CommentPage,
  CommentUser,
  ReplyComment
} from '@/models/Comment.class'

export default defineComponent({
  name: 'Comment',
  components: {},
  props: {
    commentType: {
      type: Number,
      default: 0
    }
  },
  setup(props) {
    const commentType = toRefs(props).commentType
    const disable = ref(false)
    const commentStore = useCommentStore()
    const commentPage = ref(new CommentPage())
    const commentUser = ref(new CommentUser())

    const pagination = ref({
      size: 10,
      total: 0,
      current: 1,
      pages: 1
    })
    const config = reactive<ConfigApi>({
      user: {
        id: 1,
        username: '',
        avatar: '',
        // 评论id数组 建议:存储方式用户uid和评论id组成关系,根据用户uid来获取对应点赞评论id,然后加入到数组中返回
        likeIds: [1, 2, 3]
      },
      emoji: emoji,
      comments: [],
      total: 10,
      mentionConfig: {
        show: true
      }
    })

    const fetchComment = async () => {
      const param = {
        current: pagination.value.current,
        size: pagination.value.size,
        commentType: commentType.value
      }
      await commentStore.fetchCommentInfo(param).then(response => {
        commentPage.value = response
        pagination.value.total = response.total
        pagination.value.pages = response.pages
        config.comments = commentPage.value.records
        config.total = response.total
      })
    }
    onMounted(fetchComment)
    const submit = ({
                      content,
                      parentId,
                      files,
                      finish,
                      reply
                    }: SubmitParamApi) => {
      let contentImg = files?.map(e => createObjectURL(e)).join('||')
      const comment = new CommentInfo()
      comment.id = ''
      comment.content = content
      comment.parentId = String(parentId)
      comment.uid = String(config.user.id)
      comment.commentType = commentType.value

      setTimeout(async () => {
        await saveComment(comment).then(response => {
          comment.user = new CommentUser(config.user)
          comment.id = response.data.data
          fetchComment()
          UToast({message: '评论成功!', type: 'success'})
        })
      }, 200)
    }

    const like = (id: string, finish: () => void) => {
      console.log('点赞: ' + id)
      setTimeout(() => {
        finish()
      }, 200)
    }

    // 加载更多评论
    const more = async () => {
      if (config.comments.length < pagination.value.total) {
        pagination.value.current++
        await fetchComment()
      } else {
        disable.value = true
      }
    }

    const getUser = (uid: string, show: Function) => {
      console.log('获取用户信息: ' + uid)
      setTimeout(() => {
        commentPage.value.records.forEach(comment => {
          if (comment.uid === uid) {
            // commentUser.value = new CommentUser(comment.user)
            // commentUser.value.address = comment.address
            // commentUser.value.os = comment.os
            // commentUser.value.browser = comment.browser
          }
        })
        show()
      }, 200)
    }

    return {
      config,
      submit,
      like,
      more,
      disable,
      getUser,
      commentUser
    }
  }
})
</script>
<style lang="scss" scoped>
.comment {
  background-color: var(--background-secondary);
  color: var(--text-bright);
}

:deep(.comment-form) {
  border-radius: 0.5rem;
  background-color: var(--background-primary);
  padding: 1rem 5em 7em 1rem;
  position: relative;
  margin-bottom: 0.75em;
}

:deep(.u-editor) {
  @apply p-2 box-border bg-ob-deep-800 mx-1 my-0 opacity-50;
  transition: 0.3s opacity linear;

  &:focus {
    @apply opacity-100;
  }

  color: #888;
  max-width: 100%;
  position: relative;
  border: none;
  width: calc(100% - 1em);
  min-height: 8.75em;
  border-radius: 0.5em;
  resize: vertical;
  margin: 0 0.25rem;
  box-sizing: border-box;
  padding: 0.5rem;
  opacity: 0.5;
}

:deep(.content) {
  color: #888;
}

:deep(.el-button--primary) {
  background: var(--main-gradient);
  border: none;
  color: #fff;

  &:hover {
    color: #fff;
    opacity: 0.5;
  }
}

:deep(.reply-box) {
  background-color: var(--background-primary);
  color: #888;
}

:deep(.comment-list > .comment) {
  padding: 1em;
  border-radius: 0.5rem;
  background-color: var(--background-primary);
  margin-bottom: 1em;
}

.wl-meta > span {
  display: inline-block;
  margin-inline-end: 0.25em;
  padding: 2px 4px;
  border-radius: 0.2em;
  background-color: #272727;
  color: #666;
  font-size: var(--waline-info-font-size);
  line-height: 1.5;
}

:deep(.content) {
  margin-bottom: 1em;
}

:deep(.select-none) {
  display: flex;
  flex-direction: row-reverse;
}

:deep(.el-link) {
  color: #fff;
  font-size: 1em;
  font-weight: normal;
}

:deep(.scroll-btn) {
  background: var(--main-gradient);
  border: none;
  color: #fff;
  border-radius: 0.5em;

  &:hover {
    color: #fff;
    opacity: 0.5;
  }

  margin-top: 2em;

}

</style>
