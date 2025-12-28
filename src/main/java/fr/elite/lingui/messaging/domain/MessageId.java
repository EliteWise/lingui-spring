package fr.elite.lingui.messaging.domain;

import java.util.UUID;

public record MessageId(UUID value) {

    public MessageId {
        if (value == null) {
            throw new IllegalArgumentException("MessageId cannot be null");
        }
    }

    public static MessageId generate() {
        return new MessageId(UUID.randomUUID());
    }
}

