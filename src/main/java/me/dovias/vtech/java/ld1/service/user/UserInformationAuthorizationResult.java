package me.dovias.vtech.java.ld1.service.user;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class UserInformationAuthorizationResult {
    private final @Nullable UserInformation information;

    public UserInformationAuthorizationResult(@Nullable UserInformation information) {
        this.information = information;
    }

    public @Nullable UserInformation getUserInformation() {
        return this.information;
    }
}
