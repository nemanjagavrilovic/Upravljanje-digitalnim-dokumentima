package com.example.demo.repository;




import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.ArticleEL;

public interface ArticlesRepository  extends ElasticsearchRepository<ArticleEL,String> {

	Iterable<ArticleEL> findByMagazineName(String name);
	Iterable<ArticleEL> findByTitle(String title);

}
