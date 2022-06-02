package desenvolv.mastersys.appviajem.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import desenvolv.mastersys.appviajem.database.DBOpenHelper;
import desenvolv.mastersys.appviajem.database.model.UsuarioModel;

public class UsuarioDAO extends AbstractDAO{

    private final String[]
            colunas = {
            UsuarioModel.COLUNA_ID,
            UsuarioModel.COLUNA_USUARIO,
            UsuarioModel.COLUNA_SENHA
    };


    public UsuarioDAO(final Context contexto){

        helper = new DBOpenHelper(contexto);
    }

    /**
     * Faz o Insert no banco de dados.
     * @param model
     * @return
     */
    public long Insert(UsuarioModel model){

        long linhasAfetadas;

        try {
            Open();

            //HashMap
            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_USUARIO, model.getUsuario());
            values.put(UsuarioModel.COLUNA_SENHA, model.getSenha());

            //Insert
            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME, null, values);

        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    /**
     * Deleta um usuário do banco de dados.
     * @param usuario
     */
    public void Delete(final String usuario){

        Open();
        db.delete(UsuarioModel.TABELA_NOME, UsuarioModel.COLUNA_USUARIO + " = ?", new String[]{usuario});
        Close();
    }


    public int Update(final String usuario, final String senha){

        int linhasAfetadas = 0;

        try {
            Open();

            //HashMap
            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_SENHA, senha);

            linhasAfetadas = db.update(UsuarioModel.TABELA_NOME, values, UsuarioModel.COLUNA_USUARIO + " = ?", new String[]{usuario});

        }
        finally {
            Close();
        }
        return linhasAfetadas;
    }


    /**
     * Executa o SELECT buscando pelo usuário e senha.
     * @param usuario
     * @param senha
     * @return
     */
    public UsuarioModel Select(final String usuario, final String senha){

        UsuarioModel model = null;

        try {
            Open();
            //Select * from tb_usuario where usuario = ? and senha = ?
            Cursor cursor = db.query(UsuarioModel.TABELA_NOME, colunas, UsuarioModel.COLUNA_USUARIO + " = ? and "+UsuarioModel.COLUNA_SENHA+" = ?", new String[]{usuario, senha}, null, null, null);
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                model = cursorToStructor(cursor);
                break;
            }
        }
        finally {
            Close();
        }

        return model;
    }

    public List<UsuarioModel> Select(){

        List<UsuarioModel> lista = new ArrayList<UsuarioModel>();

        try {
            Open();

            //Query retorna um objeto tipo cursor.
            Cursor cursor = db.query(UsuarioModel.TABELA_NOME, colunas, null, null, null,  null, null);
            cursor.moveToFirst();

            //Enquanto o cursor não chegar no fim...
            while (!cursor.isAfterLast()){
                lista.add(cursorToStructor(cursor));
                cursor.moveToNext();
            }
        }
        finally {
            Close();
        }

        return lista;
    }

    public final UsuarioModel cursorToStructor(Cursor cursor){
        UsuarioModel model = new UsuarioModel();
        model.setId(cursor.getInt(0));
        model.setUsuario(cursor.getString(1));
        model.setSenha(cursor.getString(2));

        return model;
    }
}
