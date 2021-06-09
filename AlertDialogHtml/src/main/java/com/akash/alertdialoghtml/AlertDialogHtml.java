package com.akash.alertdialoghtml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.util.Objects;

public class AlertDialogHtml {


    public static class Builder {
        private static final int URL = 1;
        private static final int DEVICE = 2;
        private static final int RESOURCE = 3;
        private int imageType = 0;

        private Context context;
        private String title, message, positiveBtnText, negativeBtnText;
        private String imageUrl;
        private File imageFile;
        @DrawableRes
        private int imageResourceId;
        private boolean showEditText;
        private boolean showBothButtons;
        private boolean rtl;
        private String hintText;
        private InputType inputType;
        private int buttonTextColor, titleTextColor, messageTextColor, fontId;
        private boolean cancelOnTouchOutside = true;
        private boolean cancelable = true;
        private boolean isHtmlColors = true;
        private AlertDialogHtmlListner positiveListener, negativeListener, neutralListner;
        private Animation animation;
        private Font font;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setAnimation(Animation animation) {
            this.animation = animation;
            return this;
        }

        public Builder setCancelableOnTouchOutside(boolean cancelOnTouchOutside) {
            this.cancelOnTouchOutside = cancelOnTouchOutside;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setHtmlColors(boolean isHtmlColors) {
            this.isHtmlColors = isHtmlColors;
            return this;
        }

        public Builder setFont(Font font) {
            this.font = font;
            return this;
        }

        public Builder setCustomFont(int fontId) {
            this.fontId = fontId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setImage(String imageUrl, int imagePercent) {
            this.imageUrl = imageUrl;
            this.imageType = URL;
            return this;
        }

        public Builder setImage(File imageFile) {
            this.imageFile = imageFile;
            this.imageType = DEVICE;
            return this;
        }

        public Builder setImage(int imageResourceId) {
            this.imageResourceId = imageResourceId;
            this.imageType = RESOURCE;
            return this;
        }

        public Builder setEditText(boolean showEditText, boolean rtl, String hintText, InputType inputType) {
            this.showEditText = showEditText;
            this.hintText = hintText;
            this.inputType = inputType;
            this.rtl = rtl;
            return this;
        }


        public Builder setBothButtons(boolean showBothButtons) {
            this.showBothButtons = showBothButtons;
            return this;
        }


        public Builder setTitleTextColor(int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public Builder setMessageTextColor(int messageTextColor) {
            this.messageTextColor = messageTextColor;
            return this;
        }


        public Builder setButtonTextColor(int buttonTextColor) {
            this.buttonTextColor = buttonTextColor;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder OnPositiveClicked(AlertDialogHtmlListner positiveListener) {
            this.positiveListener = positiveListener;
            return this;
        }

        public Builder OnNegativeClicked(AlertDialogHtmlListner negativeListener) {
            this.negativeListener = negativeListener;
            return this;
        }

        public void build() {
            int style;
            if (animation == Animation.UP) style = R.style.AlertHtmlUpTheme;
            else if (animation == Animation.DOWN) style = R.style.AlertHtmlDownTheme;
            else style = 0;

            final androidx.appcompat.app.AlertDialog dialog = style != 0 ?
                    new androidx.appcompat.app.AlertDialog.Builder(context, style).create() :
                    new AlertDialog.Builder(context).create();

            dialog.setCanceledOnTouchOutside(cancelOnTouchOutside);
            dialog.setCancelable(cancelable);

            @SuppressLint("InflateParams")
            View v = LayoutInflater.from(context).inflate(R.layout.alert_html_dialog_layout, null);
            dialog.setView(v);

            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            Objects.requireNonNull(dialog.getWindow()).requestFeature(Window.FEATURE_NO_TITLE);

            TextView tvTitle = v.findViewById(R.id.tv_alert_dialog_layout_title),
                    tvMessage = v.findViewById(R.id.tv_alert_dialog_layout_message);

            ImageView imageView = v.findViewById(R.id.iv_alert_dialog_layout_image);

            final EditText editText = v.findViewById(R.id.et_alert_dialog_layout_input);

            MaterialButton btnPositive = v.findViewById(R.id.btnPositive);

            MaterialButton btnNegative = v.findViewById(R.id.btnNegative);


            if (font != null) {
                Typeface tf, tfb = null;
                if (font == Font.OXYGENLIGHT) {
                    tf = ResourcesCompat.getFont(context, R.font.oxygenlight);
                } else if (font == Font.QUESTRAILREGULAR) {
                    tf = ResourcesCompat.getFont(context, R.font.questrialregular);
                } else {
                    tf = ResourcesCompat.getFont(context, R.font.questrialregular);
                }

                if (font == Font.OXYGENLIGHT) {
                    tvTitle.setTypeface(tfb);
                    btnPositive.setTypeface(tfb);
                } else {
                    tvTitle.setTypeface(tf);
                    btnNegative.setTypeface(tf);
                }
                tvMessage.setTypeface(tf);
                editText.setTypeface(tf);
                btnNegative.setTypeface(tf);
            }

            if (fontId != 0) {
                Typeface tf = ResourcesCompat.getFont(context, fontId);
                tvTitle.setTypeface(tf);
                tvMessage.setTypeface(tf);
                editText.setTypeface(tf);
                btnPositive.setTypeface(tf);
                btnNegative.setTypeface(tf);
            }

            if (title != null)
                tvTitle.setText(Html.fromHtml(title));
            else
                tvTitle.setVisibility(View.GONE);

            if (message != null)
                tvMessage.setText(Html.fromHtml(message));
            else
                tvMessage.setVisibility(View.GONE);


            if (imageType == URL) {
                Glide.with(context)
                        .load(Uri.parse(imageUrl))
                        .into(imageView);
            } else if (imageType == DEVICE) {
                Glide.with(context)
                        .load(Uri.fromFile(imageFile))
                        .into(imageView);
            } else if (imageType == RESOURCE) {
                imageView.setImageResource(imageResourceId);
            } else {
                imageView.setVisibility(View.GONE);
            }


            if (showEditText) {
                editText.setVisibility(View.VISIBLE);
            } else {
                editText.setVisibility(View.GONE);
            }
            if (showBothButtons) {
                btnNegative.setVisibility(View.VISIBLE);
                btnPositive.setVisibility(View.VISIBLE);
            } else {
                btnNegative.setVisibility(View.GONE);
                btnPositive.setVisibility(View.VISIBLE);
            }

            editText.setLayoutDirection(rtl ? View.LAYOUT_DIRECTION_RTL : View.LAYOUT_DIRECTION_LTR);

            if (hintText != null) {
                editText.setHint(Html.fromHtml(hintText));
            }

            if (inputType == InputType.TEXT_SINGLE_LINE)
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
            else if (inputType == InputType.TEXT_MULTI_LINE)
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            else if (inputType == InputType.NUMBER)
                editText.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
            else if (inputType == InputType.PASSWORD)
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
            else
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT);

            if (isHtmlColors) {
                if (titleTextColor != 0) {
                    tvTitle.setTextColor(titleTextColor);
                }

                if (messageTextColor != 0) {
                    tvMessage.setTextColor(messageTextColor);
                }

                if (buttonTextColor != 0) {
                    btnPositive.setTextColor(buttonTextColor);
                    btnNegative.setTextColor(buttonTextColor);
                }
            } else {


                if (titleTextColor != 0) {
                    tvTitle.setTextColor(titleTextColor);
                }

                if (messageTextColor != 0) {
                    tvMessage.setTextColor(messageTextColor);
                }

                if (buttonTextColor != 0) {
                    btnPositive.setTextColor(buttonTextColor);
                    btnNegative.setTextColor(buttonTextColor);
                }

                if (positiveBtnText != null) {
                    btnPositive.setText(removeHtml(positiveBtnText));
                }

                if (negativeBtnText != null) {
                    btnNegative.setText(removeHtml(negativeBtnText));
                }
                if (title != null) {
                    tvTitle.setText(removeHtml(title));
                }

                if (title != null) {
                    tvMessage.setText(removeHtml(message));
                }
                if (hintText != null) {
                    editText.setHint(removeHtml(hintText));
                }
            }

            if (positiveBtnText != null) {
                btnPositive.setText(Html.fromHtml(positiveBtnText));
            }

            if (negativeBtnText != null) {
                btnNegative.setText(Html.fromHtml(negativeBtnText));
            }

            if (positiveListener != null) {
                btnPositive.setVisibility(View.VISIBLE);
                btnPositive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        positiveListener.OnClick(editText.getVisibility() == View.VISIBLE ? editText.getText().toString() : "");
                        dialog.dismiss();
                    }
                });

            } else {
                btnPositive.setVisibility(View.GONE);
            }

            if (negativeListener != null && showBothButtons) {
                btnNegative.setVisibility(View.VISIBLE);
                btnNegative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        negativeListener.OnClick(editText.getVisibility() == View.VISIBLE ? editText.getText().toString() : "");
                        dialog.dismiss();
                    }
                });
            } else {
                btnNegative.setVisibility(View.GONE);
            }


            dialog.show();
        }
    }


    private static String removeHtml(String html) {
        html = html.replaceAll("<(.*?)\\>", " ");
        html = html.replaceAll("<(.*?)\\\n", " ");
        html = html.replaceFirst("(.*?)\\>", " ");
        html = html.replaceAll("&nbsp;", " ");
        html = html.replaceAll("&amp;", " ");
        return html;
    }


}
