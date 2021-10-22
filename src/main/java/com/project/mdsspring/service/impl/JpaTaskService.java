package com.project.mdsspring.service.impl;

import com.project.mdsspring.dto.task.TaskCreateDto;
import com.project.mdsspring.dto.task.TaskDto;
import com.project.mdsspring.dto.task.TaskEditDto;
import com.project.mdsspring.entity.Task;
import com.project.mdsspring.repository.TaskRepository;
import com.project.mdsspring.repository.UserRepository;
import com.project.mdsspring.service.TaskService;
import com.project.mdsspring.service.context.UserContext;
import com.project.mdsspring.service.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaTaskService implements TaskService {

    private final UserContext userContext;
    private final UserRepository userRepository;

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public JpaTaskService(UserContext userContext,
                          UserRepository userRepo,
                          TaskRepository taskRepository,
                          TaskMapper taskMapper) {
        this.userContext = userContext;
        this.userRepository = userRepo;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> task = taskRepository.findAll();
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Transactional
    @Override
    public TaskDto createTask(TaskCreateDto taskCreateDto) {

        String nickname = userContext.getNickname();

        Integer authorId = userRepository.findByNickname(nickname).orElseThrow().getId();

        Task task = new Task(
                taskCreateDto.getTitle(),
                taskCreateDto.getText(),
                authorId);
        task = taskRepository.saveAndFlush(task);
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Transactional
    @Override
    public TaskDto editTask(Integer taskId, TaskEditDto taskEditDto) {
        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setText(taskEditDto.getText());

        taskRepository.saveAndFlush(task);

        return taskMapper.mapTaskToTaskDto(task);
    }
}
