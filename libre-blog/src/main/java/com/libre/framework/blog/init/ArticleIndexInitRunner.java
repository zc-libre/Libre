package com.libre.framework.blog.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleIndexInitRunner implements ApplicationRunner {

	private final ElasticsearchOperations elasticsearchOperations;

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		IndexOperations indexOperations = elasticsearchOperations.indexOps(ArticleIndex.class);
//		if (!indexOperations.exists()) {
//			indexOperations.create();
//			indexOperations.getSettings().put("max_result_window", 100000);
//		}
	}
}
