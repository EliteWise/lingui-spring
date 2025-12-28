package fr.elite.lingui.social.domain;

public record ContentRef(ContentType type, ContentId id) {
    public ContentRef {
        if (type == null) throw new IllegalArgumentException("ContentType cannot be null");
        if (id == null) throw new IllegalArgumentException("ContentId cannot be null");
    }
}
