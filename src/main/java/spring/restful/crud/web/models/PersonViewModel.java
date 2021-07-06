package spring.restful.crud.web.models;

import java.util.Objects;

public class PersonViewModel {

    private Long id;
    private String firstName;
    private String lastName;
    private byte age;

    public PersonViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PersonViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public byte getAge() {
        return age;
    }

    public PersonViewModel setAge(byte age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonViewModel that = (PersonViewModel) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonViewModel{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
