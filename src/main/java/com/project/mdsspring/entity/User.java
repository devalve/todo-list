package com.project.mdsspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NamedEntityGraphs({
        @NamedEntityGraph(name = "User.roles", attributeNodes = {@NamedAttributeNode(value = "roles")})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_generator")
    @SequenceGenerator(name = "user_id_seq_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;

    private String nickname;

    private String password;

    @UpdateTimestamp
    private Instant lastOnlineAt;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;


    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public User() {

    }
}
