package desenvolv.mastersys.appviajem.database.model;

public class ViajemModel {

    public static final String
            TABELA_NOME = "tb_viajem";

    public static final String
            //Todas as tabelas do banco de dados obrigatóriamente tem que ter uma coluna chamada _id.
            COLUNA_ID = "_id",
            COLUNA_NOME = "nome",
            COLUNA_NUMERO_VIAJANTES = "numero",
            COLUNA_DURACAO_VIAJEM = "duracao",
            COLUNA_CUSTO_REFEICAO = "refeicao",
            COLUNA_QUANT_REFEICAO = "quant_refeicao",
            COLUNA_CUSTO_HOTEL = "custo_hotel",
            COLUNA_QUANT_NOITES = "quant_noites_hotel",
            COLUNA_QUARTOS = "quant_quartos",
            COLUNA_KM_RODADO = "km",
            COLUNA_MEDIA_KML = "kml",
            COLUNA_VALOR_L = "valor_l",
            COLUNA_QUANT_VEIC_USADOS = "veiculo",
            COLUNA_CUSTO_PASSAGEM = "custo_passagem",
            COLUNA_CUSTO_ALUGUEL_VEIC = "aluguel",
            COLUNA_DESC_ENTRETENIMENT0_ONE = "descricao_one",
            COLUNA_CUSTO_ENTRETENIMENTO_1 = "entretenimento_um",
            COLUNA_DESC_ENTRETENIMENT0_two = "descricao_two",
            COLUNA_CUSTO_ENTRETENIMENTO_2 = "entretenimento_dois",
            COLUNA_DESC_ENTRETENIMENT0_tree = "descricao_tree",
            COLUNA_CUSTO_ENTRETENIMENTO_3 = "entretenimento_tres",
            COLUNA_CUSTO_TOTAL_GASOLINA = "custo_total_gasolina",
            COLUNA_CUSTO_TOTAL_TAR_AEREA = "custo_total_tar_aerea",
            COLUNA_CUSTO_TOTAL_REFEICOES = "custo_total_refeicoes",
            COLUNA_CUSTO_TOTAL_HOSPEDAGEM = "custo_total_hospedagem",
            COLUNA_CUSTO_TOTAL_DIVERSOS = "custo_total_diversos",
            COLUNA_CUSTO_TOTAL_VIAJEM = "custo_total_viajem",
            COLUNA_ID_USUARIO = "idusuario";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA_NOME
                    +"("
                    +   COLUNA_ID + " integer primary key autoincrement, "
                    +   COLUNA_NOME + " text not null, "
                    +   COLUNA_NUMERO_VIAJANTES + " integer not null, "
                    +   COLUNA_DURACAO_VIAJEM + " integer not null, "
                    +   COLUNA_CUSTO_REFEICAO + " double, "
                    +   COLUNA_QUANT_REFEICAO + " integer, "
                    +   COLUNA_CUSTO_HOTEL + " double, "
                    +   COLUNA_QUANT_NOITES + " integer, "
                    +   COLUNA_QUARTOS + " integer, "
                    +   COLUNA_KM_RODADO + " double, "
                    +   COLUNA_MEDIA_KML + " double, "
                    +   COLUNA_VALOR_L + " double, "
                    +   COLUNA_QUANT_VEIC_USADOS + " integer, "
                    +   COLUNA_CUSTO_PASSAGEM + " double, "
                    +   COLUNA_CUSTO_ALUGUEL_VEIC + " double, "
                    +   COLUNA_DESC_ENTRETENIMENT0_ONE + " text, "
                    +   COLUNA_CUSTO_ENTRETENIMENTO_1 + " double, "
                    +   COLUNA_DESC_ENTRETENIMENT0_two + " text, "
                    +   COLUNA_CUSTO_ENTRETENIMENTO_2 + " double, "
                    +   COLUNA_DESC_ENTRETENIMENT0_tree + " text, "
                    +   COLUNA_CUSTO_ENTRETENIMENTO_3 + " double, "
                    +   COLUNA_CUSTO_TOTAL_GASOLINA + " double, "
                    +   COLUNA_CUSTO_TOTAL_TAR_AEREA + " double, "
                    +   COLUNA_CUSTO_TOTAL_REFEICOES + " double, "
                    +   COLUNA_CUSTO_TOTAL_HOSPEDAGEM + " double, "
                    +   COLUNA_CUSTO_TOTAL_DIVERSOS + " double, "
                    +   COLUNA_CUSTO_TOTAL_VIAJEM + " double, "
                    +   COLUNA_ID_USUARIO + " integer "
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA_NOME;

    /***************************************************
     ATRIBUTOS DE MANIPULAÇÃO DO USUARIO
     **************************************************/

    private long id;

    private String nome, descEntretenimentoOne, descEntretenimentoTwo, descEntretenimentoTree;

    private Integer
            numero_viajantes,
            duracao_viajem,
            quant_refeicao,
            quant_noites,
            quant_quartos,
            quant_veic_usados,
            idusuario;

    private Double
            custo_refeicao,
            custo_hotel, km_rodado,
            media_km_rodado,
            valor_l,
            custo_passagem,
            custo_aluguel_veic,
            custo_entretenimento_um,
            custo_entretenimento_dois,
            custo_entretenimento_tres,
            custo_total_gasolina,
            custo_total_tar_aerea,
            custo_total_refeicoes,
            custo_total_hospedagem,
            custo_total_diversos,
            custo_total_viajem;

    /***************************************************
     GETTER AND SETTER METHODS
     **************************************************/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero_viajantes() {
        return numero_viajantes;
    }

    public void setNumero_viajantes(Integer numero_viajantes) {
        this.numero_viajantes = numero_viajantes;
    }

    public int getDuracao_viajem() {
        return duracao_viajem;
    }

    public void setDuracao_viajem(Integer duracao_viajem) {
        this.duracao_viajem = duracao_viajem;
    }

    public int getQuant_refeicao() {
        return quant_refeicao;
    }

    public void setQuant_refeicao(Integer quant_refeicao) {
        this.quant_refeicao = quant_refeicao;
    }

    public int getQuant_noites() {
        return quant_noites;
    }

    public void setQuant_noites(Integer quant_noites) {
        this.quant_noites = quant_noites;
    }

    public int getQuant_quartos() {
        return quant_quartos;
    }

    public void setQuant_quartos(Integer quant_quartos) {
        this.quant_quartos = quant_quartos;
    }

    public int getQuant_veic_usados() {
        return quant_veic_usados;
    }

    public void setQuant_veic_usados(Integer quant_veic_usados) {
        this.quant_veic_usados = quant_veic_usados;
    }

    public double getCusto_refeicao() {
        return custo_refeicao;
    }

    public void setCusto_refeicao(Double custo_refeicao) {
        this.custo_refeicao = custo_refeicao;
    }

    public double getCusto_hotel() {
        return custo_hotel;
    }

    public void setCusto_hotel(Double custo_hotel) {
        this.custo_hotel = custo_hotel;
    }

    public double getKm_rodado() {
        return km_rodado;
    }

    public void setKm_rodado(Double km_rodado) {
        this.km_rodado = km_rodado;
    }

    public double getMedia_km_rodado() {
        return media_km_rodado;
    }

    public void setMedia_km_rodado(Double media_km_rodado) {
        this.media_km_rodado = media_km_rodado;
    }

    public double getValor_l() {
        return valor_l;
    }

    public void setValor_l(Double valor_l) {
        this.valor_l = valor_l;
    }

    public double getCusto_passagem() {
        return custo_passagem;
    }

    public void setCusto_passagem(Double custo_passagem) {
        this.custo_passagem = custo_passagem;
    }

    public double getCusto_aluguel_veic() {
        return custo_aluguel_veic;
    }

    public void setCusto_aluguel_veic(Double custo_aluguel_veic) {
        this.custo_aluguel_veic = custo_aluguel_veic;
    }

    public double getCusto_entretenimento_um() {
        return custo_entretenimento_um;
    }

    public void setCusto_entretenimento_um(Double custo_entretenimento_um) {
        this.custo_entretenimento_um = custo_entretenimento_um;
    }

    public double getCusto_entretenimento_dois() {
        return custo_entretenimento_dois;
    }

    public void setCusto_entretenimento_dois(Double custo_entretenimento_dois) {
        this.custo_entretenimento_dois = custo_entretenimento_dois;
    }

    public double getCusto_entretenimento_tres() {
        return custo_entretenimento_tres;
    }

    public void setCusto_entretenimento_tres(Double custo_entretenimento_tres) {
        this.custo_entretenimento_tres = custo_entretenimento_tres;
    }

    public double getCusto_total_gasolina() {
        return custo_total_gasolina;
    }

    public void setCusto_total_gasolina(Double custo_total_gasolina) {
        this.custo_total_gasolina = custo_total_gasolina;
    }

    public double getCusto_total_tar_aerea() {
        return custo_total_tar_aerea;
    }

    public void setCusto_total_tar_aerea(Double custo_total_tar_aerea) {
        this.custo_total_tar_aerea = custo_total_tar_aerea;
    }

    public double getCusto_total_refeicoes() {
        return custo_total_refeicoes;
    }

    public void setCusto_total_refeicoes(Double custo_total_refeicoes) {
        this.custo_total_refeicoes = custo_total_refeicoes;
    }

    public double getCusto_total_hospedagem() {
        return custo_total_hospedagem;
    }

    public void setCusto_total_hospedagem(Double custo_total_hospedagem) {
        this.custo_total_hospedagem = custo_total_hospedagem;
    }

    public double getCusto_total_diversos() {
        return custo_total_diversos;
    }

    public void setCusto_total_diversos(Double custo_total_diversos) {
        this.custo_total_diversos = custo_total_diversos;
    }

    public double getCusto_total_viajem() {
        return custo_total_viajem;
    }

    public void setCusto_total_viajem(Double custo_total_viajem) {
        this.custo_total_viajem = custo_total_viajem;
    }

    public String getDescEntretenimentoOne() {
        return descEntretenimentoOne;
    }

    public void setDescEntretenimentoOne(String descEntretenimentoOne) {
        this.descEntretenimentoOne = descEntretenimentoOne;
    }

    public String getDescEntretenimentoTwo() {
        return descEntretenimentoTwo;
    }

    public void setDescEntretenimentoTwo(String descEntretenimentoTwo) {
        this.descEntretenimentoTwo = descEntretenimentoTwo;
    }

    public String getDescEntretenimentoTree() {
        return descEntretenimentoTree;
    }

    public void setDescEntretenimentoTree(String descEntretenimentoTree) {
        this.descEntretenimentoTree = descEntretenimentoTree;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
}
