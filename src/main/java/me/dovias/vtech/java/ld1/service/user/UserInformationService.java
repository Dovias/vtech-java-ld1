package me.dovias.vtech.java.ld1.service.user;

import me.dovias.vtech.java.ld1.model.user.User;
import me.dovias.vtech.java.ld1.model.user.UserSensitiveCredentials;
import me.dovias.vtech.java.ld1.service.UserCredentialsService;
import me.dovias.vtech.java.ld1.repository.UserRepository;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class UserInformationService {
    private final UserCredentialsService service;
    private final UserRepository repository;

    public UserInformationService(UserCredentialsService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public UserInformationAuthorizationResult authorize(UserSensitiveCredentials credentials) {
        User user = this.repository.findByUsername(credentials.getUsername());
        return new UserInformationAuthorizationResult(
            user != null && this.service.authenticate(credentials, user.getCredentials())
                ? UserInformationService.constructUserInformation(user) : null
        );
    }

    private UserInformation submit(@Nullable Integer id, UserSensitiveDetails details) {
        UserSensitiveCredentials credentials = this.service.encrypt(details.getCredentials());
        UserData data = details.getData();

        return UserInformationService.constructUserInformation(
            this.repository.save(
                new User(
                    id,
                    credentials,
                    data.getRole(),
                    data.getFirstName(),
                    data.getLastName(),
                    data.getBirthDate(),
                    data.getEmail(),
                    data.getPhoneNumber()
                )
            )
        );
    }

    public UserInformation submit(UserSensitiveDetails details) {
        return this.submit((Integer)null, details);
    }

    public UserInformation submit(UserInformation information, UserSensitiveDetails details) {
        int id = information.getId();
        if (!this.repository.existsById(id)) {
            throw new IllegalArgumentException("Submit user does not exist");
        }
        return this.submit(id, details);
    }

    private static UserInformation constructUserInformation(User user) {
        return new UserSensitiveInformation(
            user.getId(),
            new UserSensitiveDetails(
                user.getCredentials(),
                new UserData(
                    user.getRole(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getBirthDate(),
                    user.getEmail(),
                    user.getPhoneNumber()
                )
            )
        );
    }

}
