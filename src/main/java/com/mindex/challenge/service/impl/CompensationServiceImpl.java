package com.mindex.challenge.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<Compensation> GetCompensationByEmployeeId(String id) {
        LOG.debug("Fetching compensation for employeeId [{}]", id);

        List<Compensation> compensations = compensationRepository.findByEmployeeEmployeeId(id);
        if (compensations == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensations;
    }

    @Override
    public Compensation Create(Compensation compensation) {

        LOG.debug("Creating compensation [{}]", compensation);
        compensation.setCompensationId(UUID.randomUUID().toString());
        compensationRepository.insert(compensation);
        return compensation;
    }
}
