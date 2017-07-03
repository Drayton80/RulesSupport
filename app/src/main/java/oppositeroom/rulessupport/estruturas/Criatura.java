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

    private Habilidades habilidades;

    //Nível de Desafio:
    protected double nd;
    //Vida da Criatura:
    protected int pv;
    protected String dados_de_vida;
    //Deslocamento:
    protected String deslocamento, escalada, natacao;
    //Nivel Efetivo de Personagem:
    private int nivel_efetivo = 0;

    //Testes de Resistência e Outros Modificadores que os Influenciam:
    private int fortitude, reflexos, vontade;
    private int base_fortitude = 0;
    private int[] outros_fortitude = {0, 0, 0, 0, 0};
    private int base_reflexos = 0;
    private int[] outros_reflexos = {0, 0, 0, 0, 0};
    private int base_vontade = 0;
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
    private Talento[] talentos;
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
    /** Parametros:
     *
     * @param nome
     * @param nivel
     * @param nd
     * @param tipo
     * @param tamanho
     * @param subtipos
     * @param dados_de_vida
     * @param pv
     * @param iniciativa
     * @param deslocamento
     * @param escalada
     * @param natacao
     * @param ca
     * @param toque
     * @param surpresa
     * @param ataque_base
     * @param agarrar
     * @param corpo
     * @param distancia
     * @param total_corpo
     * @param total_distancia
     * @param espaco
     * @param alcance
     * @param ataques_especiais
     * @param qualidades_especiais
     * @param tendencia
     * @param fortitude
     * @param reflexos
     * @param vontade
     * @param habilidades
     * @param talents
     * @param peric
     */
    public Criatura ( String nome, int nivel, double nd, String tipo, String tamanho, String subtipos,
                      String dados_de_vida, int pv, int iniciativa, String deslocamento,
                      String escalada, String natacao, int ca, int toque, int surpresa,
                      int ataque_base, int agarrar, String corpo, String distancia,
                      String total_corpo, String total_distancia, String espaco,
                      String alcance, String ataques_especiais,
                      String qualidades_especiais, String tendencia,
                      int fortitude, int reflexos, int vontade,
                      Habilidades habilidades,
                      Talento[] talents, Pericia[] peric){

        this.nome = nome;
        nivel_efetivo = nivel;
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

        this.habilidades = habilidades;

        //Instanciando e atribuindo os valores ao String talentos
        talentos = new Talento[talents.length];

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
    /** Parametros:
     *
     * @param nome
     * @param nivel
     * @param nd
     * @param tipo
     * @param tamanho
     * @param subtipos
     * @param dados_de_vida
     * @param pv
     * @param deslocamento
     * @param escalada
     * @param natacao
     * @param ataque_base
     * @param corpo
     * @param distancia
     * @param total_corpo
     * @param total_distancia
     * @param espaco
     * @param alcance
     * @param ataques_especiais
     * @param qualidades_especiais
     * @param tendencia
     * @param habilidades
     * @param talents
     * @param peric
     */
    public Criatura ( String nome, int nivel, double nd, String tipo, String tamanho, String subtipos,
                      String dados_de_vida, int pv, String deslocamento,
                      String escalada, String natacao,
                      int ataque_base, String corpo, String distancia,
                      String total_corpo, String total_distancia, String espaco,
                      String alcance, String ataques_especiais,
                      String qualidades_especiais, String tendencia,
                      Habilidades habilidades,
                      Talento[] talents, Pericia[] peric){

        this.nome = nome;
        nivel_efetivo = nivel;
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



        //---Habilidades---//
        this.habilidades = habilidades;

        //-Habilidades Automáticos-//
        calcula_armadura();
        calcula_iniciativa();
        calcula_resistencias();
        calcula_agarrar();
        //-----------------------//

        //Instanciando e atribuindo os valores ao String talentos
        talentos = new Talento[talents.length];

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

        ca = 10 + habilidades.getmDes() + armadura + armadura_natural + outros_armadura + outros_destreza;
        toque = 10 + habilidades.getmDes() + outros_destreza;
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

        fortitude = base_fortitude + habilidades.getmFor() + outros_f;
        reflexos = base_reflexos + habilidades.getmDes() + outros_r;
        vontade = base_vontade + habilidades.getmSab() + outros_v;
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

        iniciativa = habilidades.gethDes() + somatoria_outros;
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

        agarrar = ataque_base + habilidades.getmFor() + modificador_tamanho + somatorio_outros;
    }


    /** Atualizador de Dados e Habilidades:
     *    Descrição:
     *      Esse método atualiza todos os dados que envolvem um cálculo especifico
     *      para gerar um atributo (como, por exemplo, a CA = 10 + ...). O objetivo
     *      de sua existência consiste na necessidade de atualizar os dados para
     *      caso haja uma mudança ou edição na criatura.
     *
     *    Observação Importante:
     *      Deve ser chamado toda vez que for feita alguma alteração nos
     *      habilidades e nos "outros" modificadores que contribuem com os
     *      mesmos.
     *
     */
    protected void atualiza_dados(){
        calcula_armadura();
        calcula_resistencias();
        calcula_iniciativa();
        calcula_agarrar();
    }


    /** Instanciador do Número Total de Talentos
     *    Descvrição:
     *      Recebe o nível efetivo do personagem como parâmetro e através dele instancia o
     *      array de Talento com o número de índices que ele terá.
     *
     *      NOTA: Ainda está incompleto
     * @param nivel_efetivo
     */
    public void numero_de_talentos(int nivel_efetivo){
        int numero = 0;

        if(nivel_efetivo == 1);
    }

   /*----------------------------\\----------------------//-----------------------------*/


    /*----------------------------| Outros Modificadores |----------------------------*/

    //-----------------| Modificadores de Armadura |----------------------//
    public void set_outros_modificadores_armadura(int[] modificadores){
        if (modificadores.length == outros_modificadores_armadura.length) {
            for (int i = 0; i < modificadores.length; i++) {
                outros_modificadores_armadura[i] = modificadores[i];
            }

            atualiza_dados();
        }
    }

    public void set_outros_modificadores_armadura_destreza(int[] modificadores){
        if (modificadores.length == outros_modificadores_armadura_destreza.length) {
            for (int i = 0; i < modificadores.length; i++) {
                outros_modificadores_armadura_destreza[i] = modificadores[i];
            }

            atualiza_dados();
        }
    }
    //--------------------|--------------------------|--------------------//

    //--------------| Modificadores dos Testes de Resistência |-------------------//
    public void set_outros_fortitude(int[] outros){
        if (outros.length == outros_fortitude.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_fortitude[i] = outros[i];
            }

            atualiza_dados();
        }
    }

    public void set_base_fortitude(int base_fortitude){
        this.base_fortitude = base_fortitude;

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

    public void set_base_reflexos(int base_reflexos){
        this.base_reflexos = base_reflexos;

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

    public void set_base_vontade(int base_vontade){
        this.base_vontade = base_vontade;

        atualiza_dados();
    }
    //-----------------|---------------------------------------|------------------//

    //--------------| Outros Mod. de Iniciativa |-------------------//
    public void set_outros_iniciativa(int[] outros){
        if (outros.length == outros_iniciativa.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_iniciativa[i] = outros[i];
            }

            atualiza_dados();
        }
    }
    //--------------|----------------------------|------------------//

    //--------------| Outros Mod. de Agarrar |-------------------//
    public void set_outros_agarrar(int[] outros){
        if (outros.length == outros_agarrar.length) {
            for (int i = 0; i < outros.length; i++) {
                outros_agarrar[i] = outros[i];
            }

            atualiza_dados();
        }
    }
    //---------------|------------------------|------------------//

    //--------------| Mod. de Armadura |-------------------//
    public void set_armadura(int armadura){
        this.armadura = armadura;

        atualiza_dados();
    }

    public void set_armadura_natural(int armadura_natural){
        this.armadura_natural = armadura_natural;

        atualiza_dados();
    }
    //---------------|------------------|------------------//

    //----------------------------------| Outros |---------------------------------//
    public void set_nd(double nd) {
        this.nd = nd;
    }

    public void set_pv(int pv) {
        this.pv = pv;
    }

    public void set_dados_de_vida(String dados_de_vida) {
        this.dados_de_vida = dados_de_vida;
    }



    public void set_deslocamento(String deslocamento) {
        this.deslocamento = deslocamento;
    }

    public void set_escalada(String escalada) {
        this.escalada = escalada;
    }

    public void set_natacao(String natacao) {
        this.natacao = natacao;
    }



    public void set_nivel_efetivo(int nivel_efetivo) {
        this.nivel_efetivo = nivel_efetivo;
    }



    public void set_fortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    public void set_reflexos(int reflexos) {
        this.reflexos = reflexos;
    }

    public void set_vontade(int vontade) {
        this.vontade = vontade;
    }



    public void set_ataque_base(int ataque_base) {
        this.ataque_base = ataque_base;

        calcula_agarrar();
    }

    public void set_agarrar(int agarrar) {
        this.agarrar = agarrar;
    }

    public void set_iniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }


    public void set_ca(int ca) {
        this.ca = ca;
    }

    public void set_toque(int toque) {
        this.toque = toque;
    }

    public void set_surpresa(int surpresa) {
        this.surpresa = surpresa;
    }


    public void set_corpo(String corpo) {
        this.corpo = corpo;
    }

    public void set_distancia(String distancia) {
        this.distancia = distancia;
    }

    public void set_total_corpo(String total_corpo) {
        this.total_corpo = total_corpo;
    }

    public void set_total_distancia(String total_distancia) {
        this.total_distancia = total_distancia;
    }



    public void set_espaco(String espaco) {
        this.espaco = espaco;
    }

    public void set_alcance(String alcance) {
        this.alcance = alcance;
    }

    public void set_tamanho(String tamanho) {
        this.tamanho = tamanho;
    }


    public void set_nome(String nome) {
        this.nome = nome;
    }

    public void set_tipo(String tipo) {
        this.tipo = tipo;
    }

    public void set_subtipos(String subtipos) {
        this.subtipos = subtipos;
    }

    public void set_tendencia(String tendencia) {
        this.tendencia = tendencia;
    }


    public void set_qualidades_especiais(String qualidades_especiais) {
        this.qualidades_especiais = qualidades_especiais;
    }

    public void set_ataques_especiais(String ataques_especiais) {
        this.ataques_especiais = ataques_especiais;
    }


    public void set_armas(String[] armas) {
        this.armas = armas;
    }

    public void set_armadura_equipamento(String armadura_equipamento) {
        this.armadura_equipamento = armadura_equipamento;
    }

    public void set_outros_equipamentos(String[] outros_equips) {
        outros_equipamentos =  new String[outros_equips.length];

        for(int i = 0; i < outros_equipamentos.length; i++){
            outros_equipamentos[i] = outros_equips[i];
        }
    }



    public void set_talentos(Talento[] talents) {
        talentos = new Talento[talents.length];

        for(int i = 0; i < talentos.length; i++){
            talentos[i] = talents[i];
        }
    }

    public void set_pericias(Pericia[] peric) {
        pericias = new Pericia[peric.length];

        for(int i = 0; i < pericias.length; i++){
            pericias[i] = peric[i];
        }
    }
    //----------------------------------|--------|---------------------------------//

    /*-----------------------------\\--------------------//------------------------------*/


    /*-----------------------------// Métodos de Leitura e Escrita \\------------------------------*/


    public double get_nd() {
        return nd;
    }

    public int get_pv() {
        return pv;
    }

    public String get_dados_de_vida() {
        return dados_de_vida;
    }



    public String get_deslocamento() {
        return deslocamento;
    }

    public String get_escalada() {
        return escalada;
    }

    public String get_natacao() {
        return natacao;
    }



    public int get_nivel_efetivo() {
        return nivel_efetivo;
    }



    public int get_fortitude() {
        return fortitude;
    }

    public int get_reflexos() {
        return reflexos;
    }

    public int get_vontade() {
        return vontade;
    }

    public int get_base_fortitude() {
        return base_fortitude;
    }

    public int[] get_outros_fortitude() {
        return outros_fortitude;
    }

    public int get_base_reflexos() {
        return base_reflexos;
    }

    public int[] get_outros_reflexos() {
        return outros_reflexos;
    }

    public int get_base_vontade() {
        return base_vontade;
    }

    public int[] get_outros_vontade() {
        return outros_vontade;
    }




    public int get_ataque_base() {
        return ataque_base;
    }

    public int get_agarrar() {
        return agarrar;
    }

    public int get_iniciativa() {
        return iniciativa;
    }

    public int[] get_outros_iniciativa() {
        return outros_iniciativa;
    }

    public int[] get_outros_agarrar() {
        return outros_agarrar;
    }


    public int get_ca() {
        return ca;
    }

    public int get_toque() {
        return toque;
    }

    public int get_surpresa() {
        return surpresa;
    }


    public String get_corpo() {
        return corpo;
    }

    public String get_distancia() {
        return distancia;
    }

    public String get_total_corpo() {
        return total_corpo;
    }

    public String get_total_distancia() {
        return total_distancia;
    }



    public String get_espaco() {
        return espaco;
    }

    public String get_alcance() {
        return alcance;
    }

    public String get_tamanho() {
        return tamanho;
    }



    public String get_nome() {
        return nome;
    }

    public String get_tipo() {
        return tipo;
    }

    public String get_subtipos() {
        return subtipos;
    }

    public String get_tendencia() {
        return tendencia;
    }


    public String get_qualidades_especiais() {
        return qualidades_especiais;
    }

    public String get_ataques_especiais() {
        return ataques_especiais;
    }



    public int get_armadura() {
        return armadura;
    }

    public int get_armadura_natural() {
        return armadura_natural;
    }

    public int[] get_outros_modificadores_armadura() {
        return outros_modificadores_armadura;
    }

    public int[] get_outros_modificadores_armadura_destreza() {
        return outros_modificadores_armadura_destreza;
    }


    public String[] get_armas() {
        return armas;
    }

    public String get_armadura_equipamento() {
        return armadura_equipamento;
    }

    public String[] get_outros_equipamentos() {
        return outros_equipamentos;
    }



    public Talento[] get_talentos() {
        return talentos;
    }

    public Pericia[] get_pericias() {
        return pericias;
    }




    public String[] get_Moedas() {
        return moedas;
    }

    public void set_Moedas(String[] moedas) {
        this.moedas = moedas;
    }

    public String[] get_Gemas() {
        return gemas;
    }

    public void set_Gemas(String[] gemas) {
        this.gemas = gemas;
    }

    public String[] get_Obras_arte() {
        return obras_arte;
    }

    public void set_Obras_arte(String[] obras_arte) {
        this.obras_arte = obras_arte;
    }

   /*-----------------------------\\--------------------//------------------------------*/
}

