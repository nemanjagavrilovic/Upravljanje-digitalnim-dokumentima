package com.example.demo.serviceImpl;

import java.util.List;

import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reviewer;
import com.example.demo.repository.ReviewersRepository;
import com.example.demo.service.ReviewerService;

@Service
public class ReviewerServiceImpl implements ReviewerService{

	@Autowired	
	private ReviewersRepository reviewerRepository;
	
	@Override
	public Iterable<Reviewer> findAll() {
		// TODO Auto-generated method stub
		return reviewerRepository.findAll();
	}

	@Override
	public Iterable<Reviewer> search(GeoDistanceQueryBuilder query) {
		// TODO Auto-generated method stub
		return reviewerRepository.search(query);
	}

	@Override
	public List<Reviewer> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return reviewerRepository.findByFirstname(name);
	}

	@Override
	public Iterable<Reviewer> saveAll(List<Reviewer> reviewers) {
		// TODO Auto-generated method stub
		return reviewerRepository.saveAll(reviewers);
	}

}
