package com.project.mdsspring.dto;

import lombok.Getter;

@Getter
public class CreateTodoDto {
    private final String title;
    private final String text;

    public CreateTodoDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
