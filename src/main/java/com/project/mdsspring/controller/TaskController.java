package com.project.mdsspring.controller;

import com.project.mdsspring.annotation.Loggable;
import com.project.mdsspring.dto.TaskCreateDto;
import com.project.mdsspring.dto.TaskDto;
import com.project.mdsspring.dto.TaskEditDto;
import com.project.mdsspring.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Loggable
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto createDto) {
        return taskService.createTask(createDto);
    }

    @PutMapping("/put/{id}")
    public TaskDto editTask(@RequestBody TaskEditDto editDto,
                            @PathVariable("id") Integer taskID) {
        return taskService.editTask(taskID, editDto);
    }
}
