package lotto;

public enum Rank {
    FIRST(1, "6개 일치 (2,000,000,000원)", 2000000000),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD(3, "5개 일치 (1,500,000원)", 1500000),
    FOURTH(4, "4개 일치 (50,000원)", 50000),
    FIFTH(5, "3개 일치 (5,000원)", 5000),
    NONE(0, "없음", 0);

    private final int number;
    private final String message;
    private final int price;

    Rank(int number, String message, int price) {
        this.number = number;
        this.message = message;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }

    public static Rank getRank(int matchedCount, boolean isBonusNumberMatched) {
        if (matchedCount == 6) {
            return FIRST;
        }
        if (matchedCount == 5 && isBonusNumberMatched) {
            return SECOND;
        }
        if (matchedCount == 5) {
            return THIRD;
        }
        if (matchedCount == 4) {
            return FOURTH;
        }
        if (matchedCount == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
