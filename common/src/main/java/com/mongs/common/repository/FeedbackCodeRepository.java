package com.mongs.common.repository;

import com.mongs.core.entity.FeedbackCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackCodeRepository extends MongoRepository<FeedbackCode, String> {
}
