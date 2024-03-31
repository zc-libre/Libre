export class SearchIndex {
  id = ''
  articleName = ''
  content = ''
  slug = ''
  date = ''
  categories_index = ''
  tags_index = ''
  author_index = ''

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

export type SearchResultType = {
  id: string
  articleName: string
  content: string
  slug: string
}

export class SearchResult {
  id = ''
  articleName = ''
  content = ''
  slug = ''

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

export class RecentSearchResults {
  data = new Map()
  capacity = 5
  cacheKey = 'ob-recent-search-results-key'

  constructor(raw?: { [key: string]: string }[]) {
    if (raw) {
      this.initData(raw)
    }
  }

  initData(data: { [key: string]: string }[]): void {
    data.forEach(value => {
      this.add(value)
    })
  }

  /** Fetch data from the cache */
  getData(): { [key: string]: string }[] | [] {
    const cache = localStorage.getItem(this.cacheKey)
    if (cache === null) return []

    let cacheResults = JSON.parse(cache)
    cacheResults = cacheResults.map((result: any) => {
      return {
        articleName: result.value.articleName,
        content: result.value.content,
        id: result.value.id
      }
    })
    if (cacheResults.length > this.data.size) {
      this.initData(cacheResults.reverse())
    }

    return cacheResults
  }

  /** Caching the recent search results */
  cache(): void {
    localStorage.setItem(this.cacheKey, JSON.stringify(this.toArray()))
  }

  /**
   * Convert the Map into an Array
   * also reverse the order of the records.
   */
  toArray(): { [key: string]: string }[] {
    return Array.from(this.data, ([name, value]) => ({name, value})).reverse()
  }

  /**
   * Adding the recent search results into the
   * Map, remove the first one come into the cache
   * if the cache reach it's maximum capacity.
   */
  add(result: { [key: string]: string }): void {
    const searchResult = new SearchResult(result)
    if (this.data.has(searchResult.id)) return

    if (this.data.size === this.capacity) {
      // Remove the first one added into the cache.
      this.data.delete(this.data.keys().next().value)
    }

    this.data.set(searchResult.id, searchResult)
    this.cache()
  }

  remove(slug: string): void {
    if (!this.data.has(slug)) return
    this.data.delete(slug)
    this.cache()
  }
}

export class SearchIndexes {
  indexes: SearchIndex[] = []
  contentLimit = 100

  constructor(raw?: { [key: string]: string }[]) {
    if (raw) {
      this.indexes = raw.map(
        (index: { [key: string]: string }) => new SearchIndex(index)
      )
    }
  }

  /**
   * Search the prebuilt searchIndexes
   * and return base on page.
   */
  searchByPage(
    query: string,
    page?: number,
    perPage?: number
  ): SearchResultType[] | [] {
    page = !page ? 1 : page
    perPage = !perPage ? 12 : perPage
    const results = this.search(query)
    const length = results.length

    if (length <= perPage) return results

    const start = page * perPage
    const end = start + perPage > length ? length : start + perPage
    return results.slice(start, end)
  }

  /**
   * Search the prebuilt searchIndexes
   * by using string parsing.
   */
  search(query: string): SearchResultType[] | [] {
    // Breaking up keywords by space and `-`
    const keywords = query
      .trim()
      .toLocaleLowerCase()
      .split(/[\s-]+/)

    const matchedResult: SearchResultType[] = []

    this.indexes.forEach(data => {
      if (!data.articleName || data.articleName.trim() === '')
        data.articleName = 'Untitled'

      const originalTitle = data.articleName
      const originalContent = data.content
      const dataId = data.id

      let isMatch = this.indexes.length > 0
      if (isMatch) {
        matchedResult.push({
          id: dataId,
          articleName: originalTitle,
          content: originalContent,
          slug: dataId
        })
      }
    })
    return matchedResult
  }
}
