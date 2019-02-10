package com.example.demo.lucene;

import java.text.ParseException;

import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;

public class QueryBuilder {

	public static org.elasticsearch.index.query.QueryBuilder buildQuery(SearchType queryType, String field,
			String value,String operation) throws IllegalArgumentException, ParseException {
		String errorMessage = "";
		if (field == null || field.equals("")) {
			errorMessage += "Field not specified";
		}
		if (value == null) {
			if (!errorMessage.equals(""))
				errorMessage += "\n";
			errorMessage += "Value not specified";
		}
		if (!errorMessage.equals("")) {
			throw new IllegalArgumentException(errorMessage);
		}
		org.elasticsearch.index.query.QueryBuilder retVal = null;
		if (queryType.equals(SearchType.regular)) {
			if(operation.equalsIgnoreCase("AND"))	{
				retVal = QueryBuilders.matchQuery(field, value).analyzer("serbian-analyzer").operator(Operator.AND);
			} else {
				retVal = QueryBuilders.matchQuery(field, value).analyzer("serbian-analyzer").operator(Operator.OR);
			}
		} else if (queryType.equals(SearchType.bool)) {
			retVal = QueryBuilders.boolQuery();
		}  else {
			if(operation.equalsIgnoreCase("AND")) {
				retVal = QueryBuilders.matchPhraseQuery(field, value).analyzer("serbian-analyzer");
			}
		}
		
		
		return retVal;
	}

}
