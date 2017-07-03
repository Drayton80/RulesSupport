package oppositeroom.rulessupport.estruturas;

/**
 * Created by Joseildo on 02/07/17.
 */

public class Habilidades {
    //Habilidades:
    private int hFor, hDes, hCon, hSab, hInt, hCar;
    //Modificadores de Habilidades:
    private int mFor, mDes, mCon, mSab, mInt, mCar;

    private Habilidades(Builder builder) {
        this.hFor = builder.hFor;
        this.hDes = builder.hDes;
        this.hCon = builder.hCon;
        this.hSab = builder.hSab;
        this.hInt = builder.hInt;
        this.hCar = builder.hCar;

        this.mFor = modificador_de_habilidade(this.hFor);
        this.mDes = modificador_de_habilidade(this.hDes);
        this.mCon = modificador_de_habilidade(this.hCon);
        this.mSab = modificador_de_habilidade(this.hSab);
        this.mInt = modificador_de_habilidade(this.hInt);
        this.mCar = modificador_de_habilidade(this.hCar);
    }

    public static class Builder {
        int hFor = 10, hDes = 10, hCon = 10, hSab = 10, hInt = 10, hCar = 10;
        //Modificadores de Habilidades:
        int mFor = 0, mDes = 0, mCon = 0, mSab = 0, mInt = 0, mCar = 0;

        public Builder() {
        }

        public Builder hFor(int hFor) {
            this.hFor = hFor;
            return this;
        }

        public Builder hDes(int hDes) {
            this.hDes = hDes;
            return this;
        }

        public Builder hCon(int hCon) {
            this.hCon = hCon;
            return this;
        }

        public Builder hSab(int hSab) {
            this.hSab = hSab;
            return this;
        }

        public Builder hInt(int hInt) {
            this.hInt = hInt;
            return this;
        }

        public Builder hCar(int hCar) {
            this.hCar = hCar;
            return this;
        }

        public Habilidades build() {
            return new Habilidades(this);
        }
    }

    private Habilidades(int hFor, int hDes, int hCon, int hSab, int hInt, int hCar) {
        this.hFor = hFor;
        this.hDes = hDes;
        this.hCon = hCon;
        this.hSab = hSab;
        this.hInt = hInt;
        this.hCar = hCar;

        this.mFor = modificador_de_habilidade(this.hFor);
        this.mDes = modificador_de_habilidade(this.hDes);
        this.mCon = modificador_de_habilidade(this.hCon);
        this.mSab = modificador_de_habilidade(this.hSab);
        this.mInt = modificador_de_habilidade(this.hInt);
        this.mCar = modificador_de_habilidade(this.hCar);
    }

    private int modificador_de_habilidade(int habilidade) {
        int valor = habilidade;
        int i = 0;

        if (habilidade >= 10) {
            valor -= 10;
        } else {
            valor = (10 - valor) + 1;
        }
        while (valor > 1) {
            i++;
            valor -= 2;
        }

        return habilidade < 10 ? -i : i;
    }

    public int gethFor() {
        return hFor;
    }

    public int gethDes() {
        return hDes;
    }

    public int gethCon() {
        return hCon;
    }

    public int gethSab() {
        return hSab;
    }

    public int gethInt() {
        return hInt;
    }

    public int gethCar() {
        return hCar;
    }

    public void sethFor(int hFor) {
        this.hFor = hFor;
        this.mFor = modificador_de_habilidade(this.hFor);
    }

    public void sethDes(int hDes) {
        this.hDes = hDes;
        this.mDes = modificador_de_habilidade(this.hDes);
    }

    public void sethCon(int hCon) {
        this.hCon = hCon;
        this.mCon = modificador_de_habilidade(this.hCon);
    }

    public void sethSab(int hSab) {
        this.hSab = hSab;
        this.mSab = modificador_de_habilidade(this.hSab);
    }

    public void sethInt(int hInt) {
        this.hInt = hInt;
        this.mInt = modificador_de_habilidade(this.hInt);
    }

    public void sethCar(int hCar) {
        this.hCar = hCar;
        this.mCar = modificador_de_habilidade(this.hCar);
    }

    public int getmFor() {
        return mFor;
    }

    public int getmDes() {
        return mDes;
    }

    public int getmCon() {
        return mCon;
    }

    public int getmSab() {
        return mSab;
    }

    public int getmInt() {
        return mInt;
    }

    public int getmCar() {
        return mCar;
    }
}
