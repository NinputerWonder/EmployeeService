package com.wonder.EmployeeService.domain;

public class Employee  {
    private String firstName;
    private String lastName;
    private int age;
    private long id;

    public Employee(String firstName , String lastName , int age){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
