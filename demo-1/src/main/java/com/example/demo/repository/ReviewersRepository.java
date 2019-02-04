package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.Reviewer;

public interface ReviewersRepository extends ElasticsearchRepository<Reviewer,String> {


}
