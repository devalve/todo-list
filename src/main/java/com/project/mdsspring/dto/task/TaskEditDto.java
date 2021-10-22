package com.project.mdsspring.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TaskEditDto {
    private final String text;

    public TaskEditDto(@JsonProperty("text") String text) {
        this.text = text;
    }
}
