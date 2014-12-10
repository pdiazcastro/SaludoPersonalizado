package com.example.pdiazcastro.saludopersonalizado;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;

public class MySpinner extends Activity {

    private Spinner spinner1;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Hola");
        list.add("Adios");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        addListenerOnButton();


    }

    // Add spinner data

    public void addListenerOnSpinnerItemSelection(){

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //get the selected dropdown list value

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MySpinner.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(spinner1.getSelectedItem()) ,
                        Toast.LENGTH_LONG).show();
            }

        });

    }

}