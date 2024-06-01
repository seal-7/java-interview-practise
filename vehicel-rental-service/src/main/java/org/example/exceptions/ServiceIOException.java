package org.example.exceptions;

import org.example.enums.ServiceError;

public class ServiceIOException extends AbstractServiceException {
    public ServiceIOException(ServiceError error) {
        super(error);
    }
}
