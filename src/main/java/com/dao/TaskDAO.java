package com.dao;

import java.util.List;
import org.hibernate.Session;
import com.model.Task;
import com.util.HibernateUtil;

public class TaskDAO {

	public void save(Task task) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();

		sessao.persist(task);
		sessao.getTransaction().commit();

		sessao.close();
	}

	public void delete(int id) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();

		Task aux = sessao.get(Task.class, id);
		sessao.delete(aux);
		sessao.getTransaction().commit();

		sessao.close();
	}

	public List<Task> showAllTasks() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Task> taskList = sessao.getNamedQuery("Task.findAll").list();
		sessao.close();

		return taskList;
	}
}
