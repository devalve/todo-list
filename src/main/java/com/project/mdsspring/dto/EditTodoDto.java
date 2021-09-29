package com.project.mdsspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EditTodoDto {
    private final String text;

    public EditTodoDto(@JsonProperty("text") String text) {
        this.text = text;
    }
}
