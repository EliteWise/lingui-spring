package fr.elite.lingui.profile.api;

public record ProfileResponse(
   String username,
   String description,
   boolean publicProfile
) {}
