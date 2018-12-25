package com.example.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.model.Article;

public interface ArticlesRepository  extends ElasticsearchRepository<Article,String> {

}
