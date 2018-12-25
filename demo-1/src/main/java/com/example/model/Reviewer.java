package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="reviewers",type="reviewers",shards=2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviewer {

	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String firstname;

	@Field(type = FieldType.Text)
	private String lastname;

	@Field(type = FieldType.Integer)
	private int age;
	
	@GeoPointField
	private GeoPoint location;
}
