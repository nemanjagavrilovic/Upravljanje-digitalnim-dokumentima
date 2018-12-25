package com.example.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder.Item;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Article;
import com.example.model.User;
import com.example.service.ArticleService;

@RestController
@RequestMapping(value="/articles")
public class ArticleController {
/*
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/findReviewers", method=RequestMethod.GET)
	public ResponseEntity<List<User>> moreLikeThis(@RequestBody String text){
		String [] textForSearch = {text};
		String [] fields = {"text"};
		Iterable<Article> allArticles = articleService.findAll();
		int number=0;
		for(Article article : allArticles){
			number++;
		}
		Item [] items = new Item[number];
		int count=0;
		for(Article article : allArticles){
			items[count] = new Item("articles","articles",article.getArticle_id());
			count++;
		}
		
		MoreLikeThisQueryBuilder query = QueryBuilders.moreLikeThisQuery(fields,textForSearch,items)
				.minTermFreq(1)
				.minDocFreq(1);
		Iterable<Article> articles = articleService.search(query);
		List<User> reviewers = new ArrayList<>();
		for(Article article : articles){
			reviewers.addAll(article.getReviewers());
		}
		return new ResponseEntity<List<User>>(reviewers,HttpStatus.OK);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody List<Article> articles){
		articleService.saveAll(articles);
		return new ResponseEntity<String>("S",HttpStatus.OK);
	}
	
	@RequestMapping(value ="/findAll", method= RequestMethod.GET)
	public Iterable<Article> findAll(){
		return articleService.findAll();
	}
	@RequestMapping(value ="/delete", method= RequestMethod.DELETE)
	public void delete(){
		 articleService.delete("1");
	}*/
}
