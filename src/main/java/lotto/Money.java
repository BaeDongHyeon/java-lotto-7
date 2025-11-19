package lotto;

public class Money {

    private int price = 0;

    public Money(String money) {
        validate(money);
    }

    private void validate(String money) {
        try {
            price = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.");
        }

        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000보다 작을 수 없습니다.");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력할 수 있습니다.");
        }
    }

    public int getPrice() {
        return price;
    }
}
