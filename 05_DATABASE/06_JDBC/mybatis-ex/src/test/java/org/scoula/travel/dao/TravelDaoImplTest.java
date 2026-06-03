package org.scoula.travel.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.TravelVO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravelDaoImplTest {

    TravelDao dao = new TravelDaoImpl();

    @Test
    void getTotalCount() {
        int count = dao.getTotalCount();

        System.out.println(count);

        Assertions.assertTrue(count > 0);
    }

    @Test
    void getTravels() {
        List<TravelVO> list = dao.getTravels(0,6);

        list.forEach(System.out::println);

        Assertions.assertNotNull(list);
    }

    @Test
    void getDistricts() {
        List<String> list = dao.getDistricts();

        list.forEach(System.out::println);

        Assertions.assertNotNull(list);
    }

    @Test
    void getTravelsByDistrict() {
        List<TravelVO> list = dao.getTravelsByDistrict("강원권");

        list.forEach(System.out::println);

        Assertions.assertNotNull(list);
    }

    @Test
    void insert() {
        TravelVO travelVO = TravelVO.builder()
                .district("강원권")
                .title("두물머리")
                .description("경치좋음")
                .address("남양주")
                .phone("111-222-3333")
                .build();

        dao.insert(travelVO);
    }

    @Test
    void update() {
        TravelVO travel = TravelVO.builder()
                .no(300L) // 수정할 데이터의 ID (DB에 실제로 존재하는 ID여야 테스트가 성공합니다)
                .district("부산")
                .title("광안리 해수욕장")
                .description("광안대교 야경이 아름다운 곳")
                .address("부산 수영구 광안해변로 219")
                .phone("051-622-4251")
                .build();
        dao.update(travel);
    }

    @Test
    void remove() {
        dao.remove(100L);
    }
}