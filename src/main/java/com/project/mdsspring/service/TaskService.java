package com.project.mdsspring.service;

import com.project.mdsspring.dto.TaskCreateDto;
import com.project.mdsspring.dto.TaskDto;
import com.project.mdsspring.dto.TaskEditDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();

    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask(Integer taskId, TaskEditDto taskEditDto);
}
