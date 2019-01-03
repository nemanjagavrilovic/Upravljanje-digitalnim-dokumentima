package com.example.demo.webService;
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder.Item;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.convertor.ArticlesToArticleEL;
import com.example.demo.lucene.QueryModel;
import com.example.demo.model.ArticleEL;
import com.example.demo.model.User;
import com.example.demo.repository.ArticlesRepository;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2018-12-26T14:46:48.718+01:00
 * Generated source version: 2.6.5
 * 
 */
@WebService(endpointInterface = "com.example.demo.webService.ArticleWebService", serviceName = "ArticleWebService")                      
public class ArticleWebServiceImpl implements ArticleWebService {

	private ArticlesToArticleEL articleToArticleEl;
	private ArticlesRepository articlesRepository;
	
	@Autowired
	public ArticleWebServiceImpl(ArticlesRepository articlesRepository,ArticlesToArticleEL articleToArticleEl) {
		this.articlesRepository = articlesRepository;
		this.articleToArticleEl = articleToArticleEl;
	}
	 public java.util.List<com.example.demo.model.ArticleEL> findAll() {  
		    List<ArticleEL> list = new ArrayList<>();
	        try {
	            Iterable<ArticleEL> collection = articlesRepository.findAll();
	            collection.forEach(list::add);
	            return list;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	 
	    }


	    public java.util.List<com.example.demo.model.ArticleEL> findByKeywords(java.util.List<java.lang.String> arg0) {  
	        System.out.println(arg0); 
	        List<ArticleEL> list = new ArrayList<>();
	    	try {
	    		for(String item : arg0){
	    			org.elasticsearch.index.query.QueryBuilder retVal = QueryBuilders.termQuery("keywords", item);
	                Iterable<ArticleEL> collection = articlesRepository.search(retVal);
	                List<ArticleEL> found = new ArrayList<>();
	    	    	collection.forEach(found::add);
	    	    	for(ArticleEL article : found){
	    	    		if(!contains(list,article.getArticle_id())){
	    	    			list.add(article);
	    	    		}
	    	    	}
				}
	    		return list;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	 
	    }


	    public java.util.List<com.example.demo.model.ArticleEL> findByMagazineName(java.lang.String name) {  
	        System.out.println(name);    
	        List<ArticleEL> list = new ArrayList<>();
		    try {
	            Iterable<ArticleEL> collection = articlesRepository.findByMagazineName(name);
	            collection.forEach(list::add);
	            return list;
	
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	 
	    }


	    public java.util.List<com.example.demo.model.User> moreLikeThis(java.lang.String text) {  
	        System.out.println(text);    
	        try {
	        	String [] textForSearch = {text};
	    		String [] fields = {"text"};
	    		Iterable<ArticleEL> allArticles = articlesRepository.findAll();
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
	    		Iterable<ArticleEL> articles = articlesRepository.search(query);
	    		List<User> reviewers = new ArrayList<>();
	    		for(ArticleEL article : articles){
	    			reviewers.addAll(article.getReviewers());
	    		}
	            return reviewers;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	 
	    }


	    public java.util.List<com.example.demo.model.ArticleEL> findByTitle(java.lang.String title) {  
	        System.out.println(title);    
	        List<ArticleEL> list = new ArrayList<>();
			try {
	            Iterable<ArticleEL> collection = articlesRepository.findByTitle(title);
	            collection.forEach(list::add);
	            return list;
	
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	 
	    }

    public ArticleEL save(com.example.demo.model.Article arg0) {  
        System.out.println(arg0);    
        try {
        	ArticleEL ar= articleToArticleEl.convert(arg0);
        	System.out.println(ar.getText());
        	return articlesRepository.save(ar);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }
    public boolean contains(final List<ArticleEL> list, final String id){
        return list.stream().filter(o -> o.getArticle_id().equals(id)).findFirst().isPresent();
    }
	@Override
	public List<ArticleEL> findByScientificField(String scientificField) {
	    List<ArticleEL> list = new ArrayList<>();
		try {
            Iterable<ArticleEL> collection = articlesRepository.findByScientificField(scientificField);
            collection.forEach(list::add);
            return list;

	    } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
	}
	@Override
	public List<ArticleEL> booleanQuery(List<QueryModel> queryFields,String operation) {
		List<ArticleEL> list = new ArrayList<>();
		try {
			List<QueryBuilder> queries = new ArrayList<>();
			for(QueryModel query : queryFields){
				queries.add(QueryBuilders.matchQuery(query.getField(), query.getValue()));
			}
			
			BoolQueryBuilder builder = QueryBuilders.boolQuery();
			if(operation.equalsIgnoreCase("AND")){
				for(QueryBuilder query : queries){
					builder.must(query);
				}
			}else if(operation.equalsIgnoreCase("OR")){
				for(QueryBuilder query : queries){
					builder.should(query);
				}
			}
		    Iterable<ArticleEL> collection = articlesRepository.search(builder);
	        collection.forEach(list::add);
            return list;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
	}
	@Override
	public List<ArticleEL> findByAuthor(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}