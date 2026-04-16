package basic.ch05.sec03;

public class ArrayExample {
    public static void main(String[] args){
        // 배열
        // 같은 타입의 데이터 여러 개를 한 번에 관리할 때 사용

        int[] arr1; // 배열 변수 arr1 선언
        int[] arr2 = new int[] {1,2,3}; // 선언과 동시에 초기화
        int[] arr3 = {1,2,3}; // 생성자 생략 가능

//        arr1 = {1,2,3};
        arr1 = new int[] {1,2,3}; // 선언된 배열을 초기화할 때는 이 방식만 가능
        

        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
    }
}
