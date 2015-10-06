package com.pruebas.pablo.parametres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView saludo;
    String nombreA1;
    Button btn2;
    EditText edadedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //extraer datos del bundle
        Bundle bundle=getIntent().getExtras();
        if(bundle.getString("nombre")!=null){
            nombreA1=bundle.getString("nombre");
        }


        saludo=(TextView) findViewById(R.id.saludo);
        saludo.setText("Hola "+nombreA1+" ,indican's les seguents dades:");
        btn2=(Button) findViewById(R.id.btn2);
        edadedit=(EditText) findViewById(R.id.campoedad);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencionRetorno=new Intent();
                intencionRetorno.putExtra("edad",edadedit.getText().toString());
                setResult(RESULT_OK, intencionRetorno);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
