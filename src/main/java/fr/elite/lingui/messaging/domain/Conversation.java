package fr.elite.lingui.messaging.domain;

import fr.elite.lingui.profile.domain.UserId;
import fr.elite.lingui.profile.domain.exception.DomainException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Conversation {

    private final ConversationId id;
    private final Set<UserId> participants;
    private final List<Message> messages;
    private final LocalDateTime createdAt;

    public Conversation(ConversationId id, Set<UserId> participants) {
        if (id == null)
            throw new DomainException("ConversationId cannot be null");

        if (participants == null || participants.size() < 2)
            throw new DomainException("Conversation must have at least 2 participants");

        this.id = id;
        this.participants = Set.copyOf(participants);
        this.messages = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public void postMessage(Message message) {
        if (!participants.contains(message.getAuthorId()))
            throw new DomainException("User not allowed in this conversation");

        this.messages.add(message);
    }

    public ConversationId getId() {
        return id;
    }

    public Set<UserId> getParticipants() {
        return participants;
    }

    public List<Message> getMessages() {
        return List.copyOf(messages);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}


