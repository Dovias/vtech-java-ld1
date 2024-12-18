package me.dovias.vtech.java.ld1.service.user;

import me.dovias.vtech.java.ld1.model.user.UserRole;
import org.jspecify.annotations.NullMarked;

import java.time.LocalDate;

@NullMarked
public class UserData {
    private final UserRole role;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String email;
    private final String phoneNumber;

    public UserData(UserRole role, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserRole getRole() {
        return this.role;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
