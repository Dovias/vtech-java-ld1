package me.dovias.vtech.java.ld1.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategy;

import me.dovias.vtech.java.ld1.model.user.UserSensitiveCredentials;

import org.jspecify.annotations.NullMarked;

import java.nio.charset.StandardCharsets;

@NullMarked
public class UserCredentialsService {
    private static final int HASH_COST = 12;
    private static final BCrypt.Version HASH_VERSION = BCrypt.Version.VERSION_2B;
    private static final LongPasswordStrategy HASH_LONG_STRATEGY = LongPasswordStrategies.strict(HASH_VERSION);

    private static final BCrypt.Hasher HASHER = BCrypt.with(UserCredentialsService.HASH_VERSION, UserCredentialsService.HASH_LONG_STRATEGY);
    private static final BCrypt.Verifyer HASH_VERIFYER = BCrypt.verifyer(UserCredentialsService.HASH_VERSION, UserCredentialsService.HASH_LONG_STRATEGY);

    public boolean authenticate(UserSensitiveCredentials unencrypted, UserSensitiveCredentials encrypted) {
        return UserCredentialsService.HASH_VERIFYER.verify(unencrypted.getPassword().getBytes(), encrypted.getPassword().getBytes()).verified;
    }

    public UserSensitiveCredentials encrypt(UserSensitiveCredentials unencrypted) {
        return new UserSensitiveCredentials(
            unencrypted.getUsername(),
            new String(UserCredentialsService.HASHER.hash(UserCredentialsService.HASH_COST, unencrypted.getPassword().getBytes()), StandardCharsets.UTF_8)
        );
    }
}
