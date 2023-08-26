package com.Bocxy.Personnel.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Entity
@Data
@Table(name = "employee_leave_details")
public class EmployeeLeaveDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "V_earned_leave_credit_days")
    private String earnedLeaveCreditDays;

    @Column(name = "V_earned_leave_availed_days")
    private String earnedLeaveAvailedDays;

    @Column(name = "V_earned_leave_balance_days")
    private String earnedLeaveBalanceDays;

    @Column(name = "V_medical_leave_credit_days")
    private String medicalLeaveCreditDays;

    @Column(name = "V_medical_leave_availed_days")
    private String medicalLeaveAvailedDays;

    @Column(name = "V_medical_leave_balance_days")
    private String medicalLeaveBalanceDays;

    @Column(name = "V_unearned_leave_personal_credit_days")
    private String unearnedLeavePersonalCreditDays;

    @Column(name = "V_unearned_leave_personal_availed_days")
    private String unearnedLeavePersonalAvailedDays;

    @Column(name = "V_unearned_leave_personal_balance_days")
    private String unearnedLeavePersonalBalanceDays;

    @Column(name = "V_loss_of_pay_with_medical_certificate")
    private String lossOfPayWithMedicalCertificate;

    @Column(name = "V_loss_of_pay_without_medical_certificate")
    private String lossOfPayWithoutMedicalCertificate;

    @Column(name = "V_casual_leave")
    private String casualLeave;

    @Column(name = "V_restricted_holidays")
    private String restrictedHolidays;

    @Column(name = "V_availed_days_adopting_child")
    private String availedDaysForAdoptingChild;

    @Column(name = "V_maternity_leave")
    private String maternityLeave;

    @Column(name = "V_study_leave")
    private String studyLeave;

    @Column(name = "V_abroad_employment_leave")
    private String abroadEmploymentLeave;

    @Column(name = "V_family_planning_leave")
    private String familyPlanningLeave;

    @Column(name = "V_special_casual_leave")
    private String specialCasualLeave;

    @Column(name = "V_disability_leave")
    private String disabilityLeave;

    @Column(name = "V_abortion_leave")
    private String abortionLeave;

    @Column(name = "V_charges_pending")
    private String chargesPending;

    @Column(name = "V_employees_unblemished_services")
    private String employeesUnblemishedServices;

    @Column(name = "V_employees_unblemished_date")
    private Date employeesUnblemishedDate;


}
