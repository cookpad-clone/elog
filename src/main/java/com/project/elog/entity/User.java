package com.project.elog.entity;

import com.project.elog.common.ProviderType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
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

    @Column(name = "imageUrl")
    private String imageUrl;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ProviderType providerType;

    @Builder
    public User(String email, String name, String imageUrl, ProviderType providerType){
        this.email = email;
        this.name = name;
        this.imageUrl = imageUrl;
        this.providerType = providerType;
    }
}
