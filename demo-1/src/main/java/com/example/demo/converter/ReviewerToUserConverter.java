package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Reviewer;
import com.example.demo.model.User;

@Component
public class ReviewerToUserConverter implements Converter<Reviewer, User> {

	@Override
	public User convert(Reviewer arg0) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setFirstName(arg0.getFirstName());
		user.setLastName(arg0.getLastName());
		user.setAge(arg0.getAge());
		user.setLat(arg0.getLocation().getLat());
		user.setLon(arg0.getLocation().getLon());
		return user;
	}

	public List<User> convertList(List<Reviewer> reviewers) {
		List<User> users = new ArrayList<>();
		if (reviewers != null) {
			for (Reviewer reviewer : reviewers) {
				users.add(convert(reviewer));
			}
		}
		return users;
	}
}
