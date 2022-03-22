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
	
	public void update(Task task) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();

		sessao.update(task);
		sessao.getTransaction().commit();

		sessao.close();
	}

	public void done(Long id) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();

		Task aux = sessao.get(Task.class, id);
		aux.setStatus(true);
		sessao.update(aux);
		sessao.getTransaction().commit();

		sessao.close();
	}

	public void delete(Long id) {

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

	public List<Task> findTask(Task findTask) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
		List<Task> taskList = sessao.getNamedQuery("Task.findByForm")
				.setParameter("title", findTask.getTitle())
				.setParameter("id", findTask.getId())
				.setParameter("status", findTask.getStatus())
				.list();
		sessao.close();
		return taskList;
	}
	
	public Task findById(Long id) {
		Task task = new Task();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		task = (Task) sessao.getNamedQuery("Task.findById").setParameter("id",id).list().get(0);
		sessao.close();
		return task;
	}
}
