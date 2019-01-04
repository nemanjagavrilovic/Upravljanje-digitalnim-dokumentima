package com.example.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Article;
import com.example.demo.model.ArticleEL;

@Component
public class ArticlesToArticleEL implements Converter<Article,ArticleEL>{

	@Autowired
	private UserToReviewerConverter userToReviewerConverter;
	
	@Override
	public ArticleEL convert(Article arg0) {
		// TODO Auto-generated method stub
		ArticleEL article = new ArticleEL();
		article.setAbstracts(arg0.getAbstracts());
		article.setAuthors(userToReviewerConverter.convertList(arg0.getAuthors()));
		article.setKeywords(arg0.getKeywords());
		article.setMagazineName(arg0.getMagazineName());
		article.setReviewers(userToReviewerConverter.convertList(arg0.getReviewers()));
		article.setTitle(arg0.getTitle());
		article.setText(arg0.getContent());
		return article;
	}
	

}
