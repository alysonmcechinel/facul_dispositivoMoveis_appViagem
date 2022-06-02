package desenvolv.mastersys.appviajem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import desenvolv.mastersys.appviajem.adapter.TripAdapter;
import desenvolv.mastersys.appviajem.database.dao.ViajemDAO;
import desenvolv.mastersys.appviajem.database.model.ViajemModel;
import desenvolv.mastersys.appviajem.util.Shared;

public class MyTripsActivity extends AppCompatActivity {

    private TextView
    textNome,
    textTotalPessoa,
    textTotalViajem,
    textDuracaoViajem,
    textTotalViajantes;

    private Shared shared;

    private ViajemDAO viajemDAO;

    private ArrayList<String[]> list = new ArrayList<String[]>();

    private TripAdapter adapter;

    private ListView listaTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            //Seta o xml.
            setContentView(R.layout.activity_my_trips);
            shared = new Shared(MyTripsActivity.this);

            viajemDAO = new ViajemDAO(MyTripsActivity.this);

            List<ViajemModel> model = viajemDAO.SelectAllByUser(shared.getInt(shared.KEY_USUARIO_LOGADO));

            listaTrips = findViewById(R.id.listaTrips);

            String[] dados = new String[model.size()];

            for(int i = 0; i < model.size(); i++) {
                ViajemModel viajemModel = model.get(i);
                dados[i] = "Id: " + viajemModel.getId() + "\nNome: " + viajemModel.getNome() + "\nTotal: " + new DecimalFormat("###,##0.00").format(viajemModel.getCusto_total_viajem());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyTripsActivity.this, android.R.layout.simple_list_item_1, dados);
            listaTrips.setAdapter(adapter);
        } catch(Exception ex) {
            Toast.makeText(MyTripsActivity.this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}
