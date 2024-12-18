package me.dovias.vtech.java.ld1.service.user;

import me.dovias.vtech.java.ld1.model.user.UserSensitiveCredentials;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class UserSensitiveDetails implements UserDetails {
    private final UserSensitiveCredentials credentials;
    private final UserData details;

    public UserSensitiveDetails(UserSensitiveCredentials credentials, UserData details) {
        this.credentials = credentials;
        this.details = details;
    }

    public UserSensitiveCredentials getCredentials() {
        return this.credentials;
    }

    public UserData getData() {
        return this.details;
    }
}
