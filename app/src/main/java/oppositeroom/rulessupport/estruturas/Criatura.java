package oppositeroom.rulessupport.estruturas;

/** Classe Criatura
 *    Descrição:
 *      Classe que servirá de instância para qualquer criatura criada, sendo tal classe feita sob
 *      os moldes de criaturas relativas ao D&D 3.5.
 *
 *  Grupo: Opposite Room
 *    Autores: Drayton80, EwertonDNSantos
 *
 */

public class Criatura {
    //Habilidades:
    protected int hFor, hDes, hCon, hSab, hInt, hCar;
    //Modificadores de Habilidades:
    protected int mFor, mDes, mCon, mSab, mInt, mCar;
    //Nível de Desafio:
    protected double nd;
    //Vida da Criatura:
    protected int pv;
    protected String dados_de_vida;
    //Deslocamento:
    protected String deslocamento, escalada, natacao;

    //Testes de Resistência e Outros Modificadores que os Influenciam:
    private int fortitude, reflexos, vontade;
    private int classe_fortitude = 0;
    private int[] outros_fortitude = {0, 0, 0, 0, 0};
    private int classe_reflexos = 0;
    private int[] outros_reflexos = {0, 0, 0, 0, 0};
    private int classe_vontade = 0;
    private int[] outros_vontade = {0, 0, 0, 0, 0};

    //Modificadores de Combate:
    protected int ataque_base, agarrar, iniciativa;
    protected int ca, toque, surpresa;
    protected int[] outros_iniciativa = {0, 0, 0};
    protected int[] outros_agarrar = {0, 0, 0};

    //Detalhes de Combate:
    protected String corpo, distancia, total_corpo, total_distancia;
    //Espaço e Tamanho:
    protected String espaco, alcance, tamanho;
    //Dados da Criatura:
    protected String nome, tipo, subtipos;
    //Tendência e Características Especiais:
    protected String tendencia;
    protected String qualidades_especiais;
    protected String ataques_especiais;

    //Classe de Armadura e suas Variáveis:
    protected int armadura = 0;
    protected int armadura_natural = 0;
    protected int[] outros_modificadores_armadura = {0, 0, 0};
    protected int[] outros_modificadores_armadura_destreza = {0, 0, 0};

    //Equipamentos em uso:
    private String[] armas = {"", "", "", "", "", ""};
    private String armadura_equipamento = "";
    private String[] outros_equipamentos = {"", "", "", "", "", ""};
    //for(...) { armas[i].equals("") ? "" : armas[i]; --> para não poluir ao exibir os vazios

    //Talentos, perícias e tesouros:
    private String[] talentos;
    private Pericia[] pericias;
    private String[] moedas = {"0 PC", "0 PP", "0 PO", "0 PL"};
    private String[] gemas = {"", "", "", "", "", "", "", "", "", "", ""};
    private String[] obras_arte = {"", "", "", "", "", "", "", "", "", "", ""};
    //AQUI PODE SER UM OBJETO DA CLASSE TESOURO EM VEZ DE CADA STRING SEPARADO *-*
    //NOTA: Fazer um construtor sobrecarregado na classe tesouro



   /*---------------------------// Construtores da Classe \\--------------------------------*/

    /*----------------------------| Formato de Bloco |--------------------------------*/
    /** Descrição:
     *    Esse construtor recebe todos os parâmetros no mesmo formato de um bloco de estatísticas
     *    de uma criatura (D&D 3.5, Livro do Mestre, Página 84) com algumas alterações para que
     *    sejam recebidas também talentos e perícias.
     */
    public Criatura ( String nome, double nd, String tipo, String tamanho, String subtipos,
                      String dados_de_vida, int pv, int iniciativa, String deslocamento,
                      String escalada, String natacao, int ca, int toque, int surpresa,
                      int ataque_base, int agarrar, String corpo, String distancia,
                      String total_corpo, String total_distancia, String espaco,
                      String alcance, String ataques_especiais,
                      String qualidades_especiais, String tendencia,
                      int fortitude, int reflexos, int vontade,
                      int hFor, int hDes, int hCon, int hSab, int hInt, int hCar,
                      String[] talents, Pericia[] peric){

        this.nome = nome;
        this.nd = nd;

        this.tipo = tipo;
        this.tamanho = tamanho;
        this.subtipos = subtipos;

        this.dados_de_vida = dados_de_vida;
        this.pv = pv;

        this.deslocamento = deslocamento;
        this.escalada = escalada;
        this.natacao = natacao;

        this.ataque_base = ataque_base;
        this.corpo = corpo;
        this.distancia = distancia;
        this.total_corpo = total_corpo;
        this.total_distancia = total_distancia;

        this.espaco = espaco;
        this.alcance = alcance;

        this.ataques_especiais = ataques_especiais;
        this.qualidades_especiais = qualidades_especiais;

        this.tendencia = tendencia;

        this.fortitude = fortitude;
        this.reflexos = reflexos;
        this.vontade = vontade;


        //---Habilidades---//
        this.hFor = hFor;
        this.hDes = hDes;
        this.hCon = hCon;
        this.hSab = hSab;
        this.hInt = hInt;
        this.hCar = hCar;
        //-----------------//

        //------Modificadores de Habilidade------//
        mFor = modificador_de_habilidade(hFor);
        mDes = modificador_de_habilidade(hDes);
        mCon = modificador_de_habilidade(hCon);
        mSab = modificador_de_habilidade(hSab);
        mInt = modificador_de_habilidade(hInt);
        mCar = modificador_de_habilidade(hCar);
        //----------------------------------------//

        //Instanciando e atribuindo os valores ao String talentos
        talentos = new String[talents.length];

        for(int i = 0; i < talentos.length; i++){
            talentos[i] = talents[i];
        }
        //Fim do processo

        //Instanciando e atribuindo os valores ao String perícias
        pericias = new Pericia[peric.length];

        for(int i = 0; i < pericias.length; i++){
            pericias[i] = peric[i];
        }
        //Fim do processo

    }
    /*-----------------------------|---------------------|--------------------------------*/


    /*----------------------------| Valores Automáticos |--------------------------------*/
    /** Descrição:
     *    Esse construtor recebe todos quase todos os dados de uma criatura e calcula automaticamente
     *    os que sobraram.
     */
    public Criatura ( String nome, double nd, String tipo, String tamanho, String subtipos,
                      String dados_de_vida, int pv, String deslocamento,
                      String escalada, String natacao,
                      int ataque_base, String corpo, String distancia,
                      String total_corpo, String total_distancia, String espaco,
                      String alcance, String ataques_especiais,
                      String qualidades_especiais, String tendencia,
                      int hFor, int hDes, int hCon, int hSab, int hInt, int hCar,
                      String[] talents, Pericia[] peric){

        this.nome = nome;
        this.nd = nd;

        this.tipo = tipo;
        this.tamanho = tamanho;
        this.subtipos = subtipos;

        this.dados_de_vida = dados_de_vida;
        this.pv = pv;

        this.deslocamento = deslocamento;
        this.escalada = escalada;
        this.natacao = natacao;

        this.ataque_base = ataque_base;
        this.corpo = corpo;
        this.distancia = distancia;
        this.total_corpo = total_corpo;
        this.total_distancia = total_distancia;

        this.espaco = espaco;
        this.alcance = alcance;

        this.ataques_especiais = ataques_especiais;
        this.qualidades_especiais = qualidades_especiais;

        this.tendencia = tendencia;

        this.fortitude = fortitude;
        this.reflexos = reflexos;
        this.vontade = vontade;


        //---Habilidades---//
        this.hFor = hFor;
        this.hDes = hDes;
        this.hCon = hCon;
        this.hSab = hSab;
        this.hInt = hInt;
        this.hCar = hCar;
        //-----------------//

        //------Modificadores de Habilidade------//
        mFor = modificador_de_habilidade(hFor);
        mDes = modificador_de_habilidade(hDes);
        mCon = modificador_de_habilidade(hCon);
        mSab = modificador_de_habilidade(hSab);
        mInt = modificador_de_habilidade(hInt);
        mCar = modificador_de_habilidade(hCar);
        //----------------------------------------//

        //-Atributos Automáticos-//
        calcula_armadura();
        calcula_iniciativa();
        calcula_resistencias();
        calcula_agarrar();
        //-----------------------//

        //Instanciando e atribuindo os valores ao String talentos
        talentos = new String[talents.length];

        for(int i = 0; i < talentos.length; i++){
            talentos[i] = talents[i];
        }
        //Fim do processo

        //Instanciando e atribuindo os valores ao String perícias
        pericias = new Pericia[peric.length];

        for(int i = 0; i < pericias.length; i++){
            pericias[i] = peric[i];
        }
        //Fim do processo

    }
    /*----------------------------|---------------------|--------------------------------*/

   /*---------------------------\\------------------------//--------------------------------*/




   /*----------------------------// Métodos de Classe \\-----------------------------*/

    /** Gerador dos Modificadores de Habilidades
     *    Descrição
     *      O método recebe como parâmetro uma habilidade e, com base nela,
     *      atribui um valor ao seu modificador segundo a Tabela 1-1 do
     *      Livro do Jogador (Player's Handbook) do D&D 3.5.
     *
     *    Retorno:
     *      O método retorna um valor inteiro que representa o modificador
     *      de habilidade.
     *
     */
    protected static int modificador_de_habilidade(int habilidade){
        int modificador = 0;

        switch(habilidade){
            case 1:
                modificador = -5;
                break;
            case 2: case 3:
                modificador = -4;
                break;
            case 4: case 5:
                modificador = -3;
                break;
            case 6: case 7:
                modificador = -2;
                break;
            case 8: case 9:
                modificador = -1;
                break;
            case 10: case 11:
                modificador = 0;
                break;
            case 12: case 13:
                modificador = 1;
                break;
            case 14: case 15:
                modificador = 2;
                break;
            case 16: case 17:
                modificador = 3;
                break;
            case 18: case 19:
                modificador = 4;
                break;
            case 20: case 21:
                modificador = 5;
                break;
            case 22: case 23:
                modificador = 6;
                break;
            case 24: case 25:
                modificador = 7;
                break;
            case 26: case 27:
                modificador = 8;
                break;
            case 28: case 29:
                modificador = 9;
                break;
            case 30: case 31:
                modificador = 10;
                break;
            case 32: case 33:
                modificador = 11;
                break;
            case 34: case 35:
                modificador = 12;
                break;
            case 36: case 37:
                modificador = 13;
                break;
            case 38: case 39:
                modificador = 14;
                break;
            case 40: case 41:
                modificador = 15;
                break;
            case 42: case 43:
                modificador = 16;
                break;
            case 44: case 45:
                modificador = 17;
                break;
            case 46: case 47:
                modificador = 18;
                break;
            case 48: case 49:
                modificador = 19;
                break;
            case 50: case 51:
                modificador = 20;
                break;
            default:
                modificador = 0;
        }

        return modificador;
    }

   /*----------------------------\\-------------------//-----------------------------*/




   /*----------------------------// Métodos de Instância \\-----------------------------*/

    /** Calculador de Classe de Armadura:
     *    Descrição:
     *      Automatiza uma fórmula simples que cálcula a CA da criatura.
     *
     */
    protected void calcula_armadura(){
        int outros_armadura = 0;
        int outros_destreza = 0;

        for(int i = 0; i < outros_modificadores_armadura.length; i++){
            outros_armadura = outros_armadura + outros_modificadores_armadura[i];
        }

        for(int i = 0; i < outros_modificadores_armadura_destreza.length; i++){
            outros_destreza = outros_destreza + outros_modificadores_armadura_destreza[i];
        }

        ca = 10 + mDes + armadura + armadura_natural + outros_armadura + outros_destreza;
        toque = 10 + mDes + outros_destreza;
        surpresa = 10 + armadura + armadura_natural + outros_armadura;
    }


    /** Calculador de Testes de Resistência
     *    Descrição:
     *      Faz a somatória de todos os testes de resistência.
     *
     */
    protected void calcula_resistencias(){
        int outros_f = 0;
        int outros_r = 0;
        int outros_v = 0;

        for(int i = 0; i < outros_fortitude.length; i++){
            outros_f = outros_f + outros_fortitude[i];
        }

        for(int i = 0; i < outros_reflexos.length; i++){
            outros_r = outros_r + outros_reflexos[i];
        }

        for(int i = 0; i < outros_vontade.length; i++){
            outros_v = outros_v + outros_vontade[i];
        }

        fortitude = classe_fortitude + mCon + outros_f;
        reflexos = classe_reflexos + mDes + outros_r;
        vontade = classe_vontade + mSab + outros_v;
    }


    /** Calculador de Iniciativa da Criatura
     *    Descrição:
     *      Faz a soma de todos os outros modificadores que influenciam na iniciativa com
     *      o modificador de destreza.
     */
    protected void calcula_iniciativa(){
        int somatoria_outros = 0;

        for(int i = 0; i < outros_iniciativa.length; i++){
            somatoria_outros = somatoria_outros + outros_iniciativa[i];
        }

        iniciativa = mDes + somatoria_outros;
    }


    /** Calculador de Teste de Agarrar
     *    Descrição:
     *      Através da fórmula proposta no Livro do Jogador (D&D 3.5) na página 122 é feito
     *      o somatório do teste de agarrar da criatura.
     */
    protected void calcula_agarrar(){
        int modificador_tamanho = 0;
        int somatorio_outros = 0;

       // Modificador Especial de Tamanho: o teste de agarrar possuí um modificador
       // especial atreçado ao tamnho da criatura em questão, os "If's" a seguir
       // obtem ele.
        if(tamanho.equals("Colossal") || tamanho.equals("colossal")){
            modificador_tamanho = 16;
        }

        if(tamanho.equals("Imenso") || tamanho.equals("imenso")){
            modificador_tamanho = 12;
        }

        if(tamanho.equals("Enorme") || tamanho.equals("enorme")){
            modificador_tamanho = 8;
        }

        if(tamanho.equals("Grande") || tamanho.equals("grande")){
            modificador_tamanho = 16;
        }

        if(tamanho.equals("Pequeno") || tamanho.equals("pequeno")){
            modificador_tamanho = -4;
        }

        if(tamanho.equals("Miúdo") || tamanho.equals("miúdo") ||
           tamanho.equals("Miudo") || tamanho.equals("miudo") ){
            modificador_tamanho = -8;
        }

        if(tamanho.equals("Mínimo") || tamanho.equals("mínimo") ||
           tamanho.equals("Minimo") || tamanho.equals("minimo") ){
            modificador_tamanho = -12;
        }

        if(tamanho.equals("Minúsculo") || tamanho.equals("minúsculo") ||
           tamanho.equals("Minusculo") || tamanho.equals("minusculo") ){
            modificador_tamanho = -16;
        }

        for(int i = 0; i < outros_agarrar.length; i++){
            somatorio_outros = somatorio_outros + outros_agarrar[i];
        }

        agarrar = ataque_base + mFor + modificador_tamanho + somatorio_outros;
    }


    /** Atualizador de Dados e Atributos:
     *    Descrição:
     *      Esse método atualiza todos os dados que envolvem um cálculo especifico
     *      para gerar um atributo (como, por exemplo, a CA = 10 + ...). O objetivo
     *      de sua existência consiste na necessidade de atualizar os dados para
     *      caso haja uma mudança ou edição na criatura.
     *
     *    Observação Importante:
     *      Deve ser chamado toda vez que for feita alguma alteração nos
     *      atributos e nos "outros" modificadores que contribuem com os
     *      mesmos.
     *
     */
    protected void atualiza_dados(){
        calcula_armadura();
        calcula_resistencias();
        calcula_iniciativa();
        calcula_agarrar();
    }

   /*----------------------------\\----------------------//-----------------------------*/




   /*-----------------------------// Métodos de Escrita \\------------------------------*/

   /*--------------| Habilidades e seus Modificadores |----------------*/
    public void set_hFor(int hFor){
        //Habilidade:
        this.hFor = hFor;
        //Atualizando o Modificador da Habilidade:
        mFor = modificador_de_habilidade(this.hFor);
    }

    public void set_hDes(int hDes){
        //Habilidade:
        this.hDes = hDes;
        //Atualizando o Modificador da Habilidade:
        mDes = modificador_de_habilidade(this.hDes);
    }

    public void set_hCon(int hCon){
        //Habilidade:
        this.hCon = hCon;
        //Atualizando o Modificador da Habilidade:
        mCon = modificador_de_habilidade(this.hCon);
    }

    public void set_hSab(int hSab){
        //Habilidade:
        this.hSab = hSab;
        //Atualizando o Modificador da Habilidade:
        mSab = modificador_de_habilidade(this.hSab);
    }

    public void set_hInt(int hInt){
        //Habilidade:
        this.hInt = hInt;
        //Atualizando o Modificador da Habilidade:
        mInt = modificador_de_habilidade(this.hInt);
    }

    public void set_hCar(int hCar){
        //Habilidade:
        this.hCar = hCar;
        //Atualizando o Modificador da Habilidade:
        mCar = modificador_de_habilidade(this.hCar);
    }

    /*----------------------------| Outros Modificadores |----------------------------*/

    //----------------- Modificadores de Armadura ----------------------//
    public void set_outros_modificadores_armadura(int[] modificadores){
        if (modificadores.length == outros_modificadores_armadura.length) {
            for (int i = 0; i < modificadores.length; i++) {
                outros_modificadores_armadura[i] = modificadores[i];
            }

            atualiza_dados();
        }
    }

    public void set_outros_modificadores_destreza(int[] modificadores){
        if (modificadores.length == outros_modificadores_armadura_destreza.length) {
            for (int i = 0; i < modificadores.length; i++) {
                outros_modificadores_armadura_destreza[i] = modificadores[i];
            }

            atualiza_dados();
        }
    }
    //------------------------------------------------------------------//

    //-------------- Modificadores dos Testes de Resistência -------------------//
    public void set_outros_fortitude(int[] outros){
        if (outros.length == outros_fortitude.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_fortitude[i] = outros[i];
            }

            atualiza_dados();
        }
    }

    public void set_classe_fortitude(int classe_fortitude){
        this.classe_fortitude = classe_fortitude;

        atualiza_dados();
    }

    public void set_outros_reflexos(int[] outros){
        if (outros.length == outros_reflexos.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_reflexos[i] = outros[i];
            }

            atualiza_dados();
        }
    }

    public void set_classe_reflexos(int classe_reflexos){
        this.classe_reflexos = classe_reflexos;

        atualiza_dados();
    }

    public void set_outros_vontade(int[] outros){
        if (outros.length == outros_vontade.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_vontade[i] = outros[i];
            }

            atualiza_dados();
        }
    }

    public void set_classe_vontade(int classe_vontade){
        this.classe_vontade = classe_vontade;

        atualiza_dados();
    }
    //--------------------------------------------------------------------------//

    //-------------- Outros Mod. de Iniciativa -------------------//
    public void set_outros_iniciativa(int[] outros){
        if (outros.length == outros_iniciativa.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_iniciativa[i] = outros[i];
            }

            atualiza_dados();
        }
    }
    //------------------------------------------------------------//

    //-------------- Outros Mod. de Agarrar -------------------//
    public void set_outros_agarrar(int[] outros){
        if (outros.length == outros_agarrar.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_agarrar[i] = outros[i];
            }

            atualiza_dados();
        }
    }
    //---------------------------------------------------------//

    //-------------- Mod. de Armadura -------------------//
    public void set_armadura(int armadura){
        this.armadura = armadura;

        atualiza_dados();
    }

    public void set_armadura_natural(int armadura_natural){
        this.armadura_natural = armadura_natural;

        atualiza_dados();
    }
    //---------------------------------------------------//

    /*----------------------------|----------------------|----------------------------*/

   /*-----------------------------\\--------------------//------------------------------*/
}

