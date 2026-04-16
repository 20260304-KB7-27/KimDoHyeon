package basic.ch06.sec11.exam02;

public class Earth {

    String mainSatellite = "달";

    /*
    * Static
    * - 클래스 자체에 소속된다.
    * - 모든 인스턴스들이 동일한 값을 유지해야할 때
    *
    * 인스턴스를 만들지 않고도 클래스명.참조 가능
    * */

    // final : 상수 -> 수정 불가
    static final int EARTH_RADIUS = 6400;
    static final double EARTH_SURFACE_AREA;

//    public static int getEarthRadius() {
//
//        return earthRadius;
//    }
    
    // 정적 블록
    // 클래스가 메모리에 할당될 때 딱 한 번 실행되는 블록
    // static 멤버를 초기화할 때 주로 사용
     static {
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }
    // 인스턴스 블록
    // 인스턴스가 만들어질 때마다 초기화 하는 블록
    {
        mainSatellite = "스타링크";
    }
}
