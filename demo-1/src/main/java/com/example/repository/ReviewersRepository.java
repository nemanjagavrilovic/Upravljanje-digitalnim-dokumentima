package com.example.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.model.Customer;
import com.example.model.Reviewer;

public interface ReviewersRepository extends ElasticsearchRepository<Reviewer,String> {

	List<Reviewer> findByFirstname(String firstName);

}
