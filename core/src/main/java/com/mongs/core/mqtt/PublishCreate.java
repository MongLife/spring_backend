package com.mongs.core.mqtt;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PublishCreate(
        Long mongId,
        String name,
        String code,
        Double weight,
        Double strength,
        Double satiety,
        Double health,
        Double sleep,
        Integer poopCount,
        String stateCode,
        String shiftCode,
        Integer payPoint,
        LocalDateTime born
) {
}
