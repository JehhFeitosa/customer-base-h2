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

@Entity
@Table(name= "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private Long customer_id;

    @NotBlank
    private String dateBirth;

    @NotBlank
    @Size(max=100)
    private String nameCustomer;

    @NotBlank
    private String personCode;

    @NotBlank
    private String sex;

    @NotBlank
    private String sexDescription;

    @NotBlank
    private String maritalStatusCode;

    @NotBlank
    private String maritalStatusDescription;

    @NotBlank
    private String documentTypeCode;

    @NotBlank
    private String documentTypeDescription;

    @NotBlank
    private String numberDocument;

    @NotBlank
    private String documentIssuanceDate;

    @NotBlank
    private String issuingBody;

    @NotBlank
    private String issuingState;

    @NotBlank
    private String acronymEmitter;

    @NotBlank
    private String stateNumber;

    @NotBlank
    private String ageEmancipatedMinor;

    @NotBlank
    private String employeeRegistration;

    @NotBlank
    private String companyCode;

}
