package com.libre.framework.blog.search;

import co.elastic.clients.elasticsearch._types.query_dsl.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.google.common.collect.Lists;
import com.libre.framework.blog.pojo.Article;
import com.libre.framework.blog.pojo.dto.ArticleCriteria;
import com.libre.framework.blog.pojo.dto.ArticleIndex;
import com.libre.toolkit.core.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.HighlightQuery;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightParameters;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.libre.framework.blog.pojo.dto.ArticleIndex.ARTICLE_NAME;
import static com.libre.framework.blog.pojo.dto.ArticleIndex.CONTENT;

@Component
@RequiredArgsConstructor
public class ElasticSearchHandler implements ArticleSearchHandler {

	private final ElasticsearchOperations elasticsearchOperations;

	@Override
	public List<ArticleIndex> search(PageDTO<Article> page, ArticleCriteria criteria) {
		NativeQueryBuilder nativeQueryBuilder = NativeQuery.builder();
		String blurry = criteria.getBlurry();
		if (StringUtil.isBlank(blurry)) {
			return Collections.emptyList();
		}

		HighlightParameters.HighlightParametersBuilder highlightParametersBuilder = new HighlightParameters.HighlightParametersBuilder();
		HighlightParameters highlightParameters = highlightParametersBuilder.withPreTags("<mark>")
			.withPostTags("</mark>")
			.withFragmentSize(30)
			.build();

		HighlightField articleNameField = new HighlightField(ARTICLE_NAME);
		HighlightField contentField = new HighlightField(CONTENT);
		Highlight highlight = new Highlight(highlightParameters, Lists.newArrayList(articleNameField, contentField));
		HighlightQuery highlightQuery = new HighlightQuery(highlight, ArticleIndex.class);
		nativeQueryBuilder.withHighlightQuery(highlightQuery);

		nativeQueryBuilder.withQuery(query -> {

			query.bool(b -> b.should(should -> {

				matchPhraseQuery(should, ARTICLE_NAME, blurry);

				stringQuery(should, ARTICLE_NAME, blurry);

				prefixQuery(should, ARTICLE_NAME, blurry);

				matchPhrasePrefixQuery(should, ARTICLE_NAME, blurry);

				multiMatchQuery(should, blurry);

				return should;
			}));
			return query;
		});

		nativeQueryBuilder.withTrackTotalHits(true);
		NativeQuery nativeQuery = nativeQueryBuilder.build();
		SearchHits<ArticleIndex> hits = elasticsearchOperations.search(nativeQuery, ArticleIndex.class);
		return getArticleIndices(hits);
	}

	private static List<ArticleIndex> getArticleIndices(SearchHits<ArticleIndex> hits) {
		List<ArticleIndex> articleList = Lists.newArrayList();
		for (SearchHit<ArticleIndex> searchHit : hits.getSearchHits()) {
			Map<String, List<String>> highlightFieldMap = searchHit.getHighlightFields();
			ArticleIndex articleIndex = searchHit.getContent();

			if (highlightFieldMap.containsKey(ARTICLE_NAME)) {
				List<String> highlightValues = highlightFieldMap.get(ARTICLE_NAME);
				articleIndex.setArticleName(highlightValues.get(0));
			}

			if (highlightFieldMap.containsKey(CONTENT)) {
				List<String> highlightValues = highlightFieldMap.get(CONTENT);
				articleIndex.setContent(highlightValues.get(0));
			}
			else {
				articleIndex.setContent(null);
			}

			articleList.add(articleIndex);
		}
		return articleList;
	}

	private static void multiMatchQuery(Query.Builder should, String blurry) {
		MultiMatchQuery.Builder builder = new MultiMatchQuery.Builder();
		builder.fields(ARTICLE_NAME, CONTENT);
		MultiMatchQuery multiMatchQuery = builder.query(blurry).build();
		should.multiMatch(multiMatchQuery);
	}

	private static void matchQuery(Query.Builder should, String field, String blurry) {
		MatchQuery.Builder matchQueryBuilder = new MatchQuery.Builder();
		matchQueryBuilder.field(field);
		matchQueryBuilder.query(blurry);
		matchQueryBuilder.boost(1F);
		should.match(matchQueryBuilder.build());
	}

	private static void matchPhrasePrefixQuery(Query.Builder should, String field, String blurry) {
		MatchPhrasePrefixQuery.Builder matchPhrasePrefixQueryBuilder = new MatchPhrasePrefixQuery.Builder();
		matchPhrasePrefixQueryBuilder.field(field);
		matchPhrasePrefixQueryBuilder.query(blurry);
		matchPhrasePrefixQueryBuilder.boost(7F);
		should.matchPhrasePrefix(matchPhrasePrefixQueryBuilder.build());
	}

	private static void prefixQuery(Query.Builder should, String field, String blurry) {
		PrefixQuery.Builder perfixQueryBuilder = new PrefixQuery.Builder();
		perfixQueryBuilder.field(field + ".keyword");
		perfixQueryBuilder.value(blurry);
		perfixQueryBuilder.boost(8F);
		should.prefix(perfixQueryBuilder.build());
	}

	private static void stringQuery(Query.Builder should, String field, String blurry) {
		QueryStringQuery.Builder queryStringBuilder = new QueryStringQuery.Builder();
		queryStringBuilder.fields(field, field + ".keyword")
			.query(blurry)
			.fuzzyPrefixLength(2)
			.fuzzyMaxExpansions(20)
			.fuzzyTranspositions(true)
			.allowLeadingWildcard(false)
			.boost(9F);
		should.queryString(queryStringBuilder.build());
	}

	private static void matchPhraseQuery(Query.Builder should, String field, String keyWord) {
		MatchPhraseQuery.Builder matchPhraseQueryBuilder = new MatchPhraseQuery.Builder();
		matchPhraseQueryBuilder.field(field);
		matchPhraseQueryBuilder.query(keyWord);
		matchPhraseQueryBuilder.boost(10F);
		should.matchPhrase(matchPhraseQueryBuilder.build());
	}

}
