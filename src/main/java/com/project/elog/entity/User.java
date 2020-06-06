package com.project.elog.entity;

import com.project.elog.common.ProviderType;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ProviderType providerType;
}
