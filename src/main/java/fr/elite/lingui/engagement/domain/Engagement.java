package fr.elite.lingui.engagement.domain;

public record Engagement(int streak, int rank, boolean activeBadge) {

    public Engagement {
        if (streak < 0) throw new IllegalArgumentException("Streak cannot be negative");
        if (rank < 0) throw new IllegalArgumentException("Rank cannot be negative");
    }

    public Engagement incrementStreak() {
        return new Engagement(streak + 1, rank, activeBadge);
    }

    public Engagement activateBadge() {
        return new Engagement(streak, rank, true);
    }
}
