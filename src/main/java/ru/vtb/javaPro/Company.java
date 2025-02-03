package ru.vtb.javaPro;

public class Company {
    private String name;
    private int age;
    private String post;

    public Company(String name, int age, String post) {
        this.name = name;
        this.age = age;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPost() {
        return post;
    }
}