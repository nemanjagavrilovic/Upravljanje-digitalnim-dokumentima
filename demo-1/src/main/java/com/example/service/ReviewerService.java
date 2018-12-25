package com.example.service;

import java.util.List;

import org.elasticsearch.index.query.GeoDistanceQueryBuilder;

import com.example.model.Reviewer;

public interface ReviewerService {

	Iterable<Reviewer> findAll();
	Iterable<Reviewer> search(GeoDistanceQueryBuilder query);
	List<Reviewer> findByFirstName(String name);
	Iterable<Reviewer> saveAll(List<Reviewer> reviewers);
}
