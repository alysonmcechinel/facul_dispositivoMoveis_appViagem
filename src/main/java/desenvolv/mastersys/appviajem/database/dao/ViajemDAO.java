package desenvolv.mastersys.appviajem.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import desenvolv.mastersys.appviajem.LoginActivity;
import desenvolv.mastersys.appviajem.database.DBOpenHelper;
import desenvolv.mastersys.appviajem.database.model.UsuarioModel;
import desenvolv.mastersys.appviajem.database.model.ViajemModel;
import desenvolv.mastersys.appviajem.util.Shared;

public class ViajemDAO extends AbstractDAO{

    private final String[]
            colunas = {
            ViajemModel.COLUNA_ID,
            ViajemModel.COLUNA_NOME,
            ViajemModel.COLUNA_NUMERO_VIAJANTES,
            ViajemModel.COLUNA_DURACAO_VIAJEM,
            ViajemModel.COLUNA_CUSTO_REFEICAO,
            ViajemModel.COLUNA_QUANT_REFEICAO,
            ViajemModel.COLUNA_CUSTO_HOTEL,
            ViajemModel.COLUNA_QUANT_NOITES,
            ViajemModel.COLUNA_QUARTOS,
            ViajemModel.COLUNA_KM_RODADO,
            ViajemModel.COLUNA_MEDIA_KML,
            ViajemModel.COLUNA_VALOR_L,
            ViajemModel.COLUNA_QUANT_VEIC_USADOS,
            ViajemModel.COLUNA_CUSTO_PASSAGEM,
            ViajemModel.COLUNA_CUSTO_ALUGUEL_VEIC,
            ViajemModel.COLUNA_CUSTO_ENTRETENIMENTO_1,
            ViajemModel.COLUNA_CUSTO_ENTRETENIMENTO_2,
            ViajemModel.COLUNA_CUSTO_ENTRETENIMENTO_3,
            ViajemModel.COLUNA_CUSTO_TOTAL_GASOLINA,
            ViajemModel.COLUNA_CUSTO_TOTAL_TAR_AEREA,
            ViajemModel.COLUNA_CUSTO_TOTAL_REFEICOES,
            ViajemModel.COLUNA_CUSTO_TOTAL_HOSPEDAGEM,
            ViajemModel.COLUNA_CUSTO_TOTAL_DIVERSOS,
            ViajemModel.COLUNA_CUSTO_TOTAL_VIAJEM,
            ViajemModel.COLUNA_ID_USUARIO
    };


    public ViajemDAO(final Context contexto){

        helper = new DBOpenHelper(contexto);
    }

    /**
     * Faz o Insert no banco de dados.
     * @param model
     * @return
     */

    public long Insert(ViajemModel model){

        long linhasAfetadas;

        try {
            Open();

            //HashMap
            ContentValues values = new ContentValues();

            values.put(ViajemModel.COLUNA_NOME, model.getNome());
            values.put(ViajemModel.COLUNA_NUMERO_VIAJANTES, model.getNumero_viajantes());
            values.put(ViajemModel.COLUNA_DURACAO_VIAJEM, model.getDuracao_viajem());
            values.put(ViajemModel.COLUNA_CUSTO_REFEICAO, model.getCusto_refeicao());
            values.put(ViajemModel.COLUNA_QUANT_REFEICAO, model.getQuant_refeicao());
            values.put(ViajemModel.COLUNA_CUSTO_HOTEL, model.getCusto_hotel());
            values.put(ViajemModel.COLUNA_QUANT_NOITES, model.getQuant_noites());
            values.put(ViajemModel.COLUNA_QUARTOS, model.getQuant_quartos());
            values.put(ViajemModel.COLUNA_KM_RODADO, model.getKm_rodado());
            values.put(ViajemModel.COLUNA_MEDIA_KML, model.getMedia_km_rodado());
            values.put(ViajemModel.COLUNA_VALOR_L, model.getValor_l());
            values.put(ViajemModel.COLUNA_QUANT_VEIC_USADOS, model.getQuant_veic_usados());
            values.put(ViajemModel.COLUNA_CUSTO_PASSAGEM, model.getCusto_passagem());
            values.put(ViajemModel.COLUNA_CUSTO_ALUGUEL_VEIC, model.getCusto_aluguel_veic());
            values.put(ViajemModel.COLUNA_CUSTO_ENTRETENIMENTO_1, model.getCusto_entretenimento_um());
            values.put(ViajemModel.COLUNA_CUSTO_ENTRETENIMENTO_2, model.getCusto_entretenimento_dois());
            values.put(ViajemModel.COLUNA_CUSTO_ENTRETENIMENTO_3, model.getCusto_entretenimento_tres());
            values.put(ViajemModel.COLUNA_CUSTO_TOTAL_GASOLINA, model.getCusto_total_gasolina());
            values.put(ViajemModel.COLUNA_CUSTO_TOTAL_TAR_AEREA, model.getCusto_total_tar_aerea());
            values.put(ViajemModel.COLUNA_CUSTO_TOTAL_REFEICOES, model.getCusto_total_refeicoes());
            values.put(ViajemModel.COLUNA_CUSTO_TOTAL_HOSPEDAGEM, model.getCusto_total_hospedagem());
            values.put(ViajemModel.COLUNA_CUSTO_TOTAL_DIVERSOS, model.getCusto_total_diversos());
            values.put(ViajemModel.COLUNA_CUSTO_TOTAL_VIAJEM, model.getCusto_total_viajem());
            values.put(ViajemModel.COLUNA_ID_USUARIO, model.getIdusuario());
            values.put(ViajemModel.COLUNA_DESC_ENTRETENIMENT0_ONE, model.getDescEntretenimentoOne());
            values.put(ViajemModel.COLUNA_DESC_ENTRETENIMENT0_two, model.getDescEntretenimentoTwo());
            values.put(ViajemModel.COLUNA_DESC_ENTRETENIMENT0_tree, model.getDescEntretenimentoTree());

            //Insert
            linhasAfetadas = db.insert(ViajemModel.TABELA_NOME, null, values);

        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }


    // Selecionar tudo do usuário em questão
    public List<ViajemModel> SelectAllByUser(Integer usuarioId) {
        List<ViajemModel> list = new ArrayList<ViajemModel>();

        try {
            Open();
            String query = "SELECT * FROM " + ViajemModel.TABELA_NOME + " WHERE " + ViajemModel.COLUNA_ID_USUARIO + " = " + usuarioId + " ORDER BY " + ViajemModel.COLUNA_ID + " ASC";
            Cursor cursor = db.rawQuery(query, null);
            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                list.add(cursorToStructor(cursor));
                cursor.moveToNext();
            }
        }
        finally {
            Close();
        }

        return list;
    }

    //Select One
    public ViajemModel SelectOne(Integer usuarioId ){

        ViajemModel model;

        try {
            Open();

            String query = "SELECT * FROM " + ViajemModel.TABELA_NOME + " WHERE " + ViajemModel.COLUNA_ID_USUARIO + " = " + usuarioId + " ORDER BY " + ViajemModel.COLUNA_ID + " DESC LIMIT 1";
            Cursor cursor = db.rawQuery(query, null);
            cursor.moveToFirst();

            model = cursorToStructor(cursor);
        }
        finally {
            Close();
        }

        return model;
    }

    public final ViajemModel cursorToStructor(Cursor cursor){

        ViajemModel model = new ViajemModel();
        model.setId(cursor.getLong(0));
        model.setNome(cursor.getString(1));
        model.setNumero_viajantes(cursor.getInt(2));
        model.setDuracao_viajem(cursor.getInt(3));
        model.setCusto_refeicao(cursor.getDouble(4));
        model.setQuant_refeicao(cursor.getInt(5));
        model.setCusto_hotel(cursor.getDouble(6));
        model.setQuant_noites(cursor.getInt(7));
        model.setQuant_quartos(cursor.getInt(8));
        model.setKm_rodado(cursor.getDouble(9));
        model.setMedia_km_rodado(cursor.getDouble(10));
        model.setValor_l(cursor.getDouble(11));
        model.setQuant_veic_usados(cursor.getInt(12));
        model.setCusto_passagem(cursor.getDouble(13));
        model.setCusto_aluguel_veic(cursor.getDouble(14));
        model.setDescEntretenimentoOne(cursor.getString(15));
        model.setCusto_entretenimento_um(cursor.getDouble(16));
        model.setDescEntretenimentoTwo(cursor.getString(17));
        model.setCusto_entretenimento_dois(cursor.getDouble(18));
        model.setDescEntretenimentoTree(cursor.getString(19));
        model.setCusto_entretenimento_tres(cursor.getDouble(20));
        model.setCusto_total_gasolina(cursor.getDouble(21));
        model.setCusto_total_tar_aerea(cursor.getDouble(22));
        model.setCusto_total_refeicoes(cursor.getDouble(23));
        model.setCusto_total_hospedagem(cursor.getDouble(24));
        model.setCusto_total_diversos(cursor.getDouble(25));
        model.setCusto_total_viajem(cursor.getDouble(26));
        model.setIdusuario(cursor.getInt(27));

        return model;
    }
}
