package oppositeroom.rulessupport.estruturas;

/** Classe Talento
 *    Descrição:
 *      Classe que servirá de instância para qualquer talento que uma Criatura possuir.
 *
 *  Grupo: Opposite Room
 *    Autor: Drayton80
 *
 */


public class Talento {

    private String nome =  "";
    private String descricao = "";

    /**-----------------------------------// Construtores \\----------------------------------------**/
    public Talento(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public Talento(){

    }
    /**-----------------------------------\\--------------//----------------------------------------**/


    /**-----------------------------------// Métodos de Escrita \\----------------------------------------**/
    public void set_nome(String nome){
        this.nome = nome;
    }

    public void set_descricao(String descricao){
        this.descricao = descricao;
    }
    /**-----------------------------------\\--------------------//----------------------------------------**/

    /**-----------------------------------// Métodos de Leitura \\----------------------------------------**/
    public String get_nome(){
        return nome;
    }

    public String get_descricao(){
        return descricao;
    }
    /**-----------------------------------\\--------------------//----------------------------------------**/

}
