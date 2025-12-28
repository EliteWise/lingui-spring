package fr.elite.lingui.messaging.domain;

import fr.elite.lingui.profile.domain.exception.DomainException;

public record MediaUrl(String value) {

    public MediaUrl {
        if (value == null || value.isBlank()) {
            throw new DomainException("MediaUrl cannot be empty");
        }
        if (!value.startsWith("http")) {
            throw new DomainException("Invalid MediaUrl");
        }
    }
}

