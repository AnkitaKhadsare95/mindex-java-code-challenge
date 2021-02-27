package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Compensation {

    @JsonIgnore
    @Id
    private String CompensationId;

    private Employee employee;
    private int salary;
    private String effectiveDate;

    public Compensation() {
    }

    public String getCompensationId() {
        return CompensationId;
    }

    public void setCompensationId(String compensationId) {
        CompensationId = compensationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}