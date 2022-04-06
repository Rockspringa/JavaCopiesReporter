package edu.mooncoder.model.wrappers;

import edu.mooncoder.model.types.ErrorType;

public record Error(ErrorType type, String filename, int project, int line, int column, String message) { }
