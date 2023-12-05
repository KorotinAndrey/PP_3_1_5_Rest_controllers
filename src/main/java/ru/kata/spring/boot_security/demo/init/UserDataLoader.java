package ru.kata.spring.boot_security.demo.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDataLoader {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserDataLoader(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void loadUsers() {

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        roles.add(userRole);

        User userAdmin = new User(3L, "Olga", "Korotina", (byte)55, "olga@mail.ru", "Olga", "12345");
        userAdmin.setRoleSet(userAdmin.getRoleSet());
        userAdmin.setRoleSet(roles);
        userService.create(userAdmin);

        roles.clear();
        User user1 = new User(4L, "Katya", "Karpenko", (byte) 31, "katya@mail.ru", "Katya", "12345");
        roles.add(userRole);
        user1.setRoleSet(roles);
        userService.create(user1);

    }
}
