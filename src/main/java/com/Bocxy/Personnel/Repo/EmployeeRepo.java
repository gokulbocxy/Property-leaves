package com.Bocxy.Personnel.Repo;

import com.Bocxy.Personnel.Entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmployeeRepo extends JpaRepository <EmployeeLeave,Long> {


    EmployeeLeave findBymId(Long mId);

    List<EmployeeLeave> findAllBymId(Long mId);
    @Query( value = "SELECT * FROM employee_leave WHERE status = 'PENDING'", nativeQuery = true)
    List<EmployeeLeave> findPendingLeaves();

    @Query( value = "SELECT \n" +
            "el.m_id, lt.leave_type,\n" +
            "    CASE\n" +
            "        WHEN lt.count - COALESCE(SUM(CASE WHEN el.status = 'APPROVED' THEN 1 ELSE 0 END), 0) < 0\n" +
            "            THEN 0\n" +
            "        ELSE lt.count - COALESCE(SUM(CASE WHEN el.status = 'APPROVED' THEN 1 ELSE 0 END), 0)\n" +
            "    END AS Available_leave_days,\n" +
            "    lt.count AS maximum_days\n" +
            "FROM\n" +
            "    leave_type lt\n" +
            "JOIN\n" +
            "    employee_leave el ON lt.leave_type = el.v_category\n" +
            "GROUP BY\n" +
            "    el.m_id,\n" +
            "    lt.leave_type,\n" +
            "    lt.count\n" +
            "ORDER BY\n" +
            "     el.m_id", nativeQuery = true)
    public List<Object[]> findBalanceLeaves();

    @Query( value = "SELECT \n" +
            "el.m_id AS Employee_Id, lt.leave_type AS Leave_Type,\n" +
            "    CASE\n" +
            "        WHEN lt.count - COALESCE(SUM(CASE WHEN el.status = 'APPROVED' THEN 1 ELSE 0 END), 0) < 0\n" +
            "            THEN 0\n" +
            "        ELSE lt.count - COALESCE(SUM(CASE WHEN el.status = 'APPROVED' THEN 1 ELSE 0 END), 0)\n" +
            "    END AS Available_Leave_Days,\n" +
            "    lt.count AS Maximum_Days\n" +
            "FROM\n" +
            "    leave_type lt\n" +
            "JOIN\n" +
            "    employee_leave el ON lt.leave_type = el.v_category\n" +
            "GROUP BY\n" +
            "    el.m_id,\n" +
            "    lt.leave_type,\n" +
            "    lt.count\n" +
            "ORDER BY\n" +
            "     el.m_id", nativeQuery = true)
    public List<Map<String, Object>> findBalanceLeave();


}
