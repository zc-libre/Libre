<template>
  <div>
    <el-dialog v-model='dialogFormVisible' title='登录' width='500' center append-to-body>
      <el-form :model='form' label-position='top' label-width='auto'>
        <el-form-item label='用户名'>
          <el-input v-model='form.username' autocomplete='off'/>
        </el-form-item>
        <el-form-item label='密码'>
          <el-input v-model='form.password' type='password' autocomplete='off' show-password/>
        </el-form-item>
      </el-form>
      <hr/>
      <div>
        <ul
          class='flex flex-row flex-wrap w-full py-4 px-2 text-center items-center justify-center'
          style='margin-left: 2px'
        >
          <li class='diamond-icon' @click="login('github')">
            <SvgIcon
              icon-class='color-github'
              class='fill-current'
              width='2em'
              height='2em'
            />
          </li>
          <li class='diamond-icon' @click="login('gitee')">
            <SvgIcon
              icon-class='color-gitee'
              class='fill-current'
              width='2em'
              height='2em'
            />
          </li>
          <li class='diamond-icon'>
            <SvgIcon
              icon-class='color-wechat'
              class='fill-current'
              width='2em'
              height='2em'
            />
          </li>
          <li class='diamond-icon'>
            <SvgIcon
              icon-class='color-qq'
              class='fill-current'
              width='2em'
              height='2em'
            />
          </li>
          <li class='diamond-icon'>
            <SvgIcon
              icon-class='color-weibo'
              class='fill-current'
              width='2em'
              height='2em'
            />
          </li>
        </ul>
      </div>
      <hr/>
      <template #footer>
        <div class='dialog-footer'>
          <el-button @click='closeLoginDialog'>Cancel</el-button>
          <el-button type='primary' @click='login'>
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>

    <el-dialog v-model='dialogRegisterFormVisible' title='注册' width='500'>
      <el-form :model='form'>
        <el-form-item label='Promotion name' :label-width='formLabelWidth'>
          <el-input v-model='form.username' autocomplete='off'/>
        </el-form-item>
        <el-form-item label='Zones' :label-width='formLabelWidth'>
          <el-input v-model='form.password' autocomplete='off'/>
        </el-form-item>
      </el-form>
      <hr/>
      <template #footer>
        <div class='dialog-footer'>
          <el-button @click='closeLoginDialog'>Cancel</el-button>
          <el-button type='primary' @click='login'>
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script lang='ts'>
import {defineComponent, onMounted, ref, reactive} from 'vue'
import SvgIcon from '@/components/SvgIcon/index.vue'
import emitter from '@/utils/mitt'
import {useUserStore} from '@/stores/user'
import {useRouter} from 'vue-router'

export default defineComponent({
  name: 'LoginForm',
  components: {SvgIcon},
  setup() {
    const formLabelWidth = '80px'
    const dialogFormVisible = ref(false)
    const dialogRegisterFormVisible = ref(false)
    const userStore = useUserStore()
    const baseUrl = import.meta.env.VITE_APP_BASE_API
    const router = useRouter()
    const client = ref('')
    const form = reactive({
      username: '',
      password: '',
      validCode: ''
    })

    emitter.on('dialogVisibility', (val) => {
      dialogFormVisible.value = val.showLogin
    })

    const closeLoginDialog = () => {
      dialogFormVisible.value = false
      emitter.emit('dialogVisibility', {showLogin: dialogFormVisible.value})
    }
    const login = (clientId) => {
      client.value = clientId
      userStore.setClientId(clientId)
      window.location.href = encodeURI(
        baseUrl + '/oauth2/authorization/' + clientId
      )
    }
    const handleOAuth2Response = () => {
      try {
        // 获取从OAuth2 Provider返回的访问令牌
        const params = new URLSearchParams(window.location.search)
        const code = params.get('code')
        const state = params.get('state')
        if (!code || !state) {
          return
        }
        const clientId = userStore.getClientId()
        // 向后端发送请求以获取访问令牌
        userStore.login(clientId, code, state).then(res => {
          console.log(res)
        })
        // 保存访问令牌
        // 认证成功，重定向到主页或其他受保护的路由
        router.push('/')
      } catch (error) {
        console.error('Failed to handle OAuth2 response:', error)
        // 处理错误，可能是登录失败或其他错误
        router.push('/')
      }
    }
    onMounted(handleOAuth2Response)
    return {
      formLabelWidth,
      form,
      dialogFormVisible,
      closeLoginDialog,
      login,
      dialogRegisterFormVisible
    }
  }
})
</script>
