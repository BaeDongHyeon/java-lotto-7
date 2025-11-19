package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {

    private final List<Integer> numbers = new ArrayList<>();

    public void writeBasicNumbers(String basicNumbers) {
        basicValidate(basicNumbers);
    }

    public void writeBonusNumber(String bonusNumber) {
        bonusValidate(bonusNumber);
    }

    private void basicValidate(String basicNumbers) {
        String[] number = basicNumbers.split(",");

        if (number.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력할 수 있습니다.");
        }

        try {
            for (int i = 0; i < number.length; i++) {

                if (Integer.parseInt(number[i]) < 1) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1보다 작을 수 없습니다.");
                }

                if (!(1 <= Integer.parseInt(number[i]) && Integer.parseInt(number[i]) <= 45)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다.");
                }

                if (numbers.contains(Integer.parseInt(number[i]))) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호끼리 중복된 숫자는 입력할 수 없습니다.");
                }

                numbers.add(Integer.parseInt(number[i]));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    private void bonusValidate(String bonusNumber) {
        try {
            if (Integer.parseInt(bonusNumber) < 1) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1보다 작을 수 없습니다.");
            }

            if (!(1 <= Integer.parseInt(bonusNumber) && Integer.parseInt(bonusNumber) <= 45)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
            }

            numbers.add(Integer.parseInt(bonusNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    public int matchedNumber(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (lotto.getNumbers().contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchedBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(numbers.getLast());
    }
}
