package com.project.mdsspring.service.impl;

import com.project.mdsspring.dto.TaskCreateDto;
import com.project.mdsspring.dto.TaskDto;
import com.project.mdsspring.dto.TaskEditDto;
import com.project.mdsspring.entity.Task;
import com.project.mdsspring.repository.TaskRepo;
import com.project.mdsspring.service.TaskService;
import com.project.mdsspring.service.factory.TaskFactory;
import com.project.mdsspring.service.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaTaskService implements TaskService {

    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;
    private final TaskFactory taskFactory;

    public JpaTaskService(TaskRepo repo, TaskMapper mapper, TaskFactory taskFactory) {
        this.taskRepo = repo;
        this.taskMapper = mapper;
        this.taskFactory = taskFactory;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> task = taskRepo.findAll();
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public TaskDto createTask(TaskCreateDto taskCreateDto) {
        Task task = taskFactory.build(
                taskCreateDto.getTitle(),
                taskCreateDto.getText(),
                1    //todo надо бы настоящий ид-шник вставлять
        );
        task = taskRepo.saveAndFlush(task);
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public TaskDto editTask(Integer taskId, TaskEditDto taskEditDto) {
        Task task = taskRepo.findById(taskId).orElseThrow();

        task.setText(taskEditDto.getText());

        taskRepo.saveAndFlush(task);

        return taskMapper.mapTaskToTaskDto(task);
    }
}
