package desenvolv.mastersys.appviajem;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolv.mastersys.appviajem.database.dao.ViajemDAO;
import desenvolv.mastersys.appviajem.database.model.ViajemModel;
import desenvolv.mastersys.appviajem.util.Shared;

public class InformacoesActivity extends AppCompatActivity {

    private LinearLayout linearCor;
    private Shared shared;

    private EditText
            edtNameTrip,
            edtNumerTrav,
            edtDaysTrip,
            edtCustoRefeicao,
            edtQuantRefei,
            edtCustoMedioNoite,
            edtQuantNoites,
            edtQuantQuartos,
            edtKm,
            edtMediaKmL,
            edtCustoL,
            edtQuantVeic,
            edtValorPassagemPessoa,
            edtAluguelVeic,
            edtDescOutrosOne,
            edtCustoOutrosOne,
            edtDescOutrosTwo,
            edtCustoOutrosTwo,
            edtDescOutrosTree,
            edtCustoOutrosTree;

    private ViajemDAO
            dao;

    private Button
            btnFinalizar,
            btnVoltar;

    private Double
            TotalGasolina,
            TotalTarAerea,
            TotalRefeic,
            TotalHospedagem,
            TotalDiversos,
            TotalDespesasViajem;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shared = new Shared(InformacoesActivity.this);
        //Seta o xml.
        setContentView(R.layout.activity_3_informacoes);

        //Instância os componentes do xml.
        edtNameTrip = findViewById(R.id.txtNameTrip);
        edtNumerTrav = findViewById(R.id.txtQtdTravelers);
        edtDaysTrip = findViewById(R.id.txtDaysTrip);
        edtCustoRefeicao = findViewById(R.id.indicaCustRei);
        edtQuantRefei = findViewById(R.id.indicaQtdRei);
        edtCustoMedioNoite = findViewById(R.id.indicaCustoMedioN);
        edtQuantNoites = findViewById(R.id.indicaQtdnoites);
        edtQuantQuartos = findViewById(R.id.indicaQtdQuartos);
        edtKm = findViewById(R.id.indicaKm);
        edtMediaKmL = findViewById(R.id.indicaKml);
        edtCustoL = findViewById(R.id.indicaCustoL);
        edtQuantVeic = findViewById(R.id.indicaQtdVei);
        edtValorPassagemPessoa = findViewById(R.id.indicaPess);
        edtAluguelVeic = findViewById(R.id.indicaAluVei);
        edtDescOutrosOne = findViewById(R.id.indicaOutrosOne);
        edtCustoOutrosOne = findViewById(R.id.indicaCustOutrosOne);
        edtDescOutrosTwo = findViewById(R.id.indicaOutrosTwo);
        edtCustoOutrosTwo = findViewById(R.id.indicaCustOutrosTwo);
        edtDescOutrosTree = findViewById(R.id.indicaOutrosThree);
        edtCustoOutrosTree = findViewById(R.id.indicaCustOutrosThree);

        btnFinalizar = findViewById(R.id.btnFinaliza);
        btnVoltar = findViewById(R.id.btnBack);

        //seta background
        linearCor = findViewById(R.id.linearCor);
        linearCor.setBackgroundColor(shared.getInt(Shared.KEY_COR_LINEAR));
        
        //Instância o banco de dados.
        dao = new ViajemDAO(InformacoesActivity.this);

        //Ação do botão finalizar
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Quando clicar em finalizar, vou criar uma viajem Model.
                    ViajemModel model = new ViajemModel();

                    model.setNome(edtNameTrip.getText().toString());
                    model.setNumero_viajantes(getIntegerValueFromEditable(edtNumerTrav.getText()));
                    model.setDuracao_viajem(getIntegerValueFromEditable(edtDaysTrip.getText()));
                    model.setCusto_refeicao(getDobuleValueFromEditable(edtCustoRefeicao.getText()));
                    model.setQuant_refeicao(getIntegerValueFromEditable(edtQuantRefei.getText()));
                    model.setCusto_hotel(getDobuleValueFromEditable(edtCustoMedioNoite.getText()));
                    model.setQuant_noites(getIntegerValueFromEditable(edtQuantNoites.getText()));
                    model.setQuant_quartos(getIntegerValueFromEditable(edtQuantQuartos.getText()));
                    model.setKm_rodado(getDobuleValueFromEditable(edtKm.getText()));
                    model.setMedia_km_rodado(getDobuleValueFromEditable(edtMediaKmL.getText()));
                    model.setValor_l(getDobuleValueFromEditable(edtCustoL.getText()));
                    model.setQuant_veic_usados(getIntegerValueFromEditable(edtQuantVeic.getText()));
                    model.setCusto_passagem(getDobuleValueFromEditable(edtValorPassagemPessoa.getText()));
                    model.setCusto_aluguel_veic(getDobuleValueFromEditable(edtAluguelVeic.getText()));
                    model.setCusto_entretenimento_um(getDobuleValueFromEditable(edtCustoOutrosOne.getText()));
                    model.setCusto_entretenimento_dois(getDobuleValueFromEditable(edtCustoOutrosTwo.getText()));
                    model.setCusto_entretenimento_tres(getDobuleValueFromEditable(edtCustoOutrosTree.getText()));

                    if (edtDescOutrosOne.getText().toString().trim().length() > 0) {
                        model.setDescEntretenimentoOne(edtDescOutrosOne.getText().toString());
                    } else {
                        model.setDescEntretenimentoOne(null);
                    }

                    if (edtDescOutrosTwo.getText().toString().trim().length() > 0) {
                        model.setDescEntretenimentoTwo(edtDescOutrosTwo.getText().toString());
                    } else {
                        model.setDescEntretenimentoTwo(null);
                    }

                    if (edtDescOutrosTree.getText().toString().trim().length() > 0) {
                        model.setDescEntretenimentoTree(edtDescOutrosTree.getText().toString());
                    } else {
                        model.setDescEntretenimentoTree(null);
                    }

                    model.setIdusuario(shared.getInt(shared.KEY_USUARIO_LOGADO));

                    //Calcula o total da gasolina
                    TotalGasolina = ((model.getKm_rodado()/model.getMedia_km_rodado())*model.getValor_l())/model.getQuant_veic_usados();

                    //Calcula o total da tárifa área
                    TotalTarAerea = ((model.getCusto_passagem()*model.getNumero_viajantes())+model.getCusto_aluguel_veic());

                    //Calcula o total de refeições
                    TotalRefeic = ((model.getQuant_refeicao()*model.getNumero_viajantes())*model.getCusto_refeicao()*model.getDuracao_viajem());

                    //Calcula o total de hospedagem
                    TotalHospedagem = ((model.getCusto_hotel() * model.getQuant_noites()) * model.getQuant_quartos());

                    //Calcula o total de entretenimento
                    TotalDiversos = ((model.getCusto_entretenimento_um() + model.getCusto_entretenimento_dois() + model.getCusto_entretenimento_tres()));

                    //Calcula a despesa Total.
                    if(TotalGasolina == null || TotalGasolina < 0 || Double.isNaN(TotalGasolina) ) TotalGasolina = 0.00;
                    if(TotalTarAerea == null || TotalTarAerea < 0 || Double.isNaN(TotalTarAerea) ) TotalTarAerea = 0.00;
                    if(TotalRefeic == null || TotalRefeic < 0 || Double.isNaN(TotalRefeic)) TotalRefeic = 0.00;
                    if(TotalHospedagem == null || TotalHospedagem < 0 || Double.isNaN(TotalHospedagem) ) TotalHospedagem = 0.00;
                    if(TotalDiversos == null || TotalDiversos < 0 || Double.isNaN(TotalDiversos) ) TotalDiversos = 0.00;

                    TotalDespesasViajem = TotalGasolina + TotalTarAerea + TotalRefeic + TotalHospedagem + TotalDiversos;

                    model.setCusto_total_gasolina(TotalGasolina);
                    model.setCusto_total_tar_aerea(TotalTarAerea);
                    model.setCusto_total_refeicoes(TotalRefeic);
                    model.setCusto_total_hospedagem(TotalHospedagem);
                    model.setCusto_total_diversos(TotalDiversos);
                    model.setCusto_total_viajem(TotalDespesasViajem);

                    //Faz o insert no Banco de Dados
                    if (dao.Insert(model) != -1){
                        Toast.makeText(InformacoesActivity.this, "Dados gravados com sucesso!", Toast.LENGTH_LONG).show();

                        //Vai para a activity Relatorio.
                        startActivity(new Intent(InformacoesActivity.this, RelatorioActivity.class));
                    }else{
                        Toast.makeText(InformacoesActivity.this, "Erro Ao Gravar Viajem.", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(InformacoesActivity.this, "Erro Ao Gravar Viajem: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Vai para a activity Main.
                startActivity(new Intent(InformacoesActivity.this, MainActivity.class));
            }
        });
    }

    public Integer getIntegerValueFromEditable(Editable editable) {
        if (editable.toString().trim().length() > 0) return Integer.parseInt(editable.toString());

        return 0;
    }

    public Double getDobuleValueFromEditable(Editable editable) {
        if (editable.toString().trim().length() > 0) return Double.parseDouble(editable.toString());
        
        return 0.00;
    }
}
