package desenvolv.mastersys.appviajem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import desenvolv.mastersys.appviajem.util.Shared;

public class MainActivity extends AppCompatActivity {

    private Button btnMytrips, btnNewTrip;
    private LinearLayout linearCor;
    private Shared shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            //Seta o xml.
            setContentView(R.layout.activity_2_main);

            //Instância os componentes do xml.
            btnMytrips = findViewById(R.id.btnMytrips);
            btnNewTrip = findViewById(R.id.btnNewtrip);

            //Drawable background = linearCor.getBackground();
            //linearCor = findViewById(R.id.linearCor);

            //setar background
            shared = new Shared(MainActivity.this);
            linearCor = findViewById(R.id.linearCor);
            linearCor.setBackgroundColor(shared.getInt(Shared.KEY_COR_LINEAR));

            //Ação do botão NewTrip
            btnNewTrip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Vai para a próxima activity.
                    startActivity(new Intent(MainActivity.this, InformacoesActivity.class));
                }
            });

            //Ação do botão MyTrips
            btnMytrips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Vai para a próxima activity.
                    startActivity(new Intent(MainActivity.this, MyTripsActivity.class));
                }
            });
        }  catch(Exception ex) {
            Toast.makeText(MainActivity.this, "Erro main activity: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}