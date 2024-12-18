package me.dovias.vtech.java.ld1.service.user;

import org.jspecify.annotations.NullMarked;

@NullMarked
public class UserSensitiveInformation implements UserInformation {
    private final int id;
    private final UserSensitiveDetails information;

    UserSensitiveInformation(int id, UserSensitiveDetails information) {
        this.id = id;
        this.information = information;
    }

    public int getId() {
        return this.id;
    }

    public UserSensitiveDetails getDetails() {
        return this.information;
    }
}
