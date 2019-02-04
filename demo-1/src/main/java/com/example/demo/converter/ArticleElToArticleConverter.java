package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Article;
import com.example.demo.model.ArticleEL;


@Component
public class ArticleElToArticleConverter implements Converter<ArticleEL, Article>{

	@Autowired
	private ReviewerToUserConverter reviewerToUserConverter;
	
	@Override
	public Article convert(ArticleEL arg0) {
		// TODO Auto-generated method stub
		Article article = new Article();
		article.setAbstracts(arg0.getAbstracts());
		article.setContent(arg0.getText());
		article.setFilename(arg0.getFilename());
		article.setMagazineName(arg0.getMagazineName());
		article.setKeywords(arg0.getKeywords());
		article.setScientificField(arg0.getScientificField());
		article.setTitle(arg0.getTitle());
		article.setAuthors(reviewerToUserConverter.convertList(arg0.getAuthors()));
		article.setReviewers(reviewerToUserConverter.convertList(arg0.getReviewers()));
		
		return article;
	}

	public List<Article> convertList(List<ArticleEL> articles) {
		List<Article> list = new ArrayList<>();
		if(articles != null) {
			for(ArticleEL article : articles) {
				list.add(convert(article));
			}
		}
		return list;
	}
}
