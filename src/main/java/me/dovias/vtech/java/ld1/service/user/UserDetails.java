package me.dovias.vtech.java.ld1.service.user;

import me.dovias.vtech.java.ld1.model.user.UserCredentials;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface UserDetails {
    UserCredentials getCredentials();
    UserData getData();
}
