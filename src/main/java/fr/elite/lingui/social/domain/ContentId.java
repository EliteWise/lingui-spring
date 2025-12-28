package fr.elite.lingui.social.domain;

import java.util.UUID;

public record ContentId(UUID uuid) {
    public ContentId {
        if (uuid == null) throw new IllegalArgumentException("ContentId cannot be null");
    }
}
