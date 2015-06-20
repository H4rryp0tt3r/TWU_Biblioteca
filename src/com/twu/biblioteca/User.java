package com.twu.biblioteca;

public abstract class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public User(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public boolean verifyCredentials(String libraryNumber, String password) {
        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!libraryNumber.equals(user.libraryNumber)) return false;
        return password.equals(user.password);

    }

    public abstract String statusMessage();
}