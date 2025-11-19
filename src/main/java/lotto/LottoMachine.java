package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> buy(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int count = money.getPrice() / 1000;
        for (int i = 1; i <= count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
