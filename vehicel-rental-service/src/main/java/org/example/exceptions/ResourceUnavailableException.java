package org.example.exceptions;

import org.example.enums.ServiceError;

public class ResourceUnavailableException extends AbstractServiceException {
    public ResourceUnavailableException(ServiceError error) {
        super(error);
    }
}
