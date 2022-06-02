package desenvolv.mastersys.appviajem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import desenvolv.mastersys.appviajem.database.dao.ViajemDAO;
import desenvolv.mastersys.appviajem.database.model.ViajemModel;
import desenvolv.mastersys.appviajem.util.Shared;

public class RelatorioActivity extends AppCompatActivity {


    private EditText
    edtCustoTotalPorPessoa,
    edtCustoTotalViagem,
    edtDuracaoViajem,
    edtTotalDeViajantes;

    private Button btnVoltar;

    private ViajemDAO viajemDAO;

    private Shared shared;
    private LinearLayout linearCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Seta o xml.
        setContentView(R.layout.activity_4_relatorio);
        shared = new Shared(RelatorioActivity.this);

        viajemDAO = new ViajemDAO(RelatorioActivity.this);

        ViajemModel model = viajemDAO.SelectOne(shared.getInt(shared.KEY_USUARIO_LOGADO));

        edtCustoTotalPorPessoa = findViewById(R.id.txtCustoTotalPorPessoa);
        edtCustoTotalViagem = findViewById(R.id.txtCustoTotalViagem);
        edtDuracaoViajem = findViewById(R.id.txtDuracaoViagem);
        edtTotalDeViajantes = findViewById(R.id.txtTotalViajantes);

        btnVoltar = findViewById(R.id.btnRetornar);

        edtCustoTotalPorPessoa.setText(Double.toString(model.getCusto_total_viajem() / model.getNumero_viajantes()));
        edtCustoTotalViagem.setText(Double.toString(model.getCusto_total_viajem()));
        edtDuracaoViajem.setText(Double.toString(model.getDuracao_viajem()));
        edtTotalDeViajantes.setText(Integer.toString(model.getNumero_viajantes()));

        linearCor = findViewById(R.id.linearCor);
        linearCor.setBackgroundColor(shared.getInt(Shared.KEY_COR_LINEAR));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RelatorioActivity.this, MainActivity.class));
            }
        });
    }
}
