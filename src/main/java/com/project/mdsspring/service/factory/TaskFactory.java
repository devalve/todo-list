package com.project.mdsspring.service.factory;

import com.project.mdsspring.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {
        public Task build(String title, String text, Integer authorId){
                return new Task(title, text, authorId);
        }
}
