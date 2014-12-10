package com.example.pdiazcastro.saludopersonalizado;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TimePicker timePicker;
        final DatePicker datePicker;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        timePicker = (TimePicker) findViewById(R.id.idtimepicker);
        datePicker = (DatePicker) findViewById(R.id.iddatepicker);
        Button button = (Button) findViewById(R.id.hello);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.entry);
                String salutation = null;
                String enteredName = text.getText().toString();

                RadioGroup radio = (RadioGroup) findViewById(R.id.RadioGroup01);


                if (R.id.rdbSra == (radio.getCheckedRadioButtonId())) {
                    //para sra
                    salutation = getResources().getString(R.string.saludoSra);
                } else {
                    salutation = getResources().getString(R.string.saludoSr);
                }

                if (text.getText().toString().isEmpty()) {

                    String msg = getString(R.string.nonombre);
                    showToast(msg);
                    return;

                }

                salutation = getResources().getString(R.string.hello) + " " + salutation + " " + enteredName;

                Intent intent = new Intent(MyActivity.this, Saludo.class);
                intent.putExtra("salutation", salutation);
                startActivity(intent);
            }
        });
        final CheckBox checkBox = (CheckBox) findViewById(R.id.idcheckbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {
                    timePicker.setVisibility(TimePicker.VISIBLE);
                } else {
                    timePicker.setVisibility(TimePicker.GONE);
                }
            }
        });
        final CheckBox cbxdate = (CheckBox) findViewById(R.id.idcbxdate);
        cbxdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbxdate.isChecked()) {
                    datePicker.setVisibility(DatePicker.VISIBLE);
                } else {
                    datePicker.setVisibility(DatePicker.GONE);
                }
            }
        });
    }

    protected void showToast(String msg) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT;
        Toast tostada = Toast.makeText(contexto, msg, duracion);
        tostada.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
