package oppositeroom.rulessupport.estrutura;

import org.junit.Test;

import oppositeroom.rulessupport.estruturas.Habilidades;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Joseildo on 02/07/17.
 */

public class HabilidadesTest {
    @Test
    public void modificador_de_habilidade_test() {
        Habilidades habilidades = new Habilidades.Builder().hFor(8).hDes(9).hCon(10).hInt(11).hSab(12).hCar(13).build();
        assertEquals(-1,habilidades.getmFor());
        assertEquals(-1,habilidades.getmDes());
        assertEquals(0,habilidades.getmCon());
        assertEquals(0,habilidades.getmInt());
        assertEquals(1,habilidades.getmSab());
        assertEquals(1,habilidades.getmCar());
        habilidades = new Habilidades.Builder().hFor(14).hDes(15).hCon(16).hInt(17).hSab(18).hCar(19).build();
        assertEquals(2,habilidades.getmFor());
        assertEquals(2,habilidades.getmDes());
        assertEquals(3,habilidades.getmCon());
        assertEquals(3,habilidades.getmInt());
        assertEquals(4,habilidades.getmSab());
        assertEquals(4,habilidades.getmCar());

    }
}
