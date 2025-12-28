package fr.elite.lingui.messaging.domain;

import fr.elite.lingui.profile.domain.UserId;
import fr.elite.lingui.profile.domain.exception.DomainException;

import java.time.LocalDateTime;

public class Message {

    private final MessageId id;
    private final UserId authorId;
    private final MessageType type;
    private final String content;
    private final LocalDateTime sentAt;

    public Message(MessageId id, UserId authorId, MessageType type, String content) {
        if (authorId == null)
            throw new DomainException("Author required");
        if (type == MessageType.TEXT && (content == null || content.isBlank()))
            throw new DomainException("Text message cannot be empty");

        this.id = id;
        this.authorId = authorId;
        this.type = type;
        this.content = content;
        this.sentAt = LocalDateTime.now();
    }

    public MessageId getId() {
        return id;
    }

    public UserId getAuthorId() {
        return authorId;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}

