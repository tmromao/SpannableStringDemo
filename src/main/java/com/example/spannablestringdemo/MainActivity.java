package com.example.spannablestringdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        textView = findViewById(R.id.text_view);

        //Initialize spannable string

        SpannableString spannableString = new SpannableString(
                "Click on Google\n\nOR\n\n Click on Yahoo"
        );

        //Initialize clickable span

        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //Initialize intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));

                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //Start activity
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                //Set text color
                ds.setColor(Color.RED);
                //Set underline
                ds.setUnderlineText(false);
            }
        };

        //Initialize clickable span
        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //Initialize intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //Start activity
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                //Set text color
                ds.setColor(Color.BLUE);
                //set Underline
                ds.setUnderlineText(true);
            }
        };

        //Set span
        spannableString.setSpan(span1, 9,15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(span2,30,35,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //Set text
        textView.setText(spannableString);
        //Set link movement method
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}