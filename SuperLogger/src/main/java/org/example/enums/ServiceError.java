package org.example.enums;

public enum ServiceError {
    BUFFER_SIZE_FULL("ERR_SL_001", "Buffer full, try increasing the buffer size");

    ServiceError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    private final String errorCode;
    private final String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
