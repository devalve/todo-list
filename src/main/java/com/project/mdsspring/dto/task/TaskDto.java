package com.project.mdsspring.dto.task;

import lombok.Getter;

@Getter
public class TaskDto {
    private final Integer id;
    private final String title;
    private final String text;

    public TaskDto(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
