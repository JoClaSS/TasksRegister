package com.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.dao.ProfileDAO;
import com.dao.TaskDAO;
import com.model.Profile;
import com.model.Task;

@SessionScoped
@ManagedBean
public class TaskMB {
	
	private Task task = new Task();
	
	private Task taskEdit = new Task();
	
	public Task getTaskEdit() {
		return taskEdit;
	}

	public void setTaskEdit(Task taskEdit) {
		this.taskEdit = taskEdit;
	}

	private Profile profile = new Profile();
	
	private List<Profile> profiles= new ArrayList<>();

	private ProfileDAO dao = new ProfileDAO();

	private List<Task> taskList = new ArrayList<>();
	
	private List<Task> selectList = new ArrayList<>();

	public List<Task> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<Task> selectList) {
		this.selectList = selectList;
	}

	private List<Profile> profileList = new ArrayList<>();
	
	public TaskMB() {	
	}
	
    public void saveTask() {
		TaskDAO dao = new TaskDAO();
		task.setResponsible(profile);
		if(task.getId()== null)
		dao.save(task);
		else
		dao.update(task);
		taskList = dao.showAllTasks();
		task = new Task();
	}
    
    public void doneTask(Long id) {
		TaskDAO dao = new TaskDAO();
		dao.done(id);
		taskList = dao.showAllTasks();
	}

	public void delete(Long id) {
		TaskDAO dao = new TaskDAO();
		dao.delete(id);
		taskList = dao.showAllTasks();
	}
	
	public void findTask(){
		TaskDAO dao = new TaskDAO();
		//Task task = new Task();
	    taskList = dao.findTask(task);
	}
	
	public String redirectToEdit(Long id) {
		TaskDAO dao = new TaskDAO();
		task = dao.findById(id);
		return "index.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		TaskDAO dao = new TaskDAO();
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
	
}
