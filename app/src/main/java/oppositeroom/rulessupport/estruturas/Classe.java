package oppositeroom.rulessupport.estruturas;

/** Classe Classe, eu sei... fica esquisito, mas fazer o que, né...
 *    Descrição:
 *      Classe que servirá de instância para qualquer Classe (seja de prestígio ou não) que uma
 *      Criatura possuir.
 *
 *  Grupo: Opposite Room
 *    Autores: Drayton80, EwertonDNSantos
 *
 */

public class Classe {
    private String nome = "";
    private int nivel = 0;


    public Classe(String nome, int nivel){
        this.nome = nome;
        this.nivel = nivel;
    }

    public Classe(){

    }


    public void set_nome(String nome){
        this.nome = nome;
    }
    public void set_nivel(int nivel){
        this.nivel = nivel;
    }

    public String get_nome(){
        return nome;
    }

    public int get_nivel(){
        return nivel;
    }
}
