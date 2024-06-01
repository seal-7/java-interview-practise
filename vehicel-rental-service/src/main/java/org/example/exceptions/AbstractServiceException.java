package org.example.exceptions;

import org.example.enums.ServiceError;

public class AbstractServiceException extends Exception {
    protected final ServiceError error;

    public AbstractServiceException(ServiceError error) {
        this.error = error;
    }

    public ServiceError getError() {
        return error;
    }
}
