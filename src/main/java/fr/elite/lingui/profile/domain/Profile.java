package fr.elite.lingui.profile.domain;

import fr.elite.lingui.profile.domain.exception.DomainException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profile {

    private final UserId userId;
    private String name;
    private String pictureUrl;
    private LocalDate birthdate;
    private final Location location;
    private String description;
    private final Language nativeLanguage;
    private int streak;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Profile(
            UserId userId,
            String name,
            String pictureUrl,
            LocalDate birthdate,
            Location location,
            String description,
            Language nativeLanguage
    ) {
        if (userId == null) throw new IllegalArgumentException("UserId cannot be null");
        if (location == null) throw new IllegalArgumentException("Location cannot be null");
        if (nativeLanguage == null) throw new IllegalArgumentException("Native language cannot be null");

        validateName(name);
        validateBirthdate(birthdate);
        validateDescription(description);

        this.userId = userId;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.birthdate = birthdate;
        this.location = location;
        this.description = description;
        this.nativeLanguage = nativeLanguage;
        this.streak = 0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Location getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Language getNativeLanguage() {
        return nativeLanguage;
    }

    public int getStreak() {
        return streak;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Rules

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new DomainException("Profile name cannot be empty");
        }
        if (name.length() > 50) {
            throw new DomainException("Profile name too long");
        }
    }

    private void validateBirthdate(LocalDate birthdate) {
        if (birthdate == null) return;
        if (birthdate.isAfter(LocalDate.now())) {
            throw new DomainException("Birthdate cannot be in the future");
        }
        if (birthdate.isAfter(LocalDate.now().minusYears(15))) {
            throw new DomainException("User must be at least 15 years old");
        }
    }

    private void validateDescription(String description) {
        if (description == null) return;
        if (description.length() > 300) {
            throw new DomainException("Description too long");
        }
    }

    public boolean isActiveBadge() {
        return streak >= 4;
    }

    public void incrementStreak() {
        this.streak++;
        touchUpdatedAt();
    }

    public void updateName(String newName) {
        validateName(newName);
        this.name = newName;
        touchUpdatedAt();
    }

    public void updatePictureUrl(String newPictureUrl) {
        this.pictureUrl = newPictureUrl;
        touchUpdatedAt();
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
        touchUpdatedAt();
    }

    private void touchUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
