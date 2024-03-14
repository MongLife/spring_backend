package com.mongs.core.security.principal;

import com.mongs.core.vo.passport.PassportVO;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Getter
@ToString
public class PassportDetail extends User {
    private final long id;
    private final String deviceId;
    private final String email;
    private final LocalDate loginAt;
    private final String name;
    private final String passportJson;

    public PassportDetail(PassportVO passportVo) {
        this(passportVo, "");
    }

    public PassportDetail(PassportVO passportVO, String passportJson) {
        super(
                passportVO.data().account().email(),
                UUID.randomUUID().toString(),
                Arrays.stream(passportVO.data().account().role().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );

        this.id = passportVO.data().account().id();
        this.deviceId = passportVO.data().account().deviceId();
        this.email = passportVO.data().account().email();
        this.loginAt = passportVO.data().account().loginAt();
        this.name = passportVO.data().account().name();
        this.passportJson = passportJson;
    }
}
