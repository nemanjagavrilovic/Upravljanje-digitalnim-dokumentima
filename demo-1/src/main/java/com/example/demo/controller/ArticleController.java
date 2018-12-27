package com.example.demo.controller;

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

import com.example.demo.model.Article;
import com.example.demo.model.ArticleEL;
import com.example.demo.model.User;
import com.example.demo.service.ArticleService;

@RestController
@RequestMapping(value="/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/findReviewers", method=RequestMethod.GET)
	public ResponseEntity<List<User>> moreLikeThis(@RequestBody String text){
		String [] textForSearch = {text};
		String [] fields = {"text"};
		Iterable<ArticleEL> allArticles = articleService.findAll();
		int number=0;
		for(ArticleEL article : allArticles){
			number++;
		}
		Item [] items = new Item[number];
		int count=0;
		for(ArticleEL article : allArticles){
			items[count] = new Item("articles","articles",article.getArticle_id());
			count++;
		}
		
		MoreLikeThisQueryBuilder query = QueryBuilders.moreLikeThisQuery(fields,textForSearch,items)
				.minTermFreq(1)
				.minDocFreq(1);
		Iterable<ArticleEL> articles = articleService.search(query);
		List<User> reviewers = new ArrayList<>();
		for(ArticleEL article : articles){
			reviewers.addAll(article.getReviewers());
		}
		return new ResponseEntity<List<User>>(reviewers,HttpStatus.OK);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody List<ArticleEL> articles){
		articleService.saveAll(articles);
		return new ResponseEntity<String>("S",HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/delete", method= RequestMethod.DELETE)
	public void delete(){
		 articleService.delete("1");
	}
}
