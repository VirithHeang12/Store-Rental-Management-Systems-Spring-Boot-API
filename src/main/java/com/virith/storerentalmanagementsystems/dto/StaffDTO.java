package com.virith.storerentalmanagementsystems.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.util.Date;

@Data
public class StaffDTO {
    @NotEmpty(message = "First Name cannot be null or empty!")
    @Size(min = 1, max = 50, message = "First Name must be between 1 and 50 characters!")
    private String staffFirstName;

    @NotEmpty(message = "Last Name cannot be null or empty!")
    @Size(min = 1, max = 50, message = "Last Name must be between 1 and 50 characters!")
    private String staffLastName;

    @NotNull(message = "Sex cannot be null or empty!")
    private Character sex;

    @NotNull(message = "Birth Date cannot be null or empty!")
    @Past(message = "Birth Date must be in the past!")
    @JsonFormat(pattern="MM-dd-yyyy")
    private Date birthDate;

    @NotEmpty(message = "Identity Card Number cannot be null or empty!")
    @Pattern(regexp = "^\\d{10}$", message = "Identity Card Number must be a 10-digit number!")
    private String IdentityCardNumber;

    @NotEmpty(message = "Position cannot be null or empty!")
    @Size(min = 1, max = 100, message = "Position must be between 1 and 100 characters!")
    private String staffPosition;

    @NotEmpty(message = "House No cannot be null or empty!")
    @Size(min = 1, max = 15, message = "House No must be between 1 and 15 characters!")
    private String houseNo;

    @NotEmpty(message = "Street No cannot be null or empty!")
    @Size(min = 1, max = 25, message = "Street No must be between 1 and 25 characters!")
    private String streetNo;

    @NotEmpty(message = "Sangkat cannot be null or empty!")
    @Size(min = 1, max = 50, message = "Sangkat must be between 1 and 50 characters!")
    private String sangkat;

    @NotEmpty(message = "Khan cannot be null or empty!")
    @Size(min = 1, max = 50, message = "Khan must be between 1 and 50 characters!")
    private String khan;

    @NotEmpty(message = "City or Province cannot be null or empty!")
    @Size(min = 1, max = 50, message = "City or Province must be between 1 and 50 characters!")
    private String provinceOrCity;

    @NotEmpty(message = "Contact Number cannot be null or empty!")
    @Pattern(regexp = "^\\d{10}$", message = "Contact Number must be between 10 and 20 digits!")
    private String contactNumber;

    @NotEmpty(message = "Contact Number cannot be null or empty!")
    @Pattern(regexp = "^\\d{10}$", message = "Personal Number must be between 10 and 20 digits!")
    private String personalNumber;

    @NotNull(message = "Salary cannot be null or empty!")
    @Positive(message = "Salary cannot be negative!")
    private Double salary;

    @NotNull(message = "Birth Date cannot be null or empty!")
    @PastOrPresent(message = "Hired Date must be in the past or today!")
    @JsonFormat(pattern="MM-dd-yyyy")
    private Date hiredDate;

    @NotNull(message = "Stopped Work status cannot be null or empty!")
    private Boolean stoppedWork;
}
