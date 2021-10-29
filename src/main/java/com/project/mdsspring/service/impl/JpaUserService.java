package com.project.mdsspring.service.impl;

import com.project.mdsspring.dto.auth.UserAuthInfoDto;
import com.project.mdsspring.dto.registration.UserRegistrationInfoDto;
import com.project.mdsspring.dto.user.UserWithRolesDto;
import com.project.mdsspring.dto.user.filter.UserFilterDto;
import com.project.mdsspring.entity.Role;
import com.project.mdsspring.entity.User;
import com.project.mdsspring.repository.RoleRepository;
import com.project.mdsspring.repository.UserRepository;
import com.project.mdsspring.repository.specification.UserSpecifications;
import com.project.mdsspring.service.UserService;
import com.project.mdsspring.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JpaUserService implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public JpaUserService(
            UserRepository userRepository,
            RoleRepository roleRepository, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Integer getId(String nickname) {
        return userRepository.findOneByNickname(nickname).getId();
    }

    @Transactional
    @Override
    public void editRole(Integer userId, Collection<String> roleCodes) {
        User user = userRepository.findById(userId).orElseThrow();

        Set<Role> newRoles = roleRepository.findAllByCodeIn(roleCodes);

        user.setRoles(newRoles);

        userRepository.save(user);
    }

    @Override
    public List<UserWithRolesDto> getUsers() {
        List<User> users = userRepository.findAllWithRoles();
        return userMapper.mapUserToUserDto(users);
    }

    @Override
    public List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters) {
        List<User> users = userRepository.findAll(UserSpecifications.findUsers(filters));
        return userMapper.mapUserToUserDto(users);
    }

    @Override
    public Optional<UserAuthInfoDto> findAuthInfo(String nickname) {
        Optional<User> userOptional = userRepository.findOneWithRolesByNickname(nickname);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.of(new UserAuthInfoDto(
                    user.getId(),
                    user.getNickname(),
                    user.getPassword(),
                    user.getRoles().stream().map(Role::getCode).collect(Collectors.toSet())
            ));
        } else return Optional.empty();
    }

    @Transactional
    @Override
    public String register(UserRegistrationInfoDto userRegistrationInfoDto) {
        User user = new User(userRegistrationInfoDto.getNickname(), userRegistrationInfoDto.getPassword());
        userRepository.saveAndFlush(user);
        return "Registration successful!";
    }
}


