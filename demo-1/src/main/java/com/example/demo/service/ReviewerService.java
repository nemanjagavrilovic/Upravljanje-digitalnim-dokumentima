package com.example.demo.service;

import java.util.List;

import org.elasticsearch.index.query.GeoDistanceQueryBuilder;

import com.example.demo.model.Reviewer;

public interface ReviewerService {

	Iterable<Reviewer> findAll();
	Iterable<Reviewer> search(GeoDistanceQueryBuilder query);
	List<Reviewer> findByFirstName(String name);
	Iterable<Reviewer> saveAll(List<Reviewer> reviewers);
}
