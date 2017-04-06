package by.com.service.impl;

import by.com.model.User;
import by.com.service.UserService;
import com.couchbase.client.java.view.ViewQuery;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("UserTemplateServiceImpl")
public class UserTemplateServiceImpl implements UserService {

    private static final String DESIGN_DOC = "user";

    @Autowired
    private CouchbaseTemplate couchbaseTemplate;


    public User findOne(String id) {
        return couchbaseTemplate.findById(id, User.class);
    }

    public List<User> findAll() {
        return couchbaseTemplate.findByView(ViewQuery.from(DESIGN_DOC, "all"), User.class);
    }

    public List<User> findByFirstName(String firstName) {
        return couchbaseTemplate.findByView(ViewQuery.from(DESIGN_DOC, "byFirstName"), User.class);
    }

    public void create(User user) {
        user.setCreated(DateTime.now());
        couchbaseTemplate.insert(user);
    }

    public void update(User user) {
        user.setUpdated(DateTime.now());
        couchbaseTemplate.update(user);
    }

    public void delete(User user) {
        couchbaseTemplate.remove(user);
    }
}
