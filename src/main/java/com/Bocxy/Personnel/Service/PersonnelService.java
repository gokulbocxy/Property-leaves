package com.Bocxy.Personnel.Service;

import com.Bocxy.Personnel.Entity.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PersonnelService {
    EmployeeLeave saveEmployeeLeaveOffice(EmployeeLeave employeeLeave);

    List<EmployeeLeave> getEmployeesLeave();

    List<EmployeeLeave> getEmployeesLeaveById(Long mId);

    public List<EmployeeLeave> processLeaveByEmployeeId(Long employeeId, String action);

    List<EmployeeLeave> getPendingLeaves();

    Map<String, Integer> getLeaveBalances(Long employeeId);



     //tab-1 EmployeePersonalinfo
     EmployeePersonalinfo saveEmployeePersonalinfo(EmployeePersonalinfo employeePersonalinfo);
    EmployeePersonalinfo updateEmployeePersonalinfo(Long id, EmployeePersonalinfo employeePersonalinfo);
    void deleteEmployeePersonalinfo(Long id);

    List<EmployeePersonalinfo> getAllEmployeePersonalinfo();

    AppointmentInfo saveAppointmentInfo(AppointmentInfo appointmentInfo);

    List<AppointmentInfo> getAppointmentInfo();

    Optional<AppointmentInfo> getAppointmentInfoById(Long nId);

    void deleteAppointmentInfo(Long id);

    CurrentPayInfo saveCurrentPay(CurrentPayInfo currentPayInfo);

    List<CurrentPayInfo> getAllCurrentPay();

    Optional<CurrentPayInfo> getCurrentPayById(Long nId);

    void deleteCurrentPayInfo(Long id);

    Optional<EmployeePersonalinfo> getEmployeeInfoById(Long nId);

    List<LeaveType> getLeaveTypes();

    List<Map<String, Object>> getAllLeaveBalances();


}
