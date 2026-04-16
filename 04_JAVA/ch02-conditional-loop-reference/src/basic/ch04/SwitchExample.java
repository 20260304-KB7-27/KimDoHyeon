package basic.ch04;

public class SwitchExample {
    public static void main(String[] args) {

        // Switch로
        // 특정 case 별로 코드를 분기하고 싶을 때 사용

        char grade = 'A';
        // char ''
        // String ""

//        switch (grade) {
//            case 'A' :
//            case 'a' :
//                System.out.println("A입니다!");
//                break;
//            case 'B' :
//                System.out.println("B입니다!");
//            default :
//                System.out.println("기본값입니다!");
//        }

        // 개선된 switch문
        // 화살표 문법
        // break 없어도 알아서 멈춤!
        // 값 반환
//        switch (grade) {
//            case 'A', 'a' -> System.out.println("A입니다!");
//            case 'B' -> System.out.println("B입니다!");
//            default -> System.out.println("기본값입니다!");
//        }


//        String result = switch (grade) {
//            case 'A', 'a' -> "A입니다!";
//            case 'B' -> "B입니다!";
//            default -> "기본값입니다!";
//        };

        String result = switch (grade) {
            case 'A', 'a' -> {
                System.out.println("실행됨");
                yield "A입니다!"; // 반환값 지정
            }
            case 'B' -> "B입니다!";
            default -> "기본값입니다!";
        };
    }
}
