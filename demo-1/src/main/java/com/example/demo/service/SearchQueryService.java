package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.demo.lucene.QueryBuilder;
import com.example.demo.lucene.SearchType;
import com.example.demo.model.ArticleEL;
import com.example.demo.model.Reviewer;

@Service
public class SearchQueryService {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	public List<ArticleEL> search(SearchType type,String field, String value){
		try{
		org.elasticsearch.index.query.QueryBuilder query = QueryBuilder.buildQuery(type,field,value);
    	SearchQuery searchQuery = new NativeSearchQueryBuilder()
    	            .withQuery(query)
    	            .withHighlightFields(new HighlightBuilder.Field(field))
    	            .build();
    
    	Page<ArticleEL> pages  = null;
    	pages = elasticsearchTemplate.queryForPage(searchQuery, ArticleEL.class,new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                List<ArticleEL> chunk = new ArrayList<>();
                for (SearchHit searchHit : response.getHits()) {
                    if (response.getHits().getHits().length <= 0) {
                        return null;
                    }
                    ArticleEL article = new ArticleEL();
                    article.setArticle_id(searchHit.getId());
                    article.setMagazineName((String) searchHit.getSource().get("magazineName"));
                    article.setAbstracts((String) searchHit.getSource().get("abstracts"));
                    article.setTitle((String) searchHit.getSource().get("title"));
                    article.setScientificField((String) searchHit.getSource().get("scientificField"));
                    article.setAuthors(mapUsers(searchHit.getSource().get("authors")));
                    article.setReviewers(mapUsers(searchHit.getSource().get("reviewers")));
                    article.setText((String) searchHit.getSource().get("text"));
                    article.setHighlight(searchHit.getHighlightFields().get(field).fragments()[0].toString());
            
                    chunk.add(article);
                }
                if (chunk.size() > 0) {
                    return new AggregatedPageImpl<T>((List<T>) chunk);
                }
                return null;
            }

        });
    	 if(pages != null && pages.getContent() != null)
    		 return pages.getContent();
    	 else 
    		 return null;
		}catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
		
	}
	public List<Reviewer> mapUsers(Object object){
		List<Reviewer> users = new ArrayList<>();
		if(object != null) {
			
			List<Map<String,Object>> list = (ArrayList<Map<String,Object>>) object;
			for(Map<String,Object> map : list){
				System.out.println(map);
				if(map.get("id") != null && map.get("firstName") != null && map.get("lastName") != null && map.get("age") != null && map.get("email") != null)
					users.add(new Reviewer(map.get("id").toString(),map.get("firstName").toString(),map.get("lastName").toString(), map.get("email").toString(),
							Integer.parseInt(map.get("age").toString()),Double.parseDouble(map.get("lat").toString()),Double.parseDouble(map.get("lon").toString())));
				else 
					users.add(new Reviewer(map.get("id").toString(),"","","",0,0,0));
				
			}
		}
		return users;
	}
}
