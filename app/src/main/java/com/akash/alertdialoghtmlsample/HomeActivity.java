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
import com.akash.alertdialoghtml.AlertDialogHtmlListner;
import com.akash.alertdialoghtml.Animation;
import com.akash.alertdialoghtml.Font;
import com.akash.alertdialoghtml.InputType;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Context context;


    EditText htmlTitle, htmlMessage, htmlFirstButton, htmlSecondButton;
    SwitchMaterial switchIsButtons, switchIsHTML;
    MaterialButton btnShowAlert;
    boolean isBothBUtton, isHtmlColor;
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

        title = "<font color='#BB86FC'><b>Hello User</b></font>";
        msg = "<font color='#007b32'><u>Thank you for choosing this library</u></font>";
        stringbuttonfirst = "<font color='#3700B3'><b>YES</b></font>";
        stringbuttonsecond = "<font color='#FF6200'><b>NO</b></font>";

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
                    isBothBUtton = isChecked;
                } else {

                    Toast.makeText(context, "Two buttons Disabled", Toast.LENGTH_SHORT).show();
                    htmlSecondButton.setVisibility(View.GONE);
                    isBothBUtton = isChecked;
                }
            }
        });

        switchIsHTML.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(context, "Html Color Enabled", Toast.LENGTH_SHORT).show();

                    isHtmlColor = isChecked;
                } else {

                    Toast.makeText(context, "Html Color Disabled", Toast.LENGTH_SHORT).show();
                    isHtmlColor = isChecked;
                }
            }
        });


        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialogHtml.Builder(context)
                        .setTitle(title)
                        .setMessage(msg)
                        .setPositiveBtnText(stringbuttonfirst)
                        .setNegativeBtnText(stringbuttonsecond)
                        .setCancelableOnTouchOutside(true)
                        .setCancelable(true)
                        .setFont(Font.QUESTRAILREGULAR)
                        .setImage(R.drawable.ic_copy)
                        .setBothButtons(isBothBUtton)
                        .setTitleTextColor(R.color.purple_700)
                        .setCustomFont(R.font.fudgie)
                        .setAnimation(Animation.DOWN)
                        .setHtmlColors(isHtmlColor)
                        .setButtonTextColor(R.color.purple_200)
                        .setEditText(true, false, title, InputType.PASSWORD)
                        .OnPositiveClicked(new AlertDialogHtmlListner() {
                            @Override
                            public void OnClick(String input) {
                                Toast.makeText(context, "Positive"+"Text Value : "+input, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .OnNegativeClicked(new AlertDialogHtmlListner() {
                            @Override
                            public void OnClick(String input) {
                                Toast.makeText(context, "Negative"+"Text Value : "+input, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .build();

            }
        });
    }


    /**
     * This method will initialize the UI components
     */

    private void initUI() {


        switchIsButtons = findViewById(R.id.switchIsButtons);
        switchIsHTML = findViewById(R.id.switchIshtml);
        htmlTitle = findViewById(R.id.htmlTitle);
        htmlMessage = findViewById(R.id.htmlMessage);
        htmlFirstButton = findViewById(R.id.htmlFirstButton);
        htmlSecondButton = findViewById(R.id.htmlSecondButton);
        btnShowAlert = findViewById(R.id.btnShowAlert);

    }


}