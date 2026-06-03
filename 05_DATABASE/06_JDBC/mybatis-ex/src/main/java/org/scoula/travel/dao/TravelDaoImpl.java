package org.scoula.travel.dao;

import org.apache.ibatis.session.SqlSession;
import org.scoula.travel.database.MyBatisConfig;
import org.scoula.travel.domain.TravelVO;

import javax.naming.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/*
 * Sql Session 메서드
 * - selectOne(id): 결과가 정확히 1건인 select
 * - selectList(id): 결과가 0건 이상인 (응답이 List 형태로 나옴)
 * - insert(id, param): return이 영향 받은 행의 수
 * - update(id, param): return이 영향 받은 행의 수
 * - delete(id, param): return이 영향 받은 행의 수
 * Transaction
 * - commit(): 변경 사항을 DB에 반영
 * - rollback(): 변경사항 취소
 * */
public class TravelDaoImpl implements TravelDao{

    static final String NAMESPACE = "org.scoula.travel.dao.TravelDao.";


    @Override
    public int getTotalCount() {
        return MyBatisConfig.getSqlSession()
                .selectOne(NAMESPACE + "getTotalCount");
    }

    @Override
    public List<TravelVO> getTravels(int start, int end) {
        Map<String,Integer> param = new HashMap<>();
        param.put("start", start);
        param.put("end", end);

        return MyBatisConfig.getSqlSession()
                .selectList(NAMESPACE + "getTravels", param);
    }

    @Override
    public List<String> getDistricts() {
        return MyBatisConfig.getSqlSession()
                .selectList(NAMESPACE+"getDistricts");
    }

    @Override
    public List<TravelVO> getTravelsByDistrict(String district) {
        return MyBatisConfig.getSqlSession()
                .selectList(NAMESPACE + "getTravelsByDistrict", district);
    }

    @Override
    public Optional<TravelVO> getTravel(Long no) {
        return MyBatisConfig.getSqlSession()
                .selectOne(NAMESPACE + "getTravel", no);
    }

    // 트랜젝션 처리 메서드
    private void transaction(Consumer<SqlSession> action){
        try(SqlSession session = MyBatisConfig.getSqlSession()){
            action.accept(session);
            session.commit(); // DB에 반영
        }
    }

    @Override
    public void insert(TravelVO travel) {
        transaction(session -> session.insert(NAMESPACE + "insert", travel));
    }

    @Override
    public void update(TravelVO travel) {
        transaction(session -> session.update(NAMESPACE + "update", travel));
    }

    @Override
    public void remove(Long no) {
        transaction(session -> session.delete(NAMESPACE + "remove", no));
    }
}
