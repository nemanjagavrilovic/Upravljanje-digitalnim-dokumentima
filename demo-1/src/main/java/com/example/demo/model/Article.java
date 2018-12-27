package com.example.demo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "filename",
    "title",
    "text",
    "magazineName",
    "authors",
    "keywords",
    "abstracts",
    "reviewers"
})
@XmlRootElement(name = "Article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

	@Id
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String filename;

	@XmlElement(required = true)
	protected String title;

	@XmlElement(required = true)
	protected String text;

	@XmlElement(required = true)
	protected String abstracts;

	@XmlElement(required = true)
	protected List<String> keywords;

	@XmlElement(required = true)
	protected String magazineName;

	@XmlElement(required = true)
	protected List<User> authors;

	@XmlElement(required = true)
	protected List<User> reviewers;
}