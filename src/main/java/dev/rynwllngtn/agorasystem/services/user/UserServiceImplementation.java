package dev.rynwllngtn.agorasystem.services.user;

import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(UUID id, User userData) {
        User user = userRepository.getReferenceById(id);
        UpdateData(user, userData);
        return userRepository.save(user);
    }

    private void UpdateData(User user, User userData) {
        user.setPassword(userData.getPassword());
        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setBirthDate(userData.getBirthDate());
        user.setActive(userData.isActive());
    }

}