package ch.course223.advanced.UK.domainModells.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/salary/highest")
    public @ResponseBody ResponseEntity<User> getBestEarningUser() {
        return new ResponseEntity<>(userService.getBestEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/salary/lowest")
    public @ResponseBody ResponseEntity<User> getWorstEarningUser() {
        return new ResponseEntity<>(userService.getWorstEarningUser(), HttpStatus.OK);
    }

    @GetMapping("/salary/even")
    public @ResponseBody ResponseEntity<List<User>> getAllEvenSalaries() {
        return new ResponseEntity<>(userService.allUsersWithEvenEarnings(), HttpStatus.OK);
    }

    @GetMapping("/salary/odd")
    public @ResponseBody ResponseEntity<List<User>> getAllOddSalaries() {
        return new ResponseEntity<>(userService.allUsersWithOddEarnings(), HttpStatus.OK);
    }

    @GetMapping("/salary/more/{x}")
    public @ResponseBody ResponseEntity<List<User>> getMoreThanSalaries(@PathVariable double x) {
        return new ResponseEntity<>(userService.allUsersEarningMoreThan(x), HttpStatus.OK);
    }

    @GetMapping("/salary/less/{x}")
    public @ResponseBody ResponseEntity<List<User>> getLessThanSalaries(@PathVariable double x) {
        return new ResponseEntity<>(userService.allUsersEarningLessThan(x), HttpStatus.OK);
    }

    @GetMapping("/salary/between/{x}/{y}")
    public @ResponseBody ResponseEntity<List<User>> getBetweenRangeSalaries(@PathVariable double x, @PathVariable double y) {
        return new ResponseEntity<>(userService.allUsersEarningBetween(x, y), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<User> createNewUser(@PathVariable User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}
