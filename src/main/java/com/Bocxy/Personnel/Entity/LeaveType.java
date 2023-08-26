package com.Bocxy.Personnel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "leave_type")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long nId;

    @Column ( name = "leave_type")
    private String leaveType;

    @Column( name = "count")
    private int maxCount;
}
