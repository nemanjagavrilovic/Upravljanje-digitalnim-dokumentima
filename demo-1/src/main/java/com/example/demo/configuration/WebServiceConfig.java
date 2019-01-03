package com.example.demo.configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import com.example.demo.convertor.ArticlesToArticleEL;
import com.example.demo.repository.ArticlesRepository;
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
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Bean
	public Endpoint articleService(){
		EndpointImpl endpoint=new EndpointImpl(bus,new ArticleWebServiceImpl(elasticsearchTemplate,articlesRepository,articlesConverter));
		endpoint.publish("/ArticleWebService");
		return endpoint;
	}
}
