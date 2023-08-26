package com.Bocxy.Personnel.Service;
import java.time.Year;
import com.Bocxy.Personnel.Entity.AppointmentInfo;
import com.Bocxy.Personnel.Entity.CurrentPayInfo;
import com.Bocxy.Personnel.Entity.EmployeeLeave;
import com.Bocxy.Personnel.Entity.EmployeePersonalinfo;
import com.Bocxy.Personnel.Entity.LeaveType;
import com.Bocxy.Personnel.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;


@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeePersonalinfoRepo employeePersonalinfoRepo;

    @Autowired
    private AppointmentInfoRepo appointmentInfoRepo;

    @Autowired
    private CurrentPayInfoRepo currentPayInfoRepo;

    @Autowired
    private LeaveTypeRepo leaveTypeRepo;


    @Override
    public EmployeeLeave saveEmployeeLeaveOffice(EmployeeLeave employeeLeave) {
        employeeLeave.setStatus("PENDING");
        return employeeRepo.save(employeeLeave);
    }

    @Override

    public List<EmployeeLeave> getEmployeesLeave() {
        return employeeRepo.findAll();

    }

    public List<EmployeeLeave> getEmployeesLeaveById(Long mId) {

        return employeeRepo.findAllBymId(mId);
    }
    @Override
    public List<EmployeeLeave> processLeaveByEmployeeId(Long mId, String action) {
        try {
            List<EmployeeLeave> leaveRecordsToUpdate = getEmployeesLeaveById(mId); // Fetch leave records by employee ID

            if (!leaveRecordsToUpdate.isEmpty()) {
                for (EmployeeLeave leaveToUpdate : leaveRecordsToUpdate) {
                    if ("approve".equalsIgnoreCase(action)) {
                        leaveToUpdate.setStatus("APPROVED");
                    } else if ("reject".equalsIgnoreCase(action)) {
                        leaveToUpdate.setStatus("REJECTED");
                    } else {
                        // Handle invalid action
                        return Collections.emptyList(); // Or return a list with an error message
                    }
                    employeeRepo.save(leaveToUpdate);
                }
                return leaveRecordsToUpdate;
            } else {
                // Handle no leave records found for the employee
                return Collections.emptyList(); // Or return a list with an error message
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
            return Collections.emptyList(); // Or return a list with an error message
        }
    }

//    @Override
//    public List<EmployeeLeave> processLeaveByEmployeeId(Long mId, String action) {
//        try {
//            List<EmployeeLeave> leaveRecordsToUpdate = getEmployeesLeaveById(mId); // Fetch leave records by employee ID
//
//            if (!leaveRecordsToUpdate.isEmpty()) {
//                for (EmployeeLeave leaveToUpdate : leaveRecordsToUpdate) {
//                    if ("approve".equalsIgnoreCase(action)) {
//                        leaveToUpdate.setStatus("APPROVED");
//                    } else if ("reject".equalsIgnoreCase(action)) {
//                        leaveToUpdate.setStatus("REJECTED");
//                    } else {
//                        // Handle invalid action
//                        return Collections.emptyList(); // Or return a list with an error message
//                    }
//                    employeeRepo.save(leaveToUpdate);
//                }
//                return leaveRecordsToUpdate;
//            } else {
//                // Handle no leave records found for the employee
//                return Collections.emptyList(); // Or return a list with an error message
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle exception
//            return Collections.emptyList(); // Or return a list with an error message
//        }
//    }

    @Override
    public List<EmployeeLeave> getPendingLeaves() {
        return employeeRepo.findPendingLeaves();
    }

//              int days = calculateDaysBetweenDates(empl.getV_LEAVES_START_DATE(), empl.getV_LEAVES_END_DATE());
//    private boolean approveLeave(EmployeeLeave employeeLeave) {
//
//        String leaveDuration = calculateLeaveDuration(employeeLeave.getV_LEAVES_START_DATE(), employeeLeave.getV_LEAVES_END_DATE());
//        return leaveDuration <= 7;
//    }

//
//    private int calculateDaysBetweenDates(String startDate, String endDate) {
//            LocalDate parsedStartDate = LocalDate.parse(startDate);
//            LocalDate parsedEndDate = LocalDate.parse(endDate);
//
//            return (int) ChronoUnit.DAYS.between(parsedStartDate, parsedEndDate);
//
//    }

//First-tab
    @Override
    public EmployeePersonalinfo saveEmployeePersonalinfo(EmployeePersonalinfo employeePersonalinfo) {
        return employeePersonalinfoRepo.save(employeePersonalinfo);
    }

    @Override
    public EmployeePersonalinfo updateEmployeePersonalinfo(Long id, EmployeePersonalinfo employeePersonalinfo) {
        Optional<EmployeePersonalinfo> existingEmployee = employeePersonalinfoRepo.findById(id);

        if (existingEmployee.isPresent()) {
            employeePersonalinfo.setNId(existingEmployee.get().getNId());
            return employeePersonalinfoRepo.save(employeePersonalinfo);
        } else {

            return null;
        }
    }

    @Override
    public void deleteEmployeePersonalinfo(Long id) {
        employeePersonalinfoRepo.deleteById(id);
    }

    @Override
    public List<EmployeePersonalinfo> getAllEmployeePersonalinfo() {
        return employeePersonalinfoRepo.findAll();
    }

    @Override
    public AppointmentInfo saveAppointmentInfo(AppointmentInfo appointmentInfo) {
        return appointmentInfoRepo.save(appointmentInfo);
    }

    @Override
    public List<AppointmentInfo> getAppointmentInfo() {
        return appointmentInfoRepo.findAll();
    }

    @Override
    public Optional<AppointmentInfo> getAppointmentInfoById(Long nId) {
        return appointmentInfoRepo.findById(nId);
    }

    @Override
    public void deleteAppointmentInfo(Long id) {
        appointmentInfoRepo.deleteById(id);
    }

    @Override
    public CurrentPayInfo saveCurrentPay(CurrentPayInfo currentPayInfo) {
        return currentPayInfoRepo.save(currentPayInfo);
    }

    @Override
    public List<CurrentPayInfo> getAllCurrentPay() {
        return currentPayInfoRepo.findAll();
    }

    @Override
    public Optional<CurrentPayInfo> getCurrentPayById(Long nId) {
        return currentPayInfoRepo.findById(nId);
    }

    @Override
    public void deleteCurrentPayInfo(Long id) {
        currentPayInfoRepo.deleteById(id);
    }

    @Override
    public Optional<EmployeePersonalinfo> getEmployeeInfoById(Long nId) {
        return employeePersonalinfoRepo.findById(nId);
    }

    @Override
    public List<LeaveType> getLeaveTypes() {

        return leaveTypeRepo.findAll();
    }



    // Leave Balance Of One Employee
    @Override
    public Map<String, Integer> getLeaveBalances(Long employeeId) {

        List<EmployeeLeave> empLeave = employeeRepo.findAllBymId(employeeId);
        Map<String, Integer> leaveBalances = new HashMap<>();
        List<LeaveType> allTypes = getLeaveTypes();

        for(LeaveType type :allTypes){
            leaveBalances.put(type.getLeaveType(), type.getMaxCount());
        }

        int currentYear = Year.now().getValue();


        for(EmployeeLeave empl : empLeave){
            LocalDate leaveStartDate = empl.getLeaveStartDate();
            if (leaveStartDate.getYear() == currentYear) {
                if ("APPROVED".equals(empl.getStatus())) {
                    String type = empl.getCategory();
                    Integer days = empl.getNoOfDaysApplied();
                    leaveBalances.put(type, (leaveBalances.get(type) - days));
                }
            }
        }
        return leaveBalances;
    }

    // All Employees Balance Leaves
    @Override
    public List<Map<String, Object>> getAllLeaveBalances() {
        List<Map<String, Object>> allEmployeeLeaveBalances = new ArrayList<>();
        List<EmployeeLeave> allEmployees = employeeRepo.findAll(); // Assuming you have a method to get all employees

        List<LeaveType> allTypes = getLeaveTypes();

        for (EmployeeLeave employee : allEmployees) {
            Long employeeId = employee.getMId();
            List<EmployeeLeave> empLeave = employeeRepo.findAllBymId(employeeId);

            Map<String, Integer> leaveBalances = new HashMap<>();
            for (LeaveType type : allTypes) {
                leaveBalances.put(type.getLeaveType(), type.getMaxCount());
            }

            for (EmployeeLeave empl : empLeave) {
                if ("APPROVED".equals(empl.getStatus())) {
                    String type = empl.getCategory();
                    Integer days = empl.getNoOfDaysApplied();
                    leaveBalances.put(type, leaveBalances.get(type) - days);
                }
            }

            Map<String, Object> employeeLeaveBalance = new HashMap<>();
            employeeLeaveBalance.put("employeeId", employeeId);
            employeeLeaveBalance.put("leaveBalances", leaveBalances);

            allEmployeeLeaveBalances.add(employeeLeaveBalance);
        }

        // Consolidate leave balances for each unique employee ID
        Map<Long, Map<String, Integer>> consolidatedBalances = new HashMap<>();
        for (Map<String, Object> employeeBalance : allEmployeeLeaveBalances) {
            Long empId = (Long) employeeBalance.get("employeeId");
            Map<String, Integer> leaveBalances = (Map<String, Integer>) employeeBalance.get("leaveBalances");

            if (!consolidatedBalances.containsKey(empId)) {
                consolidatedBalances.put(empId, leaveBalances);
            } else {
                Map<String, Integer> existingBalances = consolidatedBalances.get(empId);
                for (Map.Entry<String, Integer> entry : leaveBalances.entrySet()) {
                    String leaveType = entry.getKey();
                    Integer balance = entry.getValue();
                    existingBalances.put(leaveType, existingBalances.get(leaveType) );
                }
            }
        }

        // Convert the consolidated balances map to a list for the final response
        List<Map<String, Object>> consolidatedBalancesList = new ArrayList<>();
        for (Map.Entry<Long, Map<String, Integer>> entry : consolidatedBalances.entrySet()) {
            Map<String, Object> consolidatedEntry = new HashMap<>();
            consolidatedEntry.put("employeeId", entry.getKey());
            consolidatedEntry.put("leaveBalances", entry.getValue());
            consolidatedBalancesList.add(consolidatedEntry);
        }

        return consolidatedBalancesList;
    }

}








