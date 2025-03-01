package com.Exo_Web.Exo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String contactId;
    String name;
    @Email
    String email;
    String title;
    String message;


}
