package com.feitosa.customerbaseh2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spouse_id;

    @NotNull
    @Positive
    private Long numberContract;

    @NotBlank
    @Size(max=6)
    private String agency;

    @NotBlank
    @Size(max=4)
    private String codeGroup;

    @NotBlank
    @Size(max=2)
    private String codeProduct;

    @NotBlank
    @Size(max=4)
    private String subProduct;

    @NotBlank
    private String personCodeOrigin;

    @NotBlank
    private String codeUser;

    @NotBlank
    @Size(max=2)
    private String origin;

    @NotBlank
    private String personCodeSpouseGuarantor;
}
