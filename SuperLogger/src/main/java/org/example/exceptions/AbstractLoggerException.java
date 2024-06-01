package org.example.exceptions;

import org.example.enums.ServiceError;

public class AbstractLoggerException extends RuntimeException {
    final ServiceError error;

    public AbstractLoggerException(ServiceError error) {
        this.error = error;
    }
}
