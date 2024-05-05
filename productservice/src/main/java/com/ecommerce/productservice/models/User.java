package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
// telling hibernate to create table for this entity
@Entity(name = "ecomm_user")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
