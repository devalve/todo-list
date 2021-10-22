package com.project.mdsspring.service;

import com.project.mdsspring.dto.task.TaskCreateDto;
import com.project.mdsspring.dto.task.TaskDto;
import com.project.mdsspring.dto.task.TaskEditDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();


    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask(Integer taskId, TaskEditDto taskEditDto);
}
