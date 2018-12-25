package com.example.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;

import com.example.model.Article;
import com.example.model.Reviewer;

public interface ArticleService {

	Article save(Article article);
	Iterable<Article> search(QueryBuilder query);
	Iterable<Article> findAll();
	Iterable<Article> saveAll(List<Article> articles);
	void delete(String id);
}
