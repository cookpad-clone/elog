package com.project.elog.exception;

import lombok.Getter;

@Getter
public class NotExistProviderTypeException extends RuntimeException {

    private int providerType;

    public NotExistProviderTypeException(int providerType) {
        this.providerType = providerType;
    }
}
