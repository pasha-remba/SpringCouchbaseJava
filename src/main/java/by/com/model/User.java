package by.com.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.sun.istack.internal.NotNull;
import org.joda.time.DateTime;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class User {

    @Id
    private String id;

    @Field(value = "fname")
    @NotNull
    private String firstName;

    @Field
    @NotNull
    private String lastName;

    @Field
    @NotNull
    private String age;

    @Field
    @NotNull
    private DateTime created;

    @Field
    private DateTime updated;

    public User(String id, String firstName, String lastName, String age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime createdOn) {
        this.created = created;
    }

    public DateTime getUpdated() {

        return updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (created != null ? !created.equals(user.created) : user.created != null) return false;
        return updated != null ? updated.equals(user.updated) : user.updated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }
}
