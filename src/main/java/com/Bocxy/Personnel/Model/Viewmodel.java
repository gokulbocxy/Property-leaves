package com.Bocxy.Personnel.Model;

import com.Bocxy.Personnel.Entity.*;
import lombok.Data;

import java.util.List;

@Data
public class Viewmodel {
    private List<EmployeePersonalinfo> personalinfotab ;
    private List<CurrentPayInfo> currentpayinfotab;
    private List <AppointmentInfo>  appointmentinfotab ;
    private List <RetirementDetails> retirementDetailstab;
    private List <EmployeeLeaveDetails> employeeLeaveDetailstab;
}
