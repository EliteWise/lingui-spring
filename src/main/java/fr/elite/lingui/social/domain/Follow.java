package fr.elite.lingui.social.domain;

import fr.elite.lingui.profile.domain.UserId;

import java.time.LocalDateTime;

public class Follow {

    private final UserId followerId;
    private final UserId followedId;
    private final LocalDateTime followedAt;

    public Follow(UserId followerId, UserId followedId) {
        if (followerId.equals(followedId)) {
            throw new IllegalArgumentException("Cannot follow yourself");
        }
        this.followerId = followerId;
        this.followedId = followedId;
        this.followedAt = LocalDateTime.now();
    }

    public UserId getFollowerId() {
        return followerId;
    }

    public UserId getFollowedId() {
        return followedId;
    }

    public LocalDateTime getFollowedAt() {
        return followedAt;
    }
}
