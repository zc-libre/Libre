/* eslint-disable @typescript-eslint/no-explicit-any*/
import request from '@/utils/request'
import {HexoConfig} from '@/models/HexoConfig.class'
import {AxiosResponse} from 'axios'
import {
  AuthorPosts,
  Categories,
  Post,
  PostList,
  Tags
} from '@/models/Post.class'
import {Article, Page} from '@/models/Article.class'
import {Statistic} from '@/models/Statistic.class'
import {SearchIndexes} from '@/models/Search.class'

// GET /api/site.json
export async function fetchHexoConfig(): Promise<AxiosResponse<any>> {
  return request.get<HexoConfig>('/site.json')
}

// GET /api/posts/:pageNum.json (default 1.json)
export async function fetchPostsList(param: any): Promise<AxiosResponse<any>> {
  return request.get<PostList>(`/web/blog/article/page`, {params: param})
}

// GET /api/posts/:pageNum.json (default 1.json)
export async function fetchArchivesList(
  page: any
): Promise<AxiosResponse<any>> {
  return request.get<PostList>(`/web/blog/article/archives`)
}

// GET /api/tags/:TagName.json
export async function fetchPostsListByTag(
  param: any
): Promise<AxiosResponse<any>> {
  return await request.get<any>(`/web/blog/article/tagPage`, {
    params: param
  })
}

// GET /api/categories/:slug.json
export async function fetchPostsListByCategory(param: any) {
  return await request.get<any>(`/web/blog/article/page`, {
    params: param
  })
}

// GET /api/articles/:Slug.json
export async function fetchPostBySlug(id: string): Promise<AxiosResponse<any>> {
  return request.get<Article>(`/web/blog/article/${id}`)
}

// GET /api/tags.json
export async function fetchAllTags(): Promise<AxiosResponse<any>> {
  return request.get<Tags>(`/web/blog/tag/list`)
}

// GET /api/categories.json
export async function fetchAllCategories(): Promise<AxiosResponse<any>> {
  return request.get<Categories>(`/web/blog/category/list`)
}

// GET /api/pages/about/index.json
// source : e.g. about/index
export async function fetchImplicitPageBySource(
  source: string
): Promise<AxiosResponse<any>> {
  return request.get<Page>(`/pages/${source}/index.json`)
}

export async function fetchCommentInfo(
  param: any
): Promise<AxiosResponse<any>> {
  return request.get<any>(`/web/blog/comment/page`, {params: param})
}

export async function fetchMessageBoard(): Promise<AxiosResponse<any>> {
  return request.get<any>(`/web/blog/article/messageBoard`)
}

export async function saveComment(param: any): Promise<AxiosResponse<any>> {
  return request.post<any>(`/web/blog/comment/save`, param)
}

export async function fetchAbout(): Promise<AxiosResponse<any>> {
  return request.get<Page>(`/web/blog/article/about`)
}

// GET /api/features.json
export async function fetchFeature(): Promise<AxiosResponse<any>> {
  return request.get<Post[]>('/web/blog/article/topAndFeaturedArticles')
}

// GET /api/statistic.json
export async function fetchStatistic(): Promise<AxiosResponse<any>> {
  return request.get<Statistic>('/web/blog/article/statistic')
}

// GET /api/search.json
export async function fetchSearchIndexes(
  keyword: string
): Promise<AxiosResponse<any>> {
  return request.get<SearchIndexes[]>(
    '/web/blog/article/search?blurry=' + keyword
  )
}

// GET /api/authors/author-slug.json
export async function fetchAuthorPost(): Promise<AxiosResponse<any>> {
  return request.get<AuthorPosts>(`/web/blog/user/author`)
}

export async function fetchRecentComment(): Promise<AxiosResponse<any>> {
  return request.get<any>(`/web/blog/comment/recent`)
}

export async function login(
  client: any,
  code: string,
  state: string
): Promise<AxiosResponse<any>> {
  return request.get<any>(
    `/login/oauth2/code/${client}?code=${code}&state=${state}`
  )
}

