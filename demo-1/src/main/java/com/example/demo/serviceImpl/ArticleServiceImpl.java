package com.example.demo.serviceImpl;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ArticleEL;
import com.example.demo.repository.ArticlesRepository;
import com.example.demo.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticlesRepository articleRepository;
	
	@Override
	public ArticleEL save(ArticleEL article) {
		// TODO Auto-generated method stub
		return articleRepository.save(article);
	}

	@Override
	public Iterable<ArticleEL> search(QueryBuilder query) {
		// TODO Auto-generated method stub
		return articleRepository.search(query);
	}

	@Override
	public Iterable<ArticleEL> findAll() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		articleRepository.deleteAll();
		
	}

	@Override
	public Iterable<ArticleEL> saveAll(List<ArticleEL> articles) {
		// TODO Auto-generated method stub
		return articleRepository.saveAll(articles);
	}
}
