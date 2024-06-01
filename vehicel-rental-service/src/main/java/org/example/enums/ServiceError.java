package org.example.enums;

public enum ServiceError {
    INPUT_READ_ERROR("ERR_VRS_001", "Error while reading input from console."),
    COMMAND_NAME_MISMATCH_ERROR("ERR_VRS_002", "Command name didn't match to command executor."),
    DUPLICATE_BRANCH_ERROR("ERR_VRS_003", "Branch already existing with provided branch name"),
    BRANCH_NOT_FOUND_ERROR("ERR_VRS_004", "Branch not found for provided branch name");

    ServiceError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
