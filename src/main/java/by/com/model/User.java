package by.com.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Document
public class User {

    @Id
    private String id;

    @Field(value = "fname")
    @NotEmpty
    private String firstName;

    @Field
    @NotNull
    private Integer age;

    @Field
    @NotNull
    private DateTime created;

    @Field
    private DateTime updated;

    @Field
    private List<String> childrenName;

    @Field
    private Map<String, Integer> childrenAges;

    @Field
    private List<Child> children;

    public User(String id, String firstName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getUpdated() {
        return updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    public List<String> getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(List<String> childrenName) {
        this.childrenName = childrenName;
    }

    public Map<String, Integer> getChildrenAges() {
        return childrenAges;
    }

    public void setChildrenAges(Map<String, Integer> childrenAges) {
        this.childrenAges = childrenAges;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (created != null ? !created.equals(user.created) : user.created != null) return false;
        if (updated != null ? !updated.equals(user.updated) : user.updated != null) return false;
        if (childrenName != null ? !childrenName.equals(user.childrenName) : user.childrenName != null) return false;
        if (childrenAges != null ? !childrenAges.equals(user.childrenAges) : user.childrenAges != null) return false;
        return children != null ? children.equals(user.children) : user.children == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (childrenName != null ? childrenName.hashCode() : 0);
        result = 31 * result + (childrenAges != null ? childrenAges.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    static class Child {

       private String name;
       private int age;

       Child(String name, int age) {
           this.name = name;
           this.age = age;
       }

   }
}
