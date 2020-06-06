package com.project.elog.common;

import com.project.elog.exception.NotExistProviderTypeException;

public enum ProviderType {
    GOOGLE(1),
    FACEBOOK(2),
    KAKAO(3),
    GITHUB(4);

    public final int value;

    ProviderType(int value) {
        this.value = value;
    }

    public static ProviderType findProvider(int value) {
        for(ProviderType provider: ProviderType.values()) {
            if(provider.value == value) {
                return provider;
            }
        }
        throw new NotExistProviderTypeException(value);
    }
}
