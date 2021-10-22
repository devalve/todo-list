package com.project.mdsspring.controller;

import com.project.mdsspring.dto.user.UserWithRolesDto;
import com.project.mdsspring.dto.user.filter.UserFilterDto;
import com.project.mdsspring.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{nickname}/roles")
    public void editRole(@RequestBody Collection<String> codes,
                         @PathVariable String nickname) {
        Integer id = userService.getId(nickname);
        userService.editRole(id, codes);
    }

    @GetMapping
    public List<UserWithRolesDto> getUsers() {
        return userService.getUsers();
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public List<UserWithRolesDto> getUsers(@RequestBody Collection<UserFilterDto> filters) {
        return userService.getUsers(filters);
    }
}
