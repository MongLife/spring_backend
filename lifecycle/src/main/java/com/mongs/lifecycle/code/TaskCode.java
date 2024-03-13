package com.mongs.lifecycle.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskCode {

    // 알
    EGG(5L, 0D),
    // 주기적 감소
    WEIGHT_DOWN(5L, 0.5D),        // 15 분에 0.5 감소
    STRENGTH_DOWN(5L, 0.5D),      // 15 분에 0.5 감소
    SATIETY_DOWN(5L, 0.5D),       // 15 분에 0.5 감소
    HEALTHY_DOWN(5L, 0.5D),       // 15 분에 0.5 감소
    SLEEP_DOWN(5L, 0.5D),         // 15 분에 0.5 감소

    // 주기적 증가
    SLEEP_UP(60 * 15L, 0.5D),           // 15 분에 0.5 증가
    PAY_POINT_UP(60 * 15L, 0.5D),       // 15 분에 0.5 증가

    // 랜덤 생성
    POOP(60 * 60 * 6L, 1D),             // 최소 4 시간에 하나 씩 생성 (랜덤)

    // 죽음 (조건)
    DEAD_SATIETY(60 * 60 * 12L, -1D),   // 12 시간 이후 사망 (포만감 0 조건)
    DEAD_HEALTHY(60 * 60 * 12L, -1D),   // 12 시간 이후 사망 (포만감 0 조건)
    DEAD(0L, -1D),                      // 즉시 사망 (관리자)
    ;

    private final Long expiration;
    private final Double value;
}
