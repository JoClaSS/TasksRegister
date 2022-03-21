package com.dao;

import java.util.List;

import org.hibernate.Session;


import com.model.Profile;
import com.util.HibernateUtil;

public class ProfileDAO {
	
	public void save(Profile profile) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();

		sessao.persist(profile);
		sessao.getTransaction().commit();

		sessao.close();
	}

	public void delete(int id) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();

		Profile aux = sessao.get(Profile.class, id);
		sessao.delete(aux);
		sessao.getTransaction().commit();

		sessao.close();
	}
	
	public List<Profile> showAllProfiles() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Profile> taskList = sessao.getNamedQuery("Profile.findAll").list();
		sessao.close();

		return taskList;
	}
	
	public List<String> showNames() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<String> nameList = sessao.getNamedQuery("Profile.findAllName").list();
		sessao.close();

		return nameList;
	}

}
