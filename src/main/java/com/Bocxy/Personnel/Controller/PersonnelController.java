package com.Bocxy.Personnel.Controller;
import com.Bocxy.Personnel.Entity.*;

import com.Bocxy.Personnel.Repo.AppointmentInfoRepo;
import com.Bocxy.Personnel.Repo.CurrentPayInfoRepo;
import com.Bocxy.Personnel.Repo.EmployeeRepo;
import com.Bocxy.Personnel.Service.PersonnelService;
import com.Bocxy.Personnel.common.ResponseDo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PersonnelController {
    private final EmployeeRepo employeeRepo;
    private final ResponseDo responseDo;
    private final AppointmentInfoRepo appointmentInfoRepo;
    private final CurrentPayInfoRepo currentPayInfoRepo;
    private final PersonnelService personnelService;



    @Autowired
    public PersonnelController(EmployeeRepo employeeRepo, ResponseDo responseDo, AppointmentInfoRepo appointmentInfoRepo, CurrentPayInfoRepo currentPayInfoRepo, PersonnelService personnelService) {
        this.employeeRepo = employeeRepo;
        this.responseDo = responseDo;
        this.appointmentInfoRepo = appointmentInfoRepo;
        this.currentPayInfoRepo = currentPayInfoRepo;
        this.personnelService = personnelService;

    }

    @PostMapping("/getAllLeaveRecord")
    public ResponseDo getAllScheme(@RequestBody JSONObject json,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        Long id = json.getAsNumber("id").longValue();
        try {
            List<EmployeeLeave> allLeave = personnelService.getEmployeesLeave();

            if (allLeave != null) {
                return responseDo.setSuccessResponse(allLeave);
            } else {
                return responseDo.setSuccessResponse("No Data Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }


    @PostMapping("/applyForLeave")
    public ResponseDo applyForLeave(@RequestBody EmployeeLeave employeeLeave) {
        try {
            EmployeeLeave savedEmployeeLeave = personnelService.saveEmployeeLeaveOffice(employeeLeave);

            if (savedEmployeeLeave != null) {
                return responseDo.setSuccessResponse(savedEmployeeLeave);
            } else {
                return responseDo.setFailureResponse("Failed to save LeaveRecord.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving LeaveRecord.");

        }
    }

    @PostMapping("/getLeaveRecord")
    public ResponseDo getLeaveRecord(@RequestBody JSONObject json,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        Long mId = json.getAsNumber("mId").longValue();
        try {
            List<EmployeeLeave> employeeLeave = personnelService.getEmployeesLeaveById(mId);

            if (employeeLeave != null) {
                return responseDo.setSuccessResponse(employeeLeave);
            } else {
                return responseDo.setFailureResponse("employeeLeave  not found for the provided ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/processLeave")
    public ResponseDo processLeave(@RequestParam Long mId, @RequestParam String action) {
        List<EmployeeLeave> leaveToUpdate = personnelService.processLeaveByEmployeeId(mId,action); // Fetch leave record by ID
        return responseDo.setSuccessResponse(leaveToUpdate);

    }

    @PostMapping("/getPendingLeaves")
    public ResponseDo pendingLeaves(@RequestBody JSONObject json,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
        Long mId = json.getAsNumber("id").longValue();
        try {
            List<EmployeeLeave> employeeLeave = personnelService.getPendingLeaves();

           if(employeeLeave != null) {
               return responseDo.setSuccessResponse(employeeLeave);
           }else{
               return responseDo.setFailureResponse("No Pending Leaves");
           }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/getAllLeavesOfOneEmployee")
    public ResponseDo getAllLeaveRecordOfOne(@RequestBody JSONObject json,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        Long mId = json.getAsNumber("mId").longValue();
        try {
            List<EmployeeLeave> employeeLeave = personnelService.getEmployeesLeaveById(mId);

            if (employeeLeave != null) {
                return responseDo.setSuccessResponse(employeeLeave);
            } else {
                return responseDo.setFailureResponse("employeeLeave  not found for the provided ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }


    // LeaveBalance Of One Employee
    @PostMapping("/balanceLeaveOfOne")
    public ResponseDo getBalances(@RequestBody JSONObject json,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        Long mId = json.getAsNumber("mId").longValue();
        try {
            Map<String, Integer> balances = personnelService.getLeaveBalances(mId);

            if (balances != null) {
                return responseDo.setSuccessResponse(balances);
            } else {
                return responseDo.setFailureResponse(" Balance Leaves not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    // LeaveBalance Of All Employees
    @PostMapping("/allBalances")
    public ResponseDo getAllBalances(@RequestBody JSONObject json,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        Long mId = json.getAsNumber("mId").longValue();
        try {
            List<Map<String, Object>> allBalances = personnelService.getAllLeaveBalances();

            if (allBalances != null) {
                return responseDo.setSuccessResponse(allBalances);
            } else {
                return responseDo.setFailureResponse(" Balance Leaves not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }


    @PostMapping("/saveEmployeePersonal")
    public ResponseDo saveEmployee(@RequestBody EmployeePersonalinfo employeePersonalinfo,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        try {
            EmployeePersonalinfo savedEmployee = personnelService.saveEmployeePersonalinfo(employeePersonalinfo);

            if (savedEmployee != null) {
                return responseDo.setSuccessResponse(savedEmployee);
            } else {
                return responseDo.setFailureResponse("Failed to save Employee Personal Information.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Employee Personal Information.");

        }
    }
    @PostMapping("/getAllEmployeesInfo")
    public ResponseDo getAllEmployees(@RequestBody JSONObject json,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        Long id = json.getAsNumber("id").longValue();
        try {
            List<EmployeePersonalinfo> allEmployee = personnelService.getAllEmployeePersonalinfo();

            if (allEmployee != null) {
                return responseDo.setSuccessResponse(allEmployee);
            } else {
                return responseDo.setSuccessResponse("No Data Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }
    @PostMapping("/getOneEmployeePersonalInfo")
    public ResponseDo getEmployeeInfoOfOne(@RequestBody JSONObject json,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
        Long nId = json.getAsNumber("nId").longValue();
        try {
            Optional<EmployeePersonalinfo> employeeInfo = personnelService.getEmployeeInfoById(nId);

            if (employeeInfo != null) {
                return responseDo.setSuccessResponse(employeeInfo);
            } else {
                return responseDo.setFailureResponse("Appointment Information not found for the provided ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }


    @PostMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        personnelService.deleteEmployeePersonalinfo(id);
    }

    @PostMapping("/saveAppointmentInfo")
    public ResponseDo saveAppointmentInfo(@RequestBody AppointmentInfo appointmentInfo) {
        try {
            AppointmentInfo savedAppointmentInfo = personnelService.saveAppointmentInfo(appointmentInfo);

            if (savedAppointmentInfo != null) {
                return responseDo.setSuccessResponse(savedAppointmentInfo);
            } else {
                return responseDo.setFailureResponse("Failed to save Appointment Information.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Appointment Information.");

        }
    }

    @PostMapping("/getAllAppointmentInfo")
    public ResponseDo getAllAppointmentInfo(@RequestBody JSONObject json,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        Long id = json.getAsNumber("id").longValue();
        try {
            List<AppointmentInfo> allAppointment = personnelService.getAppointmentInfo();

            if (allAppointment != null) {
                return responseDo.setSuccessResponse(allAppointment);
            } else {
                return responseDo.setSuccessResponse("No Data Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/getAppointmentInfoOfOne")
    public ResponseDo getAppointmentInfoOfOne(@RequestBody JSONObject json,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
        Long nId = json.getAsNumber("nId").longValue();
        try {
            Optional<AppointmentInfo> appointmentInfo = personnelService.getAppointmentInfoById(nId);

            if (appointmentInfo != null) {
                return responseDo.setSuccessResponse(appointmentInfo);
            } else {
                return responseDo.setFailureResponse("Appointment Information not found for the provided ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/deleteAppointmentInfo/{id}")
    public void deleteAppointmentInfo(@PathVariable Long id,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

        personnelService.deleteAppointmentInfo(id);

    }

    @PostMapping("/saveCurrentPayInfo")
    public ResponseDo saveCurrentPayInfo(@RequestBody CurrentPayInfo currentPayInfo) {
        try {
            CurrentPayInfo savedCurrentPay = personnelService.saveCurrentPay(currentPayInfo);

            if (savedCurrentPay != null) {
                return responseDo.setSuccessResponse(savedCurrentPay);
            } else {
                return responseDo.setFailureResponse("Failed to save Current Pay Information.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred while saving Current Pay Information.");

        }
    }

    @PostMapping("/getAllCurrentPay")
    public ResponseDo getAllCurrentPay(@RequestBody JSONObject json,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        Long id = json.getAsNumber("id").longValue();
        try {
            List<CurrentPayInfo> allCurrentPay = personnelService.getAllCurrentPay();

            if (allCurrentPay != null) {
                return responseDo.setSuccessResponse(allCurrentPay);
            } else {
                return responseDo.setSuccessResponse("No Data Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/getCurrentPayOfOne")
    public ResponseDo getCurrentPayOfOne(@RequestBody JSONObject json,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        Long nId = json.getAsNumber("nId").longValue();
        try {
            Optional<CurrentPayInfo> currentPayInfoInfo = personnelService.getCurrentPayById(nId);

            if (currentPayInfoInfo != null) {
                return responseDo.setSuccessResponse(currentPayInfoInfo);
            } else {
                return responseDo.setFailureResponse("Current Pay Information not found for the provided ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

    @PostMapping("/deleteCurrentPay/{id}")
    public void deleteCurrentPayInfo(@PathVariable Long id,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {

        personnelService.deleteCurrentPayInfo(id);

    }

    @PostMapping("/getAllTabsOfOne")
    public ResponseDo getAllTabsOfOne(@RequestBody JSONObject json,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        try{
            Long id = json.getAsNumber("id").longValue();

            Optional<EmployeePersonalinfo> employeePersonalinfo = personnelService.getEmployeeInfoById(id);
            Optional<AppointmentInfo> appointmentInfo = personnelService.getAppointmentInfoById(id);
            Optional<CurrentPayInfo> currentPayInfo = personnelService.getCurrentPayById(id);

            Map<String , Object> allTabs = new LinkedHashMap<>();
            allTabs.put("Employee Personal Info" , employeePersonalinfo );
            allTabs.put("Appointment Info" , appointmentInfo );
            allTabs.put("Current Pay Info" , currentPayInfo);

            if (!employeePersonalinfo.isEmpty() || !appointmentInfo.isEmpty() || !currentPayInfo.isEmpty()) {
                return responseDo.setSuccessResponse(allTabs);
            } else {
                return responseDo.setSuccessResponse("No Data Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred");
        }
    }

    @PostMapping("/getAllLeaveType")
    public ResponseDo getAllLeaveType(@RequestBody JSONObject json,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        Long id = json.getAsNumber("id").longValue();
        try {
            List<LeaveType> allTypes = personnelService.getLeaveTypes();

            if (allTypes != null) {
                return responseDo.setSuccessResponse(allTypes);
            } else {
                return responseDo.setSuccessResponse("No Data Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return responseDo.setFailureResponse("An error occurred"); // Return a failure response in case of exception
        }
    }

}


