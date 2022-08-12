package com.ja.employeemanager.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "empleyee_id",
            allocationSize = 1,
            sequenceName = "employee_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_seq"
    )
    private Long id;

    private String name;

    private String email;

    private String jobTitle;

    private String phone;

    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
