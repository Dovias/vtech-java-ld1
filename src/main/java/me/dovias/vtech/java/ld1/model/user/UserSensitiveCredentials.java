package me.dovias.vtech.java.ld1.model.user;

import org.jspecify.annotations.NonNull;

public class UserSensitiveCredentials implements UserCredentials {
    private String username;
    private String password;

    private UserSensitiveCredentials() {}

    public UserSensitiveCredentials(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public @NonNull String getUsername() {
        return this.username;
    }

    public @NonNull String getPassword() {
        return this.password;
    }
}
