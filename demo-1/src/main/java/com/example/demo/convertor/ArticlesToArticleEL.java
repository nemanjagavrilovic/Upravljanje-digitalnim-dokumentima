package com.example.demo.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Article;
import com.example.demo.model.ArticleEL;

@Component
public class ArticlesToArticleEL implements Converter<Article,ArticleEL>{

	@Override
	public ArticleEL convert(Article arg0) {
		// TODO Auto-generated method stub
		ArticleEL article = new ArticleEL();
		article.setAbstracts(arg0.getAbstracts());
		article.setAuthors(arg0.getAuthors());
		article.setKeywords(arg0.getKeywords());
		article.setMagazineName(arg0.getMagazineName());
		article.setReviewers(arg0.getReviewers());
		article.setTitle(arg0.getTitle());
		article.setText(arg0.getText());
		return article;
	}

}
