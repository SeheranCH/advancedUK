package ch.course223.advanced.UK.domainModells.user;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getBestEarningUser() {
        Optional<User> u = userRepository.findAll().stream().sorted(Comparator.comparing(User::getSalary).reversed()).findFirst();
        if (u.isPresent()) {
            return u.get();
        } else throw new NoSuchElementException("No value present");    }

    @Override
    public User getWorstEarningUser() {
        Optional<User> u = userRepository.findAll().stream().sorted(Comparator.comparing(User::getSalary)).findFirst();
        if (u.isPresent()) {
            return u.get();
        } else throw new NoSuchElementException("No value present");    }

    @Override
    public List<User> allUsersWithEvenEarnings() {
        return userRepository.findAll().stream().filter(u -> u.getSalary() % 2 == 0).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersWithOddEarnings() {
        return userRepository.findAll().stream().filter(u -> u.getSalary() % 2 != 0).collect(Collectors.toList());
    }

    @Override
    public List<User> allUsersEarningMoreThan(double x) {
        List<User> users = userRepository.findAll().stream().filter(u -> u.getSalary() > x).collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> allUsersEarningLessThan(double x) {
        List<User> users = userRepository.findAll().stream().filter(u -> u.getSalary() < x).collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> allUsersEarningBetween(double x, double y) {
        if (y >= x) {
            List<User> users = userRepository.findAll().stream().filter(u -> u.getSalary() >= x && u.getSalary() <= y).collect(Collectors.toList());
            return users;
        } else {
            List<User> users = userRepository.findAll().stream().filter(u -> u.getSalary() >= y && u.getSalary() <= x).collect(Collectors.toList());
            return users;
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Question to be solved: What is a more ideal way of retrieving above values?

}
