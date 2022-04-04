package edu.mooncoder.rml.model.tags;

public record Error(String message, int line, int column, String type) {}
