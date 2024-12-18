package me.dovias.vtech.java.ld1.model.user;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Nullable Integer id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(unique = true))
    })
    private UserSensitiveCredentials credentials;

    private UserRole role;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;

    protected User() {}

    public User(@Nullable Integer id, @NonNull UserSensitiveCredentials credentials, @NonNull UserRole role, @NonNull String firstName, @NonNull String lastName, @NonNull LocalDate birthDate, @NonNull String email, @NonNull String phoneNumber) {
        this.id = id;
        this.credentials = credentials;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public @Nullable Integer getId() {
        return this.id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public @NonNull UserSensitiveCredentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(@NonNull UserSensitiveCredentials credentials) {
        this.credentials = credentials;
    }

    public @NonNull UserRole getRole() {
        return this.role;
    }

    public void setRole(@NonNull UserRole role) {
        this.role = role;
    }

    public @NonNull String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public @NonNull String getLastName() {
        return this.lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public @NonNull LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(@NonNull LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @NonNull String getEmail() {
        return this.email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
