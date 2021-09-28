package com.project.mdsspring.controller;

import com.project.mdsspring.dto.CreateTodoDto;
import com.project.mdsspring.dto.EditTodoDto;
import com.project.mdsspring.dto.GetTodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @GetMapping
    public List<GetTodoDto> getAllTodos() {
        return List.of(
                new GetTodoDto(1, "test-name", "test text"),
                new GetTodoDto(2, "test-name2", "test text 2"),
                new GetTodoDto(3, "test-name3", "test text 3")
        );
    }

    @PostMapping
    public GetTodoDto createTodo(@RequestBody CreateTodoDto createDto) {
        return new GetTodoDto(
                34,
                createDto.getTitle(),
                createDto.getText()
        );
    }

    @PutMapping("/put/{id}")
    public GetTodoDto editTodo(@RequestBody EditTodoDto editDto,
                               @PathVariable("id") Integer todoID) {
        return new GetTodoDto(
                todoID,
                "title like from db",
                editDto.getText());
    }
}
