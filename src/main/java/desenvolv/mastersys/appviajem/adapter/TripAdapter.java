package desenvolv.mastersys.appviajem.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class TripAdapter extends BaseAdapter {
    private Activity activity;
    private List<String[]> lista;

    public TripAdapter(final Activity activity, final List<String[]> lista){
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Se for a primeira vez, vai estar null
        if(convertView == null){
            //Vou inflar o xml.
            //convertView = activity.getLayoutInflater().inflate(R.layout., parent, false);
        }

        /*TextView codigoProduto = convertView.findViewById(R.id.codigoProduto);
        codigoProduto.setText("Código: "+((ProdutoModel)getItem(position)).getCodigoProduto());

        TextView nomeProduto = convertView.findViewById(R.id.nomeProduto);
        nomeProduto.setText("Nome: "+((ProdutoModel)getItem(position)).getNomeProduto());

        TextView barrasProduto = convertView.findViewById(R.id.barrasProduto);
        barrasProduto.setText("Código de Barras:" +((ProdutoModel)getItem(position)).getBarrasProduto());

        TextView estoqueProduto = convertView.findViewById(R.id.estoqueProduto);


        LinearLayout btnEstoque = convertView.findViewById(R.id.btnEstoque);*/

        return convertView;
    }
}