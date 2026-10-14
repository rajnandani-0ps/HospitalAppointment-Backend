package com.hospital.appointments;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="appointments")
public class Appointment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @NotBlank public String patientName;
 @NotNull @Min(1) @Max(120) public Integer age;
 @NotBlank public String gender;
 @NotBlank public String phone;
 @NotBlank public String doctorName;
 @NotBlank public String department;
 @NotNull public LocalDate appointmentDate;
 @NotNull public LocalTime appointmentTime;
 @Column(length=1000) public String reason;
 @NotBlank public String status = "Scheduled";
}
