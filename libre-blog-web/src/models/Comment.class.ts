import {BlogUser} from '@/models/User.class'
import {CommentApi, CommentUserApi, ReplyApi} from 'undraw-ui'

export class RecentComment {
  data: CommentInfo[] = []

  constructor(raw?: []) {
    if (raw) {
      Object.assign(this, {
        data: raw.map((one: { [key: string]: [] }) => new CommentInfo(one))
      })
    }
  }
}

export class CommentPage {
  current = 0
  size = 0
  total = 0
  records: CommentInfo[] = []

  constructor(raw?: { [key: string]: [] }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'records') {
            Object.assign(this, {
              [key]: (raw[key] as Array<never>).map(
                (one: { [key: string]: [] }) => new CommentInfo(one)
              )
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}


export class ReplyComment implements ReplyApi {
  list: CommentInfo[] = []
  total = 0

  constructor(raw?: { [key: string]: any }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'list') {
            Object.assign(this, {
              [key]: (raw[key] as Array<never>).map(
                (one: { [key: string]: [] }) => new CommentInfo(one)
              )
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}

export class CommentInfo implements CommentApi {
  address = ''
  content = ''
  contentImg = ''
  createTime = ''
  id = ''
  likes = 0
  parentId = ''
  uid = ''
  user = new CommentUser()
  commentType = 0
  reply = new ReplyComment()
  os = ''
  browser = ''

  constructor(raw?: { [key: string]: any }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'user') {
            Object.assign(this, {
              [key]: new CommentUser(raw[key] as { [key: string]: any })
            })
          } else if (key === 'reply') {
            Object.assign(this, {
              [key]: new ReplyComment(raw[key] as { [key: string]: any })
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}

export class CommentUser implements CommentUserApi {
  avatar = ''
  homeLink = ''
  level = 0
  username = ''
  os = ''
  browser = ''
  address = ''

  constructor(raw?: { [key: string]: any }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }
    }
  }
}

export class Comment {
  id = ''
  parentId = ''
  userId = ''
  commentContent = ''
  commentType = ''
  createTime = ''
  replyUserId = ''
  user = new BlogUser()

  constructor(raw?: { [key: string]: [] }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'user') {
            Object.assign(this, {
              [key]: new BlogUser(raw[key] as { [key: string]: any })
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}
