import {Social} from './ThemeConfig.class'

export interface PostRaw {
  [key: string]: Array<any> | string | { [key: string]: any }
}

export interface SpecificPostListRaw {
  pages: number
  size: number
  total: number
  records: PostRaw[]
}

export class NavPost {
  title = ''
  uid = ''
  slug = ''
  date = ''
  updated = ''
  comments = ''
  path = ''
  keywords = ''
  cover = ''
  text = ''
  link = ''
  photos = ''
  count_time = {}
  categories = {}
  tags = {}
  author = {}

  constructor(raw?: { [key: string]: Array<any> | string }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }
    }
  }
}

export class Post {
  articleName = ''
  id = ''
  uid = ''
  slug = ''
  date: { month: string; day: number; year: number } = {
    month: '',
    day: 0,
    year: 0
  }
  count: { symbolsCount: string; symbolsTime: string } = {
    symbolsCount: '0k',
    symbolsTime: '0mins'
  }
  updated = ''
  comments = true
  path = ''
  excerpt: string | null = null
  keywords: string | null = null
  cover = ''
  content: string | null = null
  text = ''
  summary = ''
  link = ''
  raw: string | null = null
  photos: string[] = []
  categories: Category[] = []
  category = {
    id: '',
    categoryName: ''
  }
  tags: Tag[] = []
  min_tags: Tag[] = []
  count_time: { symbolsTime?: string; symbolsCount?: number } = {}
  toc = ''
  nextArticle: { articleName?: string } = {}
  preArticle: { articleName?: string } = {}
  author = {
    id: '',
    name: '',
    avatar: '',
    link: '',
    slug: ''
  }
  enableComment: number | undefined = undefined
  featured = 0
  top = 0

  constructor(raw?: PostRaw) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'categories') {
            Object.assign(this, {
              [key]: (raw[key] as Array<never>).map(
                (one: { [key: string]: [] }) => new Category(one)
              )
            })
          } else if (key === 'category') {
            Object.assign(this, {
              [key]: new Category(raw[key] as { [key: string]: any })
            })
          } else if (key === 'tags') {
            Object.assign(this, {
              [key]: (raw[key] as Array<never>).map(
                (one: { [key: string]: [] }) => new Tag(one)
              )
            })
            this.min_tags = this.tags.filter((value, index) => {
              if (index < 2) return true
            })
          } else if (key === 'prev_post' || key === 'next_post') {
            Object.assign(this, {
              [key]: new NavPost(raw[key] as { [key: string]: any })
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}

export class PostList {
  records: Post[] = []
  pageCount = 0
  size = 0
  total = 0

  constructor(raw?: { [key: string]: [] }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'records') {
            Object.assign(this, {
              [key]: raw[key].map((one: { [key: string]: [] }) => new Post(one))
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}

export class SpecificPostsList {
  data: Post[] = []
  pages = 0
  size = 0
  total = 0

  constructor(raw?: SpecificPostListRaw) {
    if (raw && raw.records) {
      Object.assign(this, {
        data: raw.records.map(one => new Post(one)),
        pageCount: raw.pages,
        pageSize: raw.size,
        total: raw.total
      })
    }
  }
}

export class FeaturePosts {
  topArticle = {}
  features: Post[] = []

  constructor(raw?: { [key: string]: any }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'topArticle') {
            Object.assign(this, {[key]: new Post(raw[key])})
          } else if (key === 'features') {
            Object.assign(this, {
              features: raw[key].map(
                (one: { [key: string]: [] }) => new Post(one)
              )
            })
          }
        }
      }
    }
  }
}

export class AuthorPosts {
  name = ''
  id = ''
  avatar = ''
  link = ''
  description = ''
  socials = new Social()
  categories = 0
  tags = 0
  word_count = '0'
  articles = 0

  constructor(raw?: { [key: string]: any }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'socials') {
            Object.assign(this, {[key]: new Social(raw[key])})
          } else if (key === 'post_list') {
            Object.assign(this, {
              post_list: raw[key].map(
                (one: { [key: string]: [] }) => new Post(one)
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

export class Categories {
  data: Category[] = []

  constructor(raw?: []) {
    if (raw) {
      Object.assign(this, {
        data: raw.map((one: { [key: string]: [] }) => new Category(one))
      })
    }
  }
}

export class Category {
  categoryName = ''
  id = ''
  path = ''
  count = 0
  parent = ''

  constructor(raw?: { [key: string]: [] }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }

      if (!(raw instanceof Category)) {
        this.parent = this.id
          .split('/')
          .filter((v, i, a) => i !== a.length - 1)
          .join('/')
      }
    }
  }
}

export class Tags {
  data: Tag[] = []

  constructor(raw?: []) {
    if (raw) {
      Object.assign(this, {
        data: raw.map((one: { [key: string]: [] }) => new Tag(one))
      })
    }
  }
}

export class Tag {
  tagName = ''
  id = ''
  path = ''
  count = 0

  constructor(raw?: { [key: string]: [] }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }
    }
  }
}

export class Archives {
  records: {
    month: string
    year: string
    posts: Post[]
  }[] = []
  pages = 0
  size = 0
  total = 0

  constructor(raw?: { [key: string]: [] }) {
    const postData = new Map()

    if (raw) {
      console.log(raw)
      for (const key of Object.keys(this)) {
        console.log(key)
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          if (key === 'records') {
            console.log(raw[key])
            // Use the natural of hashmap keys to
            // group posts with month and year
            raw[key].forEach((one: { [key: string]: [] }) => {
              const post = new Post(one)
              const groupKey = `${post.date.month}-${post.date.year}`

              if (postData.has(groupKey)) {
                const groupedPost = postData.get(groupKey)
                groupedPost.posts.push(post)
              } else {
                postData.set(groupKey, {
                  month: post.date.month,
                  year: post.date.year,
                  posts: [post]
                })
              }
            })
            // Covert map back to object array
            const data = []
            for (const item of postData.values()) {
              data.push(item)
            }
            // Assigning data
            Object.assign(this, {
              records: data
            })
          } else {
            Object.assign(this, {[key]: raw[key]})
          }
        }
      }
    }
  }
}
