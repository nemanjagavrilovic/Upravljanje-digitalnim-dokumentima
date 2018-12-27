package com.example.demo.lucene;

import java.text.ParseException;

import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

public class QueryBuilder {
	
//	private static int maxEdits = 1;
//	
//	public static int getMaxEdits(){
//		return maxEdits;
//	}
//	
//	public static void setMaxEdits(int maxEdits){
//		QueryBuilder.maxEdits = maxEdits;
//	}
//	
//	public static Object buildQuery(String field, String value) throws IllegalArgumentException, ParseException{
//		String errorMessage = "";
//		if(field == null || field.equals("")){
//			errorMessage += "Field not specified";
//		}
//		if(value == null){
//			if(!errorMessage.equals("")) errorMessage += "\n";
//			errorMessage += "Value not specified";
//		}
//		if(!errorMessage.equals("")){
//			throw new IllegalArgumentException(errorMessage);
//		}
//		
//		GeoDistanceQueryBuilder retVal = QueryBuilders.geoDistanceQuery("location").point(29.976, 31.131).distance(10, DistanceUnit.MILES);
//		return retVal;
//	}
//	public static GeoDistanceQueryBuilder buildGeoQuery() {
//		GeoDistanceQueryBuilder retVal = QueryBuilders.geoDistanceQuery("location").point(29.976, 31.131).distance(10, DistanceUnit.MILES);
//		return retVal;
//	}

}
