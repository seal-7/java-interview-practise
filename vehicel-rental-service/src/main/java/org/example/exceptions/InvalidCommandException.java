package org.example.exceptions;

import org.example.enums.ServiceError;

public class InvalidCommandException extends  AbstractServiceException {
    public InvalidCommandException(ServiceError error) {
        super(error);
    }
}
