package junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* 단위테스트
* - 프로그램의 가장 작은 단위(메서드, 클래스)를 독립적으로 검증
* - 특정 기능이 의도대로 동작하는지 확인하기 위해 작성
*
* - 다른 외부 기능(DB,서버,외부 API...) 의존하지 않고 테스트하는 것이 이상적
* - 자동 실행이 되어야 한다.(반복해도 항상 성공해야 함.)
* */
class AssertionsTest {

    @Test // 테스트 멧드라는 의미 부여 -> JUNIT 테스트 대상으로 인식
    @DisplayName("테스트 예제") // 테스트 실행시 표시될 이름 지정
    void assertTest1(){
        assertEquals(4, 2*2, "곱셈 결과 확인");
    }

    @Test // 테스트 멧드라는 의미 부여 -> JUNIT 테스트 대상으로 인식
    @DisplayName("테스트 예제2") // 테스트 실행시 표시될 이름 지정
    @Disabled
    void assertTest2(){
        assertTrue(5 < 1, "조건이 참인지 확인");
    }

    @Test // 테스트 멧드라는 의미 부여 -> JUNIT 테스트 대상으로 인식
    void assertTest3(){
        assertNotNull(new Object(), "null이 아님을 확인");
    }

}