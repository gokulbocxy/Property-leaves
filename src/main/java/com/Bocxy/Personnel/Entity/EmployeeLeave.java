package com.Bocxy.Personnel.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "employee_leave")

public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "V_Date")
    private String date;

    @Column(name="V_MODE_OF_LEAVE")
    private String modeOfLeave;

    @Column(name="V_EMPLOYEE_ID")
    private String employeeId;

    @Column(name="V_LEAVE_AVAILABLE")
    private String leaveAvailable;

    @Column(name="V_GENDER")
    private String gender;

    @Column(name="V_NO_OF_DAYS_APPLIED")
    private int noOfDaysApplied;

    @Column(name="V_CADRE_CODE")
    private String cadreCode;

    @Column(name="V_CADRE_NAME")
    private String cadreName;

    @Column(name="V_LEAVE_START_DATE")
    private LocalDate leaveStartDate;

    @Column(name="V_LEAVE_END_DATE")
    private LocalDate leaveEndDate;

    @Column(name="V_CATEGORY")
    private String category;

    @Column(name="V_EXEMPTED_DAYS")
    private String exemptedDays;

    @Column(name="V_LEAVE_BALANCE")
    private String leaveBalance;

    @Column (name="V_DATE_JOIN")
    private String dateJoin;

    @Column (name="V_LEAVE_PURPOSE")
    private String leavePurpose;

    @Column(name="V_Status")
    private String status;

//MAPPING ID

    @Column (name="M_ID")
    private Long mId;


}
