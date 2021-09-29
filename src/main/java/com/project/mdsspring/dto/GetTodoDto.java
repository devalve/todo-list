package com.project.mdsspring.dto;

import lombok.Getter;

@Getter
public class GetTodoDto {
    private final Integer id;
    private final String title;
    private final String text;

    public GetTodoDto(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
