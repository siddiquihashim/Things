package com.spr.hib.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.hib.dao.TagDAO;
import com.spr.hib.domain.Tag;
@Service
public class TagService {

	private static final Logger logger = LoggerFactory.getLogger(TagService.class);

	@Autowired
	private TagDAO tagDAO;

	public List<Tag> findAllTags() {
		return tagDAO.findAllTags();
	}

	public void delete(long number) {
		tagDAO.delete(number);
	}

	public void persist(Tag tag) {
		tagDAO.persist(tag);
	}
	

	public void persist(List<Tag> tags) {
		tagDAO.persist(tags);
	}

	public void merge(Tag tag) {
		tagDAO.merge(tag);

	}

	public Tag findTag(Long id) {
		return tagDAO.findTag(id);
	}

}
