package com.mongs.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongs.auth.passport.PassportMember;
import lombok.Builder;

@Builder
public record PassportResDto(
        PassportMember member,
        String passportIntegrity
) {
}
