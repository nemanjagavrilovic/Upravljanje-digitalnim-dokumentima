package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Reviewer;
import com.example.demo.model.User;

@Component
public class UserToReviewerConverter implements Converter<User,Reviewer> {

	@Override
	public Reviewer convert(User arg0) {
		// TODO Auto-generated method stub
		Reviewer reviewer = new Reviewer();
		reviewer.setFirstName(arg0.getFirstName());
		reviewer.setLastName(arg0.getLastName());
		reviewer.setId(arg0.getId());
		reviewer.setLat(arg0.getLat());
		reviewer.setLon(arg0.getLon());
		reviewer.setEmail(arg0.getEmail());
		return reviewer;
	}

	public List<Reviewer> convertList(List<User> users){
		List<Reviewer> reviewers = new ArrayList<>();
		if(users != null) {
			for(User user : users){
				reviewers.add(convert(user));
			}
		}
		return reviewers;
	}
}
