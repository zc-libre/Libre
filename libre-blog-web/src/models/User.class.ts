export class BlogUser {
  id = ''
  username = ''
  nickName = ''
  avatar = ''
  description = ''
  email = ''
  phone = ''
  token = ''

  constructor(raw?: { [key: string]: number }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }
    }
  }
}
