package basic.ch06.sec00.book;

public class Book {

    // 필드 == 멤버변수 == 전역변수 == 인스턴스변수
    String author;
    String title;
    String coverType;
    int pageCount;

    // 생성자
    // 생성자가 하나도 없으면 컴파일러가 기본 생성자를 만들어준다.
    // 기본생성자 -> 매개변수가 하나도 없는 생성자
    Book() {
        System.out.println("기본생성자 호출함..");
    }

    // 생성자 오버로딩
    public Book(String author, String title, String coverType, int pageCount) {
        this.author = author;
        this.title = title;
        this.coverType = coverType;
        this.pageCount = pageCount;
    }

    public Book(String title, String author) {
        // this() : 생성자 최상단에 와야 함.
        this(title, author, "soft cover", 12);
//        this.author = author;
//        this.title = title;
    }
//    메서드
//    접근제어자 반환타입 메서드명(매개변수) {
//
//        return 반환값;
//    }

    // void : 반환할 값이 없을 때
    public void introduce() {
        System.out.println(title + " 책의 작가는 " + author + "입니다.");
    }

    @Override
    public String toString() {
        return title + " 책의 작가는 " + author + "입니다.";
    }
}
