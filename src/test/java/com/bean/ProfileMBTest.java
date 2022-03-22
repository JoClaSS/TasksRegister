package com.bean;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.model.Profile;

import com.dao.ProfileDAO;
import com.dao.TaskDAO;
import com.model.Task;

import junit.framework.Assert;

@ExtendWith(MockitoExtension.class)
class ProfileMBTest {
	
	@InjectMocks
	ProfileMB profile;
	
	@Mock
	ProfileDAO dao;
	
    @Before
	void Before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void saveTaskTest() {
		doNothing().when(dao).save(Mockito.any());
		Mockito.when(dao.showAllProfiles()).thenReturn(new ArrayList<Profile>());
		profile.save();
		Mockito.verify(dao,Mockito.times(1)).showAllProfiles();
	}
}
