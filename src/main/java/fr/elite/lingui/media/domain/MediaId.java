package fr.elite.lingui.media.domain;

import java.util.UUID;

public record MediaId(UUID uuid) {
    public MediaId {
        if (uuid == null) {

        }
    }
}
