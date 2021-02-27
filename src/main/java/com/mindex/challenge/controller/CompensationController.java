package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private CompensationService compensationService;

    @GetMapping("/compensation/employee/{id}")
    public List<Compensation> read(@PathVariable String id) {
        LOG.debug("Received get Compensation request for employee with ID: [{}]", id);

        return compensationService.GetCompensationByEmployeeId(id);
    }

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received create Compensation request for [{}]", compensation.getEmployee());

        return compensationService.Create(compensation);
    }
}