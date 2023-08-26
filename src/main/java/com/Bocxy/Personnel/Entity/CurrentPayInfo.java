package com.Bocxy.Personnel.Entity;


import jakarta.persistence.*;
import lombok.Data;


    // Third tab in Employee details

@Entity
@Data
@Table( name = "current_pay_info")
public class CurrentPayInfo {
    @Id

    @Column(name = "N_ID")
    private Long nId;

    @Column(name = "V_SCALE_OF_PAY")
    private String scaleOfPay;

    @Column(name = "V_BASIC_PAY")
    private String basicPay;

    @Column(name = "V_LEVEL_AS_PER_PAY_MATRIX")
    private String levelAsPerPayMatrix ;

    @Column(name = "V_CELL_AS_PER_PAY_MATRIX")
    private String cellAsPerPayMatrix;

    @Column(name = "V_INCREMENT_DUE_DATE")
    private String incrementDueDate;
}
