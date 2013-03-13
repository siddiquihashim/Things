package com.spr.hib.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spr.hib.domain.Tag;
import com.spr.hib.domain.Thing;

@Repository
@Transactional
public class TagDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(TagDAO.class);

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Tag> findAllTags() {
		List<Tag> result = currentSession().createQuery("from Tag").list();
		return result;
	}

	public void delete(long number) {
		// TODO Auto-generated method stub
		Tag result = (Tag) currentSession().load(Tag.class, number);// INFO diff between load and get - load is a lazy load better for delete and fast
		//result.getOwner().getTags().remove(result);// TODO find out a better way of this happening by default..currently it will throw exception if i delete
		// it directly without removing from parent

		Set<Thing> things = result.getThings();
		for (Thing thing : things) {
			thing.getTags().remove(result);
		}
		result.getThings().clear();
		currentSession().delete(result);
		
	}

	public void persist(Tag tag) {
		currentSession().save(tag);
	}
	
	
	public void persist(List<Tag> tags) {
		for (int i =0; i < tags.size(); i++) {
			currentSession().save(tags.get(i));
			if( i % 10 == 0 ){
				currentSession().flush();//TODO check with inline hibernate is this still right approach
			}
		}
		currentSession().flush();
	}

	public void merge(Tag tag) {
		//tag.setVersion(0);
		Tag tag2 = findTag( tag.getId());
		System.out.println(tag);
		System.out.println(tag2);
		currentSession().merge(tag);//TODO saveorupdate not working because of version important to find diff between state of objcts and merge save update saveupdate persis methods
	}

	public Tag findTag(Long id) {
		if (id == null)
			return null;
		return (Tag) currentSession().get(Tag.class, id);
	}

}
