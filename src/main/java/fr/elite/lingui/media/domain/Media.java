package fr.elite.lingui.media.domain;

import fr.elite.lingui.profile.domain.UserId;

import java.time.LocalDateTime;

public class Media {

    private final MediaId id;
    private final UserId ownerId;
    private final MediaType type;
    private final String url;
    private final LocalDateTime createdAt;

    public Media(MediaId id, UserId ownerId, MediaType type, String url) {
        if (id == null) throw new IllegalArgumentException("MediaId cannot be null");
        if (ownerId == null) throw new IllegalArgumentException("OwnerId cannot be null");
        if (type == null) throw new IllegalArgumentException("MediaType cannot be null");
        if (url == null || url.isBlank()) throw new IllegalArgumentException("Url cannot be empty");

        this.id = id;
        this.ownerId = ownerId;
        this.type = type;
        this.url = url;
        this.createdAt = LocalDateTime.now();
    }

    public MediaId getId() { return id; }
    public UserId getOwnerId() { return ownerId; }
    public MediaType getType() { return type; }
    public String getUrl() { return url; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
