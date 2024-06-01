package org.example.exceptions;

import org.example.enums.ServiceError;

public class ResourceNotFoundException extends AbstractServiceException {
    public ResourceNotFoundException(ServiceError error) {
        super(error);
    }
}
