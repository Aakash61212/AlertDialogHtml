package com.akash.alertdialoghtml;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.Toast;

public class AlertDialogHtml {


    public static void showAlertDialog(Context context, Drawable drawable, String title, String message, boolean isTwoButtons, String firstbutton, String secondbutton) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        if (message != null && !message.isEmpty() && title != null && !title.isEmpty() && firstbutton != null && !firstbutton.isEmpty()) {


            alertDialog.setTitle(Html.fromHtml(title));
            alertDialog.setMessage(Html.fromHtml(message));
            alertDialog.setIcon(drawable);
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
            if (isTwoButtons) {
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, Html.fromHtml(firstbutton), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, Html.fromHtml(secondbutton), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });

            } else {
                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, Html.fromHtml(firstbutton), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
            }
            alertDialog.show();
        }else {
            Toast.makeText(context, "Please Insert Values", Toast.LENGTH_SHORT).show();
        }
    }

}
