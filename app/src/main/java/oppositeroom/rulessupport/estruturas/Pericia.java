package oppositeroom.rulessupport.estruturas;

/** Classe Perícia
 *    Descrição:
 *      Classe que servirá de instância para qualquer perícia que uma Criatura possuir.
 *
 *  Grupo: Opposite Room
 *    Autores: Drayton80, EwertonDNSantos
 *
 */

public class Pericia {
    private String nome;
    private int modificador_pericia;

    public Pericia(String nome, int graduacoes, int modificador_habilidade, int outros_modificadores){
        this.nome = nome;

        modificador_pericia = 0;
    }

    public void set_nome(String nome){
        this.nome = nome;
    }

    public void set_modificador_pericia(int modificador_pericia){
        this.modificador_pericia = modificador_pericia;
    }

    public String get_nome(){
        return nome;
    }

    public int get_modificador_pericia(){
        return modificador_pericia;
    }
}
