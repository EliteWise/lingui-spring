package fr.elite.lingui.identity.domain;

import fr.elite.lingui.profile.domain.UserId;
import fr.elite.lingui.profile.domain.exception.DomainException;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class User {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

    private final UserId userId;
    private final String email;
    private String passwordHash;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UserId userId, String email, String passwordHash) {
        if (userId == null) throw new DomainException("UserId cannot be null");

        validateEmail(email);
        validatePasswordHash(passwordHash);

        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public void changePassword(String newPasswordHash) {
        validatePasswordHash(newPasswordHash);
        this.passwordHash = newPasswordHash;
        touchUpdatedAt();
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank())
            throw new DomainException("Email cannot be empty");
        if (!EMAIL_PATTERN.matcher(email).matches())
            throw new DomainException("Invalid email format");
    }

    private void validatePasswordHash(String passwordHash) {
        if (passwordHash == null || passwordHash.isBlank())
            throw new DomainException("Password hash cannot be empty");
    }

    private void touchUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public UserId getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
