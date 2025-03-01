package com.Exo_Web.Exo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String companyId;
    @NotBlank(message = "Name cannot be null")
    String name;
    @Email
    String email;
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Invalid phone number")
    String phone;
    @NotBlank(message = "Address cannot be null")
    String address;
    @NotBlank(message = "Description cannot be null")
    String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    Byte[] logo;
}
