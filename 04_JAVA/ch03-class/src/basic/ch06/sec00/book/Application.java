package basic.ch06.sec00.book;

public class Application {
    public static void main(String[] args) {

        // 객체 만들기
        // new로 만들었으니 heap에 준비되어있음.
        Book myBook = new Book();
        myBook.title = "해리포터와 마법사의 돌";
        myBook.author = "조엔 K 롤링";
        myBook.coverType = "하드커버";
        myBook.pageCount = 320;

        System.out.println(myBook.title);

        Book myBook2 = new Book("조엔 K 롤링", "해리포터와 혼혈왕자", "소프트커버",320);

        myBook2.introduce();

        System.out.println(myBook2);
    }
}
