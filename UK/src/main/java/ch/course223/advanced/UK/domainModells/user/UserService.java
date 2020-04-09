package ch.course223.advanced.UK.domainModells.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getBestEarningUser();
    User getWorstEarningUser();
    List<User> allUsersWithEvenEarnings();
    List<User> allUsersWithOddEarnings();
    List<User> allUsersEarningMoreThan(double x);
    List<User> allUsersEarningLessThan(double x);
    List<User> allUsersEarningBetween(double x, double y);
    double getAverageSalary();
    List<User> allUsersUnderAverage();
    List<User> allUsersOverAverage();
    User createUser (User user);
}
