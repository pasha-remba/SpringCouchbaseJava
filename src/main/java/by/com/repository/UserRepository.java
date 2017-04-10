package by.com.repository;

import by.com.model.User;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String>, MyBaseRepository<User,String> {

    @View
    List<User> findByLastName(String lastName);

}
