package desenvolv.mastersys.appviajem.database.dao;

import android.database.sqlite.SQLiteDatabase;

import desenvolv.mastersys.appviajem.database.DBOpenHelper;

public abstract class AbstractDAO {

    protected SQLiteDatabase db;
    protected DBOpenHelper helper;

    protected final void Open(){
        //Cria ou abre um banco de dados que pode ser usado para leitura ou escrita.
        db = helper.getWritableDatabase();
    }

    protected final void Close(){
        helper.close();
    }
}
