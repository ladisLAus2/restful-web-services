package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static{
        users.add(new User(++usersCount, "vlad", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "ivan", LocalDate.now().minusYears(40)));
        users.add(new User(++usersCount, "sema", LocalDate.now().minusYears(50)));
    }
    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
}
