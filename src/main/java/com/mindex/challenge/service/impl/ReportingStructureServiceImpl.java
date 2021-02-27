package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Override
    public ReportingStructure getReportingStructure(String id) {
        Employee employee = employeeServiceImpl.read(id);

        LOG.debug("ReportingStructure for employee [{}]", employee);

        ReportingStructure reportingStructure = new ReportingStructure();

        reportingStructure.setEmployee(employee);

        reportingStructure.setNumberOfReports(getNumberOfReportsForEmployee(employee));

        return reportingStructure;
    }

    public int getNumberOfReportsForEmployee(Employee employee) {
        return getUniqueNumberOfReportsForEmployee(employee, new HashSet<>()).size();
    }

    public Set<Employee> getUniqueNumberOfReportsForEmployee(Employee employee, Set<Employee> allReportingEmployees){
        List<Employee> reportingEmployees = employee.getDirectReports();

        if (reportingEmployees != null && !allReportingEmployees.contains(employee)){
            for (Employee reportingEmployee: reportingEmployees) {
                allReportingEmployees.add(reportingEmployee);
                allReportingEmployees = getUniqueNumberOfReportsForEmployee(reportingEmployee, allReportingEmployees);
            }
        }
        return allReportingEmployees;
    }
}
