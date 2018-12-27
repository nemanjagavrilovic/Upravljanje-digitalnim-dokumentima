package com.example.demo.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;

import com.example.demo.model.ArticleEL;

public interface ArticleService {

	ArticleEL save(ArticleEL article);
	Iterable<ArticleEL> search(QueryBuilder query);
	Iterable<ArticleEL> findAll();
	Iterable<ArticleEL> saveAll(List<ArticleEL> articles);
	void delete(String id);
}
