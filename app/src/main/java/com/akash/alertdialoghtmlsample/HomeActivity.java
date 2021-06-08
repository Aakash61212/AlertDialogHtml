package com.akash.alertdialoghtmlsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akash.alertdialoghtml.AlertDialogHtml;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Context context;

    EditText htmlTitle, htmlMessage, htmlFirstButton, htmlSecondButton;
    SwitchMaterial switchIsButtons;
    MaterialButton btnShowAlert;
    boolean isBothBUtton;
    String msg;
    String title;
    String stringbuttonfirst;
    String stringbuttonsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        initUI();

        title="<font color='#FFBB86FC'><b>Hello User</b></font>";
        msg="<font color='#007b32'><u>Thank you for choosing this library</u></font>";
        stringbuttonfirst="<font color='#FF03DAC5'><b>YES</b></font>";
        stringbuttonsecond="<font color='#FF6200EE'><b>NO</b></font>";

        htmlTitle.setText(title);
        htmlMessage.setText(msg);
        htmlFirstButton.setText(stringbuttonfirst);
        htmlSecondButton.setText(stringbuttonsecond);


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

               AlertDialogHtml.showAlertDialog(context,getDrawable(R.drawable.ic_copy),htmlTitle.getText().toString().trim(),htmlMessage.getText().toString().trim(),isBothBUtton,htmlFirstButton.getText().toString().trim(),htmlSecondButton.getText().toString().trim());

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