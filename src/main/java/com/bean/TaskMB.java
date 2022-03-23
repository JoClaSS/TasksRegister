package com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


import com.dao.ProfileDAO;
import com.dao.TaskDAO;
import com.model.Profile;
import com.model.Task;

@SessionScoped
@ManagedBean
public class TaskMB {
	
	private Task task = new Task();
	
	private Task taskEdit = new Task();
	
	private TaskDAO taskDao = new TaskDAO();
	
	private Profile profile = new Profile();
	
	private List<Profile> profiles= new ArrayList<>();

	private ProfileDAO dao = new ProfileDAO();

	private List<Task> taskList = new ArrayList<>();
	
	
	public TaskMB() {	
	}
	
    public void saveTask() {
		task.setResponsible(profile);
		
		if(task.getId()== null)
			taskDao.save(task);
		else
			taskDao.update(task);
		
		taskList = taskDao.showAllTasks();
		task = new Task();
	}
    
    public void doneTask(Long id) {
		taskDao.done(id);
		taskList = taskDao.showAllTasks();
	}

	public void delete(Long id) {
		taskDao.delete(id);
		taskList = taskDao.showAllTasks();
	}
	
	public void findTask(){
		task.setResponsible(null);
		
		if(profile.getId()!=null)
			task.setResponsible(profile);

	    taskList = taskDao.findTask(task);
	}
	
	public String redirectToEdit(Long id) {
		task = taskDao.findById(id);
		
		return "index.xhtml?faces-redirect=true";
	}
	
	public String redirectToIndex() {
		task = new Task();
		
		return "index.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		TaskDAO dao = new TaskDAO();
		profile = new Profile();
		task = new Task();
		taskList = dao.showAllTasks();
	}
	
    public List<Profile> getProfiles() {
    	return dao.showAllProfiles();
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
    
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
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
	
	public Task getTaskEdit() {
		return taskEdit;
	}

	public void setTaskEdit(Task taskEdit) {
		this.taskEdit = taskEdit;
	}
}
