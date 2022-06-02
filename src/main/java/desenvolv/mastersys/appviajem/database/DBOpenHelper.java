package desenvolv.mastersys.appviajem.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import desenvolv.mastersys.appviajem.database.model.UsuarioModel;
import desenvolv.mastersys.appviajem.database.model.ViajemModel;

public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String
            DATABASE_NOME = "bancoappviajem.db";

    public static final int

            /**
             * VERSÃO DO BANCO DE DADOS;
             * "MUDAR QUANDO TIVER ALTERAÇÃO NAS TABELAS DO BANCO".
             */
            DATABASE_VERSAO = 3;

    public DBOpenHelper(final Context contexto){
        super(contexto, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Qual SQL você quer executar no banco de dados quando ele ja estiver aberto?
        db.execSQL(UsuarioModel.CREATE_TABLE);
        db.execSQL(ViajemModel.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
