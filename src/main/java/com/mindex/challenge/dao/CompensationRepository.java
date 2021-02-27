package com.mindex.challenge.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mindex.challenge.data.Compensation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    List<Compensation> findByEmployeeEmployeeId(String id);
}
