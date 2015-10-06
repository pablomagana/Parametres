package com.pruebas.pablo.parametres;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    Button boton;
    RadioGroup sexes;
    RadioButton rbf,rbm;
    String stringnombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText) findViewById(R.id.campoNombre);
        boton=(Button) findViewById(R.id.btnDatos);
        sexes=(RadioGroup) findViewById(R.id.groupsexe);

        rbf=(RadioButton) findViewById(R.id.rsf);
        rbm=(RadioButton) findViewById(R.id.rsm);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //capturar los datos

                int sexe=sexes.getCheckedRadioButtonId();
                //0 mascle 1 femella
                String stringsexe;
                if(sexe==0){
                    stringsexe="mascle";
                }else{
                    stringsexe="femella";
                }
                //enviar datos
                Intent intento=new Intent(MainActivity.this,Activity2.class);
                stringnombre=nombre.getText().toString();
                intento.putExtra("nombre",stringnombre);
                startActivityForResult(intento,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0){
            if(resultCode== Activity.RESULT_OK){
                nombre.setEnabled(false);
                rbm.setEnabled(false);
                rbf.setEnabled(false);
                TextView resultado=(TextView) findViewById(R.id.resultado);
                int edadExtraida=Integer.parseInt(data.getStringExtra("edad"));
                if(edadExtraida>18 && edadExtraida<25){
                    resultado.setText("Com que tens "+data.getStringExtra("edad")+", ja eres major d'edad");
                }else {
                    if(edadExtraida>=25 && edadExtraida <35){
                        resultado.setText("Com que tens "+data.getStringExtra("edad")+", estas en la flor de la vida");
                    }else{
                        if(edadExtraida>=35){
                            resultado.setText("Com que tens "+data.getStringExtra("edad") + ", ai, ai, ai...");
                        }
                    }
                }

            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
