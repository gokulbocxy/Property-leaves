package com.Bocxy.Personnel.Entity;

import jakarta.persistence.*;
import lombok.Data;


//         Second tab in Employee details

@Entity
@Data
@Table( name = "appointment_info")
public class AppointmentInfo {

    @Id

    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "V_MODE_OF_APPOINTMENT")
    private String modeOfAppointment;

    @Column(name = "V_DATE_OF_APPOINTMENT")
    private String dateOfAppointment;

    @Column(name = "V_INITIAL_APPOINTMENT_CADRE")
    private String initialAppointmentCadre;

    @Column(name = "V_DATE_OF_JOINING_SERVICE")
    private String dateOfJoiningService;

    @Column(name = "V_WHETHER_REGULARIZED")
    private String whetherRegularized;

    @Column(name = "V_DATE_OF_PROBATION_DECLARATION")
    private String dateOfProbationDeclaration;

    @Column(name = "DOCUMENTS")
    private String documents;

}
