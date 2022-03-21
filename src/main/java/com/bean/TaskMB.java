package com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.dao.ProfileDAO;
import com.dao.TaskDAO;
import com.model.Profile;
import com.model.Task;

@RequestScoped
@ManagedBean
public class TaskMB {
	
	private Task task = new Task();
	
	private ProfileDAO dao = new ProfileDAO();

	private List<Task> taskList = new ArrayList<>();
	
    private List<Profile> profileList = new ArrayList<>();
    
    private ProfileMB bean;
    
	public List<Profile> getProfileList() {
		return dao.showAllProfiles();
	}

	public void setProfileList(List<Profile> profileList) {
		this.profileList = profileList;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> gettaskList() {
		return taskList;
	}

	public void settaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	public TaskMB() {	
	}
	
	public String redireciona() {
        return "http://localhost:8080/challenge/pessoas.xhtml";
    }

    public void saveTask() {
		TaskDAO dao = new TaskDAO();
		dao.save(task);
		taskList = dao.showAllTasks();
	}

	public void delete(int id) {
		TaskDAO dao = new TaskDAO();
		dao.delete(id);

		taskList = dao.showAllTasks();
	}

	@PostConstruct
	public void init() {
		TaskDAO dao = new TaskDAO();
		taskList = dao.showAllTasks();

		task = new Task();
	}
	
	
}
