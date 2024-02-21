package com.mongs.collection.repository;

import com.mongs.collection.entity.MapCollection;
import com.mongs.core.code.GroupCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class MapCollectionRepositoryTest {
    @Autowired
    private MapCollectionRepository mapCollectionRepository;

    @Test
    @DisplayName("맵 컬렉션 id를 입력하지 않아도 id가 등록된다.")
    void autoMemberId() {
        // given
        Long memberId = 1L;
        String groupCode = GroupCode.MAP.getGroupCode();
        String code = "MP000";

        MapCollection mapCollection = MapCollection.builder()
                .memberId(memberId)
                .groupCode(groupCode)
                .code(code)
                .build();

        // when
        MapCollection saveMapCollection = mapCollectionRepository.save(mapCollection);

        // then
        Long mapCollectionId = saveMapCollection.getId();
        assertThat(mapCollectionId).isNotNull();
        assertThat(mapCollectionId).isEqualTo(1L);
    }

    @Test
    @DisplayName("맵 컬렉션 등록 일자가 자동으로 등록된다.")
    void autoCreatedAt() {
        // given
        Long memberId = 1L;
        String groupCode = GroupCode.MAP.getGroupCode();
        String code = "MP000";

        MapCollection mapCollection = MapCollection.builder()
                .memberId(memberId)
                .groupCode(groupCode)
                .code(code)
                .build();

        LocalDateTime expected = LocalDateTime.now().plusSeconds(1);

        // when
        MapCollection saveMapCollection = mapCollectionRepository.save(mapCollection);

        // then
        LocalDateTime createdAt = saveMapCollection.getCreatedAt();
        assertThat(createdAt).isNotNull();
        assertThat(createdAt).isBeforeOrEqualTo(expected);
    }

    @Test
    @DisplayName("회원 id 를 기준으로 조회하면 회원의 맵 컬렉션 목록을 반환한다.")
    void findByMemberId() {
        // given
        Long memberId = 1L;
        String groupCode = GroupCode.MAP.getGroupCode();

        for (long codeNumber = 0; codeNumber < 10; codeNumber++) {
            mapCollectionRepository.save(MapCollection.builder()
                    .memberId(memberId)
                    .groupCode(groupCode)
                    .code(String.format("MP%03d", codeNumber))
                    .build());
        }

        // when
        List<MapCollection> mapCollectionList = mapCollectionRepository.findByMemberId(memberId);

        // then
        assertThat(mapCollectionList).isNotEmpty();

        AtomicInteger codeNumber = new AtomicInteger();
        mapCollectionList.forEach(mapCollection -> {
            assertThat(mapCollection).isNotNull();
            assertThat(mapCollection.getMemberId()).isEqualTo(memberId);
            assertThat(mapCollection.getGroupCode()).isEqualTo(groupCode);
            assertThat(mapCollection.getCode()).isEqualTo(String.format("MP%03d", codeNumber.getAndIncrement()));
        });
    }
}