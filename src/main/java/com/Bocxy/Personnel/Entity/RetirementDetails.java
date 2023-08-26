package com.Bocxy.Personnel.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Entity

@Data
@Table(name = "retirement_details")
public class RetirementDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "V_mode_of_retirement")
    private String modeOfRetirement;

    @Column(name = "V_fbf_sanctioned_date")
    private Date fbfSanctionedDate;

    @Column(name = "V_fbf_sanctioned_amount")
    private Double fbfSanctionedAmount;

    @Column(name = "V_retirement_permitted_status")
    private String retirementPermittedStatus;

    @Column(name = "V_date_of_retirement_from_all_services")
    private Date dateOfRetirement;

    @Column(name = "V_regular_retirement_admin_approval_date")
    private Date regularRetirementAdminApprovalDate;

    @Column(name = "V_regular_retirement_pension_sanction_date")
    private Date regularRetirementPensionSanctionDate;

    @Column(name = "V_provisional_admin_approval_date")
    private Date provisionalAdminApprovalDate;

    @Column(name = "V_provisional_pension_sanction_date")
    private Date provisionalPensionSanctionDate;


}
