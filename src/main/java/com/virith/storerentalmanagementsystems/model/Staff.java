package com.virith.storerentalmanagementsystems.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tblStaff")
@Getter
@Setter
public class Staff extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffID;
    private String staffFirstName;
    private String staffLastName;
    private Character sex;
    private Date birthDate;
    private String identityCardNumber;
    private String staffPosition;
    private String houseNo;
    private String streetNo;
    private String sangkat;
    private String khan;
    private String provinceOrCity;
    private String contactNumber;
    private String personalNumber;
    private Double salary;
    private Date hiredDate;

    @Lob
    private byte[] photo;
    private Boolean stoppedWork;
}
