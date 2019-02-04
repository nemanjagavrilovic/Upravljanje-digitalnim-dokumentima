package com.example.demo.configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.converter.ArticleElToArticleConverter;
import com.example.demo.converter.ArticlesToArticleEL;
import com.example.demo.converter.ReviewerToUserConverter;
import com.example.demo.repository.ArticlesRepository;
import com.example.demo.service.SearchQueryService;
import com.example.demo.webService.ArticleWebServiceImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private ArticlesRepository articlesRepository;
	
	@Autowired
	private ArticlesToArticleEL articlesConverter;
	
	@Autowired
	private SearchQueryService searchQueryService;
	
	@Autowired
	private ReviewerToUserConverter reviewerToUserConverter;
	
	@Autowired
	private ArticleElToArticleConverter articleElToArticleConverter;
	
	
	@Bean
	public Endpoint articleService(){
		EndpointImpl endpoint=new EndpointImpl(bus,new ArticleWebServiceImpl(searchQueryService,articlesRepository,
				articlesConverter,reviewerToUserConverter,articleElToArticleConverter));
		endpoint.publish("/ArticleWebService");
		return endpoint;
	}
}
