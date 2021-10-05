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

    private final TaskRepo repo;
    private final TaskMapper mapper;
    private final TaskFactory factory;

    public JpaTaskService(TaskRepo repo, TaskMapper mapper, TaskFactory factory) {
        this.repo = repo;
        this.mapper = mapper;
        this.factory = factory;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> task = repo.findAll();
        return mapper.mapTaskToTaskDto(task);
    }

    @Override
    public TaskDto createTask(TaskCreateDto taskCreateDto) {
        Task task = factory.build(
                taskCreateDto.getTitle(),
                taskCreateDto.getText(),
                1    //todo надо бы настоящий ид-шник вставлять
        );
        task = repo.saveAndFlush(task);
        return mapper.mapTaskToTaskDto(task);
    }

    @Override
    public TaskDto editTask(Integer taskId, TaskEditDto taskEditDto) {
        Task task = repo.findById(taskId).orElseThrow();

        task.setText(taskEditDto.getText());

        repo.saveAndFlush(task);

        return mapper.mapTaskToTaskDto(task);
    }
}
