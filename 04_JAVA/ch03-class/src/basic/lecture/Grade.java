package basic.lecture;

public enum Grade {

    // 권한 인증인가 설정시 USER / ADMIN
    A(95,"최우수"),
    B(85, "우수"),
    C(75,"보통");

    private final int score;
    private final String description;

    // 기본 생성자는 그냥 "객체만 만들어줘" 역할
    // final 필드는 반드시 선언할 때 값이 들어가야 해서 매개변수 생성자로 만들어 줘야 함.
    Grade(int score, String description) {
        this.score = score;
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }
}
