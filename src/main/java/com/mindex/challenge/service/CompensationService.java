package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

import java.util.List;

public interface CompensationService {

    List<Compensation> GetCompensationByEmployeeId(String id);
    Compensation Create(Compensation compensation);
}
