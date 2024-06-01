package org.example.exceptions;

import org.example.enums.ServiceError;

public class BufferException extends  AbstractLoggerException {
    public BufferException(ServiceError error) {
        super(error);
    }
}
