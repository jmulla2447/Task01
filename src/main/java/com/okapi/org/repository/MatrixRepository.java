package com.okapi.org.repository;

import com.okapi.org.model.entity.MatrixEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatrixRepository extends MongoRepository<MatrixEntity, String> {
}
