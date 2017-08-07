package com.example.martynaskairys.passingtext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE2 = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        1 method
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);



//        2 method

        TextView textView2 = (TextView) findViewById(R.id.textView_result1);
        Bundle bundle = getIntent().getExtras();
        textView2.setText(bundle.getString("name"));

//        3 method

        Intent intent3 = getIntent();
        String messageText = intent3.getStringExtra(EXTRA_MESSAGE2);
        TextView messageView = (TextView)findViewById(R.id.textView_result);
        messageView.setText(messageText);


    }
}
