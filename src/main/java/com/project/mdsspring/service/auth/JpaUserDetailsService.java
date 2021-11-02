package com.project.mdsspring.service.auth;

import com.project.mdsspring.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    private static final String EX_MSG_TMPL_USER_NOT_FOUND = "[nickname = %s] Пользователь не найден";
    private final UserService userService;

    public JpaUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userInfo = userService.findAuthInfo(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(EX_MSG_TMPL_USER_NOT_FOUND, username)));
        return User.builder()
                .username(username)
                .password(userInfo.getPassword())
                .roles(userInfo.getRoleCodes().toArray(new String[0]))
                .build();
    }
}
