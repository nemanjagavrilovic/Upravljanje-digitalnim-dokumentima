package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(indexName="reviewers",type="reviewers",shards=2)
@AllArgsConstructor
@Data
public class Reviewer {

	@Id
	private String id;
	@Field(type = FieldType.Text, analyzer = "serbian-analyzer")
	private String firstName;

	@Field(type = FieldType.Text, analyzer = "serbian-analyzer")
	private String lastName;

	@Field(type = FieldType.Text)
	private String email;

	@Field(type = FieldType.Integer)
	private int age;

	@GeoPointField
	private GeoPoint location;
	
	public Reviewer() {
		super();
	}
	
	public Reviewer(String firstName, String lastName, String email, int age, GeoPoint location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.location = location;
	}

}
