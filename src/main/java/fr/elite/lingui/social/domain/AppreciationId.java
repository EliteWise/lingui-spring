package fr.elite.lingui.social.domain;

import java.util.UUID;

public record AppreciationId(UUID uuid) {
    public AppreciationId {
        if (uuid == null) {
            throw new IllegalArgumentException("AppreciationId cannot be null");
        }
    }
}
