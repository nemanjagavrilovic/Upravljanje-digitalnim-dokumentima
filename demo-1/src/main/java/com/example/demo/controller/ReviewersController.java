package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reviewer;
import com.example.demo.service.ReviewerService;

@RestController
@RequestMapping(value = "/reviewers")
public class ReviewersController {
/*-
	@Autowired
	private ReviewerService reviewerService;

	@PostMapping("/saveReviewer")
	public int saveCustomer(@RequestBody List<Reviewer> customers) {
		reviewerService.saveAll(customers);
		return customers.size();
	}

	@GetMapping("/findAll")
	public Iterable<Reviewer> findAllCustomers() {
		return reviewerService.findAll();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<Reviewer> findByFirstName(@PathVariable String firstName) {
		return reviewerService.findByFirstName(firstName);
	}

	@RequestMapping(value = "/findByDistance")
	public ResponseEntity<List<Reviewer>> findByDistance(@RequestBody List<GeoPoint> points) {
		List<Reviewer> reviewers = new ArrayList<>();
		Iterable<Reviewer> allReviewers = reviewerService.findAll();
		for(Reviewer r : allReviewers) {
			boolean isInArea = false;
			for (GeoPoint point : points) {
				GeoDistanceQueryBuilder query = QueryBuilders.geoDistanceQuery("location")
						.point(point.getLat(), point.getLon()).distance(100, DistanceUnit.KILOMETERS);
				Iterable<Reviewer> searchedReviewers = reviewerService.search(query);
				if(checkReviewersDistance(searchedReviewers, r)) {
					isInArea=true;
					break;
				}
			}
			if(isInArea == false)
				reviewers.add(r);
		}

		return new ResponseEntity<List<Reviewer>>(reviewers, HttpStatus.OK);
	}


	public boolean checkReviewersDistance(Iterable<Reviewer> searchedReviewers, Reviewer reviewer) {
		boolean isInArea = false;
		for (Reviewer item : searchedReviewers) {
			if (compareReviewers(item,reviewer)) {
				isInArea = true;
				break;
			}
		}
		return isInArea;
	}
	public boolean compareReviewers(Reviewer reviewer1, Reviewer reviewer2) {
		if (reviewer1.getId().equals(reviewer2.getId())) {
			return true;
		}
		return false;
	}
*/
}
