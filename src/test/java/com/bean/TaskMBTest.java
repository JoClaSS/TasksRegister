package com.bean;

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

import com.dao.TaskDAO;
import com.model.Task;

import junit.framework.Assert;

@ExtendWith(MockitoExtension.class)
class TaskMBTest {
	
	@InjectMocks
	TaskMB task;
	
	@Mock
	TaskDAO dao;
	
    @Before
	void Before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void saveTaskTest() {
		doNothing().when(dao).save(Mockito.any());
		Mockito.when(dao.showAllTasks()).thenReturn(new ArrayList<Task>());
		task.saveTask();
		Mockito.verify(dao,Mockito.times(1)).showAllTasks();
	}
	
	@Test
	void doneTaskTest() {
		doNothing().when(dao).done(Mockito.any());
		Mockito.when(dao.showAllTasks()).thenReturn(new ArrayList<Task>());
		task.doneTask(1L);
		Mockito.verify(dao,Mockito.times(1)).showAllTasks();
	}
	
	@Test
	void deleteTest() {
		doNothing().when(dao).delete(Mockito.any());
		Mockito.when(dao.showAllTasks()).thenReturn(new ArrayList<Task>());
		task.delete(1L);
		Mockito.verify(dao,Mockito.times(1)).showAllTasks();
	}
	
	@Test
	void findTask() {
		Mockito.when(dao.findTask(Mockito.any())).thenReturn(new ArrayList<Task>());
		task.findTask();
		Mockito.verify(dao,Mockito.times(1)).findTask(Mockito.any());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void redirectToEdit() {
		Mockito.when(dao.findById(Mockito.any())).thenReturn(new Task());
		String retorno = task.redirectToEdit(1L);
		Assert.assertEquals("index.xhtml?faces-redirect=true", retorno);
	}
	
	@Test
	void redirectToIndex() {
		String retorno = task.redirectToIndex();
		Assert.assertEquals("index.xhtml?faces-redirect=true", retorno);
	}


}
