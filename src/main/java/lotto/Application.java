package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoPaper lottoPaper = new LottoPaper();

        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(Console.readLine());

        List<Lotto> lottos = lottoMachine.buy(money);
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        lottoPaper.writeBasicNumbers(Console.readLine());
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        lottoPaper.writeBonusNumber(Console.readLine());
        System.out.println();

        for (Lotto lotto : lottos) {
            System.out.println(lottoPaper.matchedNumber(lotto));
            System.out.println(lottoPaper.isMatchedBonusNumber(lotto));
        }
    }
}
