package user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String name;
    private int age;
    private UUID id;
    private String surname;

    public User(String name, String surname, int age, UUID id) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.surname = surname;
    }

    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            User user = (User)o;
            return this.age == user.age && Objects.equals(this.name, user.name) && Objects.equals(this.id, user.id) && Objects.equals(this.surname, user.surname);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.age, this.id, this.surname});
    }

    public String toString() {
        return "User{name='" + this.name + "', age=" + this.age + ", id=" + this.id + ", surname='" + this.surname + "'}";
    }
}