package spring.restful.crud.web.models;

import java.util.Objects;

public class PersonRequestModel {

    private String firstName;
    private String lastName;
    private byte age;

    public PersonRequestModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonRequestModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonRequestModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public byte getAge() {
        return age;
    }

    public PersonRequestModel setAge(byte age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRequestModel that = (PersonRequestModel) o;
        return age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash( firstName, lastName, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonRequestModel{");
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
