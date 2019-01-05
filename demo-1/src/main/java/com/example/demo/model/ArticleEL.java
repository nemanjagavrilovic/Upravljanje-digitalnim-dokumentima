package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(indexName = "articles", type = "article", shards = 1, replicas = 0)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleEL {
	
	@Field(type = FieldType.Text)
	private String title;
	
	@Field(type = FieldType.Text)
	private String filename;

	@Field(type = FieldType.Text)
	private String text;
	
	@Field(type = FieldType.Text)
	private String abstracts;
	
	@Field(type = FieldType.Text)
	private String scientificField;
	
	@Field(type = FieldType.Keyword)
	private List<String> keywords;
	
	@Id
	private String article_id;
	
	@Field(type = FieldType.Text)
	private String magazineName;
	
	@Field(type = FieldType.Nested)
	private List<Reviewer> authors;
	
	@Field(type = FieldType.Nested)
	private List<Reviewer> reviewers;
	
	@Field(type = FieldType.Nested)
	private Object highlight;

	
}