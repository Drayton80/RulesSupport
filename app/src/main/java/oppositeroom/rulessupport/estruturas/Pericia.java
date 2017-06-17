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

    private String nome = "";
    private int modificador_pericia = 0;

    /**-----------------------------------// Construtores \\----------------------------------------**/
    public Pericia(String nome, int graduacoes, int modificador_habilidade, int outros_modificadores){
        this.nome = nome;

        modificador_pericia = graduacoes + modificador_habilidade + outros_modificadores;
    }

    public Pericia(String nome, int graduacoes, int modificador_habilidade){
        this.nome = nome;

        modificador_pericia = graduacoes + modificador_habilidade;
    }

    public Pericia(String nome, int modificador_habilidade){
        this.nome = nome;

        modificador_pericia = modificador_habilidade;
    }

    public Pericia(){
        
    }
    /**-----------------------------------\\--------------//----------------------------------------**/



    /**-----------------------------------// Métodos de Escrita \\----------------------------------------**/
    public void set_nome(String nome){
        this.nome = nome;
    }

    public void set_modificador_pericia(int modificador_pericia){
        this.modificador_pericia = modificador_pericia;
    }
    /**-----------------------------------\\--------------------//----------------------------------------**/


    /**-----------------------------------// Métodos de Leitura \\----------------------------------------**/
    public String get_nome(){
        return nome;
    }

    public int get_modificador_pericia(){
        return modificador_pericia;
    }
    /**-----------------------------------\\--------------------//----------------------------------------**/
}
