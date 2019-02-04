package com.example.demo.lucene;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QueryModel {

	private String field;
	private String value;
	private String operation;
	private String searchType;
}
