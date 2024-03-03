package com.mongs.common.repository;

import com.mongs.core.code.entity.MongCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongCodeRepository extends MongoRepository<MongCode, String> {
}
