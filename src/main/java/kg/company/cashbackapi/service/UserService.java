package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.User;
import kg.company.cashbackapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "User number " + id + " has been deleted!";
    }

    public User putById(Long id, User user) throws Exception {
        return userRepository.findById(id)
                .map(newUser -> {
                    newUser.setId(user.getId());
                    newUser.setCreatedDate(user.getCreatedDate());
                    newUser.setOrganization(user.getOrganization());
                    newUser.setPassword(user.getPassword());
                    newUser.setRole(user.getRole());
                    newUser.setStatus(user.getStatus());
                    newUser.setUsername(user.getUsername());
                    return userRepository.save(newUser);
                })
                .orElseThrow(Error::new);
    }


}
