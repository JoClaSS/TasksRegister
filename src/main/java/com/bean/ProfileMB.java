package com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.dao.ProfileDAO;
import com.model.Profile;

@RequestScoped
@ManagedBean
public class ProfileMB {
	
	private Profile profile = new Profile();
	
	private ProfileDAO dao = new ProfileDAO();

	private List<Profile> profileList = new ArrayList<>();

	public ProfileMB() {	
	}
	

    public void save() {
		dao.save(profile);
		profileList = dao.showAllProfiles();
	}


	@PostConstruct
	public void init() {
		profile = new Profile();
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Profile> getprofileList() {
		return profileList;
	}

	public void setprofileList(List<Profile> profileList) {
		this.profileList = profileList;
	}
	

}
