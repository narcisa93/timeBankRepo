package com.timebank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.timebank.model.Skill;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession () {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void addSkill(Skill skill) {
		 getCurrentSession ().save(skill);	
		
	}

	@Override
	public void updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}

}
