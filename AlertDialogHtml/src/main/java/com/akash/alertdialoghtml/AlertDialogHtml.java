package com.akash.alertdialoghtml;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Html;

public class AlertDialogHtml {


    public static void showAlertDialog(Context context, Drawable drawable, String title, String message, boolean isTwoButtons, String firstbutton, String secondbutton) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(Html.fromHtml(message));
        alertDialog.setTitle(Html.fromHtml(title));
        alertDialog.setIcon(drawable);
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        if (isTwoButtons) {
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,Html.fromHtml(firstbutton), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,Html.fromHtml(secondbutton), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

        }else {
            alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,Html.fromHtml(firstbutton), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });
        }
        alertDialog.show();
    }

}
