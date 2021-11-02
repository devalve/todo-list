package com.project.mdsspring.repository;

import com.project.mdsspring.entity.User;
import com.project.mdsspring.entity.projection.UserIdProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Optional<User> findByNickname(String nickname);

    UserIdProjection findOneByNickname(String nickname);

    @EntityGraph("User.roles")
    Optional<User> findOneWithRolesByNickname(String nickname);

    @EntityGraph("User.roles")
    @Query("select u from User u")
    List<User> findAllWithRoles();
}
