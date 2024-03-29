//package ru.kata.spring.boot_security.demo.init;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.repository.RoleRepository;
//import ru.kata.spring.boot_security.demo.repository.UserRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class UserDataLoader implements CommandLineRunner {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//
//
//    public UserDataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public void run(String... arg) throws Exception {
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
//        Set<Role> adminRoles = new HashSet<>();
//        Set<Role> userRoles = new HashSet<>();
//        roleRepository.save(roleAdmin);
//        roleRepository.save(roleUser);
//        adminRoles.add(roleAdmin);
//        adminRoles.add(roleUser);
//        userRoles.add(roleUser);
//
//
//        User userAdmin = new User("Katya", "Karpenko", "katya@mail.ru", passwordEncoder.encode("12345"), adminRoles);
//        User userUser = new User("Ruslan", "Karpenko", "ruslan@mail.ru", passwordEncoder.encode("12345"), userRoles);
//        System.out.println(userAdmin);
//        userRepository.save(userAdmin);
//        System.out.println(userUser);
//        userRepository.save(userUser);
//
//    }
//}