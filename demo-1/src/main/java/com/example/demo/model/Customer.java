package com.example.demo.model;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="javatechie",type="customer",shards=2)
@Data
@AllArgsConstructor
public class Customer {
	
	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String firstname;

	@Field(type = FieldType.Text)
	private String lastname;

	@Field(type = FieldType.Integer)
	private int age;
	
	public Customer(String id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public Customer(){
		
	}
	@GeoPointField
	private GeoPoint location;

}
