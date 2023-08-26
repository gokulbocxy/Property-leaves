package com.Bocxy.Personnel.Model;

import com.Bocxy.Personnel.Entity.*;
import lombok.Data;

@Data
public class Savemodel {
    private EmployeePersonalinfo personalinfotab ;
    private CurrentPayInfo currentpayinfotab;
    private AppointmentInfo appointmentinfotab ;
    private RetirementDetails retirementDetailstab;
    private EmployeeLeaveDetails employeeLeaveDetailstab;
}
