package br.ufes.llcostalonga.android.exemplolistener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;
    TextView txtQualquer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQualquer = (TextView) findViewById(R.id.txtQualquer);
         registerForContextMenu(txtQualquer);

        bt1 = (Button) findViewById(R.id.bt1);
      /*  bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtQualquer.setText("O Bt1 foi clicado");
            }
        });*/


        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(btClickListener);
        bt1.setOnClickListener(btClickListener);

    }

    private View.OnClickListener btClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = "BT2";
            if (v.getId() == R.id.bt1) {
                text = "BT1";
            }
            txtQualquer.setText(text);
        }
    };

    public void chamarOutraAtividade(View v){
        Intent outraAtividadeIntent = new Intent(this, OutraAtividade.class);

        startActivity(outraAtividadeIntent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.option_menu,menu);

        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contexto_flutuante_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.limparCampo:
                txtQualquer.setText("");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast;
        switch (item.getItemId()){
            case R.id.new_game:
                  toast = Toast.makeText(this, "Oba..novo jogo!", Toast.LENGTH_SHORT);
                   toast.show();
                    break;
            case R.id.help:
                   toast = Toast.makeText(this, "Epa..alguem encrencado!", Toast.LENGTH_SHORT);
                   toast.show();
                    break;
            default:
                return super.onOptionsItemSelected(item);
        }

      return true;

    }
}
