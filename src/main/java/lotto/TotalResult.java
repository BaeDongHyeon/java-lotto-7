package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.Rank.*;

public class TotalResult {
    private final Map<Rank, Integer> result = new HashMap<>();

    public TotalResult() {
        result.put(FIRST, 0);
        result.put(SECOND, 0);
        result.put(THIRD, 0);
        result.put(FOURTH, 0);
        result.put(FIFTH, 0);
    }

    public void addResult(Rank rank) {
        if (NONE != rank) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public void printResult() {
        System.out.println(FIFTH.getMessage() + " - " + result.get(FIFTH) + "개");
        System.out.println(FOURTH.getMessage() + " - " + result.get(FOURTH) + "개");
        System.out.println(THIRD.getMessage() + " - " + result.get(THIRD) + "개");
        System.out.println(SECOND.getMessage() + " - " + result.get(SECOND) + "개");
        System.out.println(FIRST.getMessage() + " - " + result.get(FIRST) + "개");
    }

    public void printRevenue(Money money) {
        int moneyPrice = money.getPrice();
        double revenue = (double) getTotalSum() / moneyPrice * 100;
        System.out.println("총 수익률은 " + revenue + "%입니다");
    }

    private int getTotalSum() {
        int sum = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }
}
