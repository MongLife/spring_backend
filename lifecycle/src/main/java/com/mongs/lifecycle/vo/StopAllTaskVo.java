package com.mongs.lifecycle.vo;

import com.mongs.lifecycle.code.MongEventCode;
import lombok.Builder;

@Builder
public record StopAllTaskVo(
        Long mongId
) {
}
