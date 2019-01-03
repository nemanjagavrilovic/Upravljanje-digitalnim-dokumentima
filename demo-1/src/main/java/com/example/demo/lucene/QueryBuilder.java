package com.example.demo.lucene;

import java.text.ParseException;

import org.elasticsearch.index.query.QueryBuilders;

public class QueryBuilder {

	public static org.elasticsearch.index.query.QueryBuilder buildQuery(SearchType queryType, String field,
			String value) throws IllegalArgumentException, ParseException {
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
			retVal = QueryBuilders.matchQuery(field, value);
		} else if (queryType.equals(SearchType.bool)) {
			retVal = QueryBuilders.boolQuery();
		}  else {
			retVal = QueryBuilders.matchPhraseQuery(field, value);
		}

		return retVal;
	}

}
