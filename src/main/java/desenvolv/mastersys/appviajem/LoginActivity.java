package desenvolv.mastersys.appviajem;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolv.mastersys.appviajem.database.dao.UsuarioDAO;
import desenvolv.mastersys.appviajem.database.model.UsuarioModel;
import desenvolv.mastersys.appviajem.util.Shared;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario, edtSenha;
    private ImageView imgCores;
    private Button btnEntrar, btnGravar, btnAtualizar, btnDeletar;
    private UsuarioDAO dao;
    private Shared shared;
    private LinearLayout linearCor;
    private LinearLayout linearCor2;
    private LinearLayout linearCor3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Seta o xml.
        setContentView(R.layout.activity_1_login);

        //Instância o shared.
        shared = new Shared(LoginActivity.this);

        //Instância o banco de dados.
        dao = new UsuarioDAO(LoginActivity.this);

        //Instância os componentes do xml.
        linearCor = findViewById(R.id.linearCor);
        linearCor2 = findViewById(R.id.linearCor2);
        linearCor3 = findViewById(R.id.linearCor3);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);

        imgCores = findViewById(R.id.imgCores);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnGravar = findViewById(R.id.btnGravar);
        btnAtualizar = findViewById(R.id.btnAtualizar);
        btnDeletar = findViewById(R.id.btnDeletar);

        //Ação do botão Cores
        imgCores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable background = linearCor.getBackground();

                if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.white)) {
                    linearCor.setBackgroundColor(getResources().getColor(R.color.laranja));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.laranja));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.laranja));

                } else if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.laranja)){
                    linearCor.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.vermelho));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.vermelho));
                }
                else if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.vermelho)){
                    linearCor.setBackgroundColor(getResources().getColor(R.color.roxo));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.roxo));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.roxo));
                }
                else if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.roxo)){
                    linearCor.setBackgroundColor(getResources().getColor(R.color.azul));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.azul));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.azul));
                }
                else if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.azul)){
                    linearCor.setBackgroundColor(getResources().getColor(R.color.azulFraco));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.azulFraco));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.azulFraco));
                }
                else if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.azulFraco)){
                    linearCor.setBackgroundColor(getResources().getColor(R.color.verde));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.verde));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.verde));
                }
                else if (((ColorDrawable) background).getColor() == getResources().getColor(R.color.verde)){
                    linearCor.setBackgroundColor(getResources().getColor(R.color.amarelo));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.amarelo));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.amarelo));
                }
                else
                    linearCor.setBackgroundColor(getResources().getColor(R.color.white));
                    linearCor2.setBackgroundColor(getResources().getColor(R.color.white));
                    linearCor3.setBackgroundColor(getResources().getColor(R.color.white));


                shared.put(Shared.KEY_COR_LINEAR, ((ColorDrawable) background).getColor());
            }
        });

        //Verifica a última cor pelo Shared Preferences.
        if (shared.getInt(shared.KEY_COR_LINEAR) != 0){
            linearCor.setBackgroundColor(shared.getInt(Shared.KEY_COR_LINEAR));
            linearCor2.setBackgroundColor(shared.getInt(Shared.KEY_COR_LINEAR));
            linearCor3.setBackgroundColor(shared.getInt(Shared.KEY_COR_LINEAR));
        }

        //Ação do botão Entrar
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* List<UsuarioModel> model = dao.Select();
                for(UsuarioModel usuario : model){
                    System.out.println("**************** >>>>>>>>>>> "+usuario.getUsuario());
                }*/

                UsuarioModel model = dao.Select(edtUsuario.getText().toString(), edtSenha.getText().toString());

                if(model != null){
                    shared.put(shared.KEY_USUARIO_LOGADO, model.getId());
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_LONG).show();

                    //Vai para a próxima activity.
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                }else{
                    //Apresenta mensagem de erro.
                    Toast.makeText(LoginActivity.this, "Usuário Não Encontrado!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Ação do botão Gravar
        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Quando clicar em gravar, vou criar um usuário Model
                UsuarioModel model = new UsuarioModel();

                model.setUsuario(edtUsuario.getText().toString());
                model.setSenha(edtSenha.getText().toString());

                //Faz o insert.
                if (dao.Insert(model) != -1){
                    Toast.makeText(LoginActivity.this, "Usuário Inserido!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Ação do botão Atualizar
        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao.Update(edtUsuario.getText().toString(), edtSenha.getText().toString()) >0){
                    Toast.makeText(LoginActivity.this, "Usuário Atualizado!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Falha Na Atualização!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Ação do botão Deletar
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.Delete(edtUsuario.getText().toString());
                Toast.makeText(LoginActivity.this, "Usuário Deletado!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
