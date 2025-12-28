package fr.elite.lingui.messaging.domain;

import java.util.UUID;

public record ConversationId(UUID value) {
    public ConversationId {
        if (value == null) {
            try {
                throw new Exception("ConversationId cannot be null");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ConversationId generate() {
        return new ConversationId(UUID.randomUUID());
    }
}
