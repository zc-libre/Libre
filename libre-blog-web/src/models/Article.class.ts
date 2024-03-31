import {Post} from '@/models/Post.class'
import {Comment} from '@/models/Comment.class'

export interface Detail {
  title: string
  date: { month: string; day: number; year: number }
  updated: string
  comments: boolean
  path: string
  covers: string | null
  excerpt: string | null
  content: string
  count_time: { symbolsTime?: string; symbolsCount?: number }
  toc: string
}

export interface Link {
  nick: string
  avatar: string
  link: string
  description: string
  label: string
}

export class Article extends Post implements Detail {
  title = ''
  date = {
    month: '',
    day: 0,
    year: 0
  }
  updated = ''
  comments = false
  path = ''
  covers: string | null = null
  excerpt: string | null = null
  content = ''
  count_time = {symbolsTime: undefined, symbolsCount: undefined}

  constructor(raw?: { [key: string]: [] }) {
    super(raw)
    if (raw) {
      for (const key of ['covers', 'content']) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }
    }
  }
}

export class Page {
  title = ''
  uid = ''
  date = {
    month: '',
    day: 0,
    year: 0
  }
  updated = ''
  comments = true
  path = ''
  cover: string | null = null
  content = ''
  count = {symbolsTime: undefined, symbolsCount: undefined}
  toc = ''
  text = ''
  records: Comment[] = []

  constructor(raw?: { [key: string]: string }) {
    if (raw) {
      for (const key of Object.keys(this)) {
        if (Object.prototype.hasOwnProperty.call(raw, key)) {
          Object.assign(this, {[key]: raw[key]})
        }
      }
    }
  }
}
