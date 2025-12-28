package fr.elite.lingui.social.domain;

import fr.elite.lingui.profile.domain.UserId;
import tools.jackson.core.io.ContentReference;

import java.time.LocalDateTime;

public class Appreciation {

    private final AppreciationId id;
    private final UserId giverId;
    private final UserId receiverId;
    private final ContentRef content;
    private final LocalDateTime createdAt;

    public Appreciation(
            AppreciationId id,
            UserId giverId,
            UserId receiverId,
            ContentRef content
    ) {
        if (giverId.equals(receiverId)) {
            throw new IllegalArgumentException("Cannot appreciate yourself");
        }

        this.id = id;
        this.giverId = giverId;
        this.receiverId = receiverId;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public AppreciationId getId() { return id; }
}

