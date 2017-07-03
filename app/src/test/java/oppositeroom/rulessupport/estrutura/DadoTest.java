package oppositeroom.rulessupport.estrutura;

import org.junit.Assert;
import org.junit.Test;

import oppositeroom.rulessupport.estruturas.Dado;

/**
 * Created by root on 03/07/17.
 */

public class DadoTest {
    @Test
    public void rolarDadoTest() {
        Dado d = Dado.D2;
        int j;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 2)
                Assert.assertTrue(false);
        }

        d = Dado.D3;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 3)
                Assert.assertTrue(false);
        }

        d = Dado.D4;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 4)
                Assert.assertTrue(false);
        }

        d = Dado.D6;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 6)
                Assert.assertTrue(false);
        }

        d = Dado.D8;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 8)
                Assert.assertTrue(false);
        }

        d = Dado.D10;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 10)
                Assert.assertTrue(false);
        }

        d = Dado.D12;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 12)
                Assert.assertTrue(false);
        }

        d = Dado.D20;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 20)
                Assert.assertTrue(false);
        }

        d = Dado.D100;
        for (int i = 0; i < 100_000; i++) {
            j = d.rolarDado();
            if(j < 1 && j > 100)
                Assert.assertTrue(false);
        }
    }
}
