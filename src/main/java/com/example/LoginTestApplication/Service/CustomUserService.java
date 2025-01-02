package com.example.LoginTestApplication.Service;

import com.example.LoginTestApplication.Entity.RoleEntity;
import com.example.LoginTestApplication.Entity.UserEntity ;
import com.example.LoginTestApplication.Repository.RoleRepository;
import com.example.LoginTestApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Method to create a new user
    public UserEntity createUser(String username, String password, String roleName) {
        Optional<RoleEntity> role = roleRepository.findByRoleName(roleName);
        if (role.isPresent()) {
            UserEntity user = new UserEntity();
            user.setUsername(username);
            user.setPassword(passwordEncoder().encode(password));  // Encrypt password
            user.setEnabled(true);
            user.setRole(role.get());
            return userRepository.save(user);  // Save the user
        }
        throw new IllegalArgumentException("Role not found");
    }

    // Method to load user by username (for Spring Security)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Ensure the role is not null and properly assigned
        RoleEntity userRole = user.getRole();
        if (userRole == null) {
            throw new UsernameNotFoundException("User role is missing or not properly assigned");
        }

        // Fetch the authority from the role (e.g., "ROLE_USER" or "ROLE_ADMIN")
        String authority = userRole.getAuthority();

        // Convert authority string to a list of GrantedAuthority
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,  // account not expired
                true,  // credentials not expired
                true,  // account not locked
                AuthorityUtils.createAuthorityList(authority) // Correct usage here
        );
    }
}
