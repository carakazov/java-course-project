package project.dao.impl;

import java.util.HashSet;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import project.dao.UserDao;
import project.model.User;


@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getByLogin(s);

        Set<GrantedAuthority> ga = new HashSet<>();
        user.getRoles().forEach(role -> ga.add(new SimpleGrantedAuthority(role.getTitle().toString())));

        return new org.springframework.security.core.userdetails.User(
            user.getLogin(),
            user.getPassword(),
            ga
        );
    }
}
