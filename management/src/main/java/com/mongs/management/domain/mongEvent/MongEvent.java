package com.mongs.management.domain.mongEvent;

import com.mongs.core.time.BaseTimeEntity;
import com.mongs.management.domain.mong.service.enums.MongCollapse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class MongEvent extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    private Long mongId;

    @Enumerated(EnumType.STRING)
    private MongCollapse collapse;
}
