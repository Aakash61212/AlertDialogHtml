package com.akash.alertdialoghtmlsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Context context;

    EditText htmlTitle, htmlMessage, htmlFirstButton, htmlSecondButton;
    SwitchMaterial switchIsButtons;
    MaterialButton btnShowAlert;
    boolean isBothBUtton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        initUI();


        switchIsButtons.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context, "Two buttons Enabled", Toast.LENGTH_SHORT).show();
                    htmlSecondButton.setVisibility(View.VISIBLE);
                    isBothBUtton=isChecked;
                } else {

                    Toast.makeText(context, "Two buttons Disabled", Toast.LENGTH_SHORT).show();
                    htmlSecondButton.setVisibility(View.GONE);
                    isBothBUtton=isChecked;
                }
            }
        });



        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "show Alert", Toast.LENGTH_SHORT).show();



            }
        });
    }




    /**
     * This method will initialize the UI components
     */

    private void initUI() {


        switchIsButtons = findViewById(R.id.switchIsButtons);
        htmlTitle = findViewById(R.id.htmlTitle);
        htmlMessage = findViewById(R.id.htmlMessage);
        htmlFirstButton = findViewById(R.id.htmlFirstButton);
        htmlSecondButton = findViewById(R.id.htmlSecondButton);
        btnShowAlert = findViewById(R.id.btnShowAlert);

    }


}