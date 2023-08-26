package com.Bocxy.Personnel.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Entity
@Table(name = "EmployeePersonalinfo")

public class EmployeePersonalinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "N_EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "V_EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "V_OFFICE_NAME")
    private String officeName;

    @Column(name = "V_OFFICE_CODE")
    private String officeCode;

    @Column(name = "V_CADRE_CODE")
    private String cadreCode;

    @Column(name = "V_GENDER")
    private String gender;

    @Column(name = "V_CADRE_CATEGORY")
    private String cadreCategory;

    @Column(name = "V_CADRE_NAME")
    private String cadreName;

    @Column(name = "V_PLACE_OF_BIRTH")
    private String placeOfBirth;

    @Column(name = "V_DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "V_RELIGION")
    private String religion;

    @Column(name = "V_MOTHER_TONGUE")
    private String motherTongue;

    @Column(name = "V_SUB_CASTE")
    private String subCaste;

    @Column(name = "V_COMMUNITY")
    private String community;

    @Column(name = "V_PRESENT_ADDRESS")
    private String presentAddress;

    @Column(name = "V_BLOOD_GROUP")
    private String bloodGroup;

    @Column(name = "N_AADHAAR_NUMBER")
    private String aadhaarNumber;

    @Column(name = "V_PERMANENT_ADDRESS")
    private String permanentAddress;

    @Column(name = "N_MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "V_PAN_NUMBER")
    private String panNumber;

    @Column(name = "V_MIN_QUALIFICATION")
    private String minQualification;

    @Column(name = "V_EMAIL_ID")
    private String emailId;

    @Column(name = "V_IDENTIFICATION_MARK")
    private String identificationMark;

    @Column(name = "V_MAX_QUALIFICATION")
    private String maxQualification;

    @Column(name = "V_DIFFERENTLY_ABLED")
    private String differentlyAbled;

    @Column(name = "V_DIFFERENTLY_ABLED_CATEGORY")
    private String differentlyAbledCategory;

    @Column(name = "V_DISABILITY_PERCENTAGE")
    private String disabilityPercentage;

    @Column(name = "F_DOCUMENTS")
    private String documents;


}
