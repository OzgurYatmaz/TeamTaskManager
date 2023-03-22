package com.tasks.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.model.AppUser;
import com.tasks.model.Task;
import com.tasks.repository.TaskRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {
	
 
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, AppUser user) {
		task.setGivenDate(LocalDate.now());
		task.setUser(user);
		taskRepository.save(task);
	}
	public List<Task> findAllTasksForSpecificUser(String id){
		//return taskRepository.findByUser_idOrderByDescription(id);
		return taskRepository.findByUser_idOrderByTargetDate(id);
	}
	public void deleteTaskById(int id) {
		taskRepository.deleteById(id);
	}
	
	public Task findTaskById(int id) {
		return taskRepository.findById(id).get();
	}
	public void updateTask(@Valid Task task) {
		deleteTaskById(task.getId());
	//	addTask(task.getUsername(),task.getDescription(), task.getTargetDate(), task.isDone());
		taskRepository.save(task);
	}
 
}