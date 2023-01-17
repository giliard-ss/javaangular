package com.example.service;

import com.example.model.UserExampleEntity;
import com.example.repository.UserExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserExampleRepository userExampleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExampleEntity user = userExampleRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found: "+username));

        return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
    }
}
