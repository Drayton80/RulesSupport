package oppositeroom.rulessupport.estruturas;

/**
 * Created by drayt on 20/06/2017.
 */

public class Arma {
    private String nome = "";                   //Nome da Arma em questão, contendo o indicador OP para Obra Prima, caso possua
    private String categoria = "";              //Corpo à corpo ou à distância
    private String dano = "1d0";
    private String dano_adicional = "";         //Danos especiais, como fogo, veneno, etc.
    private int modificador_de_dano = 0;
    private int modificador_de_ataque = 0;
    //Ainda falta a penalidade por ataque, como, por exemplo, devido à Combater com Duas Armas ou Ataques Mútliplos, mas
    //tal penalidade pode ser atribuida e calculada na tela de cadastro e registro da seguinte forma:
    //  outros_atque = outros + penalidade (que será negativa)


   /*-*-------------------------------// Construtor da Classe \\------------------------------------*-*/
    public Arma(String nome, String categoria, String dano, String dano_adicional, int mFor, int mDes,
                int bba, int outros_ataque, int outros_dano){

        this.nome = nome;
        this.categoria = categoria;
        this.dano  = dano;
        this.dano_adicional = dano_adicional;


        //Podemos fazer a categoria como um botão de seleção, tipo aquele que fizemos para escolher
        //o tipo de obra de arte (se era aquarela, foto, vídeo, etc.)
        if(categoria.equals("corpo")){
            modificador_de_ataque = mFor + outros_ataque + bba;
            modificador_de_dano   = mFor + outros_dano;
        }

        //Caso possua o talento acuidade com arma:
        if(categoria.equals("corpo destreza")){
            modificador_de_ataque = mDes + outros_ataque + bba;
            modificador_de_dano   = mFor + outros_dano;
        }

        if(categoria.equals("distancia")){
            modificador_de_ataque = mDes + outros_ataque + bba;
            modificador_de_dano   = outros_dano;
        }

    }
   /*-*-------------------------------\\----------------------//------------------------------------*-*/



   /*-*---------------------------------------// Métodos \\--------------------------------------------*-*/


    public void atualiza_modificadores(int mFor, int mDes, int bba, int outros_ataque, int outros_dano){
        //Podemos fazer a categoria como um botão de seleção, tipo aquele que fizemos para escolher
        //o tipo de obra de arte (se era aquarela, foto, vídeo, etc.)
        if(categoria.equals("corpo")){
            modificador_de_ataque = mFor + outros_ataque + bba;
            modificador_de_dano   = mFor + outros_dano;
        }

        //Caso possua o talento acuidade com arma:
        if(categoria.equals("corpo destreza")){
            modificador_de_ataque = mDes + outros_ataque + bba;
            modificador_de_dano   = mFor + outros_dano;
        }

        if(categoria.equals("distancia")){
            modificador_de_ataque = mDes + outros_ataque + bba;
            modificador_de_dano   = outros_dano;
        }
    }


    /*---------------------------------| Métodos de Escrita |--------------------------------------*/
    public void set_nome(String nome){
        this.nome = nome;
    }

    public void set_categoria(String categoria, int mFor, int mDes, int bba, int outros_ataque,
                              int outros_dano){

        this.categoria = categoria;

        atualiza_modificadores(mFor, mDes, bba, outros_ataque, outros_dano);
    }


    public void set_dano(String dano){
        this.dano = dano;
    }

    public void setDano_adicional(String dano_adicional){
        this.dano_adicional = dano_adicional;
    }

    public void set_modificador_de_dano(int modificador_de_dano){
        this.modificador_de_dano =  modificador_de_dano;
    }

    public void set_modificador_de_ataque(int modificador_de_ataque){
        this.modificador_de_ataque = modificador_de_ataque;
    }
    /*---------------------------------|--------------------|--------------------------------------*/


    /*---------------------------------| Métodos de Leitura |--------------------------------------*/
    public String get_nome(){
        return nome;
    }

    public String get_categoria(){
        return categoria;
    }

    public String get_dano(){
        return dano;
    }

    public String get_dano_adicional(){
        return dano_adicional;
    }

    public int get_modificador_de_dano(){
        return modificador_de_dano;
    }

    public int get_modificador_de_ataque(){
        return modificador_de_ataque;
    }
    /*---------------------------------|--------------------|--------------------------------------*/

   /*-*---------------------------------------\\---------//--------------------------------------------*-*/
}
