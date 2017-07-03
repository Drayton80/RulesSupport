package oppositeroom.rulessupport.estruturas;

import java.util.Random;

/**
 * Created by root on 03/07/17.
 */

public enum Dado {
    D2(2),D3(3),D4(4),D6(6),D8(8),D10(10),D12(12),D20(20),D100(100);

    private int dado;

    Dado(int i) {
        dado = i;
    }

    public int rolarDado() {
        return new Random().nextInt(dado) + 1;
    }
}
