package com.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dao.ProfileDAO;
import com.dao.TaskDAO;
import com.model.Profile;
import com.model.Task;

@RequestScoped
@ManagedBean
public class TaskMB {
	
	private Task task = new Task();
	
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
	
	public TaskMB() {	
	}
	
    public void saveTask() {
		TaskDAO dao = new TaskDAO();
		task.setResponsible(profile);
		dao.save(task);
		taskList = dao.showAllTasks();
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
		selectList = dao.findTask(task);
	}

	@PostConstruct
	public void init() {
		TaskDAO dao = new TaskDAO();
		taskList = dao.showAllTasks();
		task = new Task();
	}
	
	public void redirectToEdit() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		//return "index.xhtml?faces-redirect=true";
	}
	
	
}
