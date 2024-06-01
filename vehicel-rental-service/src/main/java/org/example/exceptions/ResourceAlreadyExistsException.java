package org.example.exceptions;

import org.example.enums.ServiceError;

public class ResourceAlreadyExistsException extends AbstractServiceException {
    public ResourceAlreadyExistsException(ServiceError error) {
        super(error);
    }
}
