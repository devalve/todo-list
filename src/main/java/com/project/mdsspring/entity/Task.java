package com.project.mdsspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq_generator")
    @SequenceGenerator(name = "task_id_seq_generator", sequenceName = "task_id_seq", allocationSize = 1)
    private Integer id;

    private String title;

    private String text;

    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "author_id")
    private Integer authorId;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private User user;

    public Task(String title, String text, Integer authorId) {
        this.title = title;
        this.text = text;
        this.authorId = authorId;
    }

    public Task() {

    }
}
