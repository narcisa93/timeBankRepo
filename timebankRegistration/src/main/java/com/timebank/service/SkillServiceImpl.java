package com.timebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timebank.dao.SkillDao;
import com.timebank.model.Skill;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {


	@Autowired
	SkillDao skillDao;
	
	@Override
	public void addSkills(Skill skill) {
		skillDao.addSkill(skill);		
	}

	@Override
	public void updateProject(Skill skill) {
		// TODO Auto-generated method stub
		
	}

}
