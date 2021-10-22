package com.project.mdsspring.dto.task;

import lombok.Getter;

@Getter
public class TaskCreateDto {
    private final String title;
    private final String text;

    public TaskCreateDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
