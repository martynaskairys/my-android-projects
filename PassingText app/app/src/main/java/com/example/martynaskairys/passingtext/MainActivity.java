package com.example.martynaskairys.passingtext;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.martynaskairys.myapplication";

    EditText editText;
    EditText editText2;

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();


    }

    private void findViews() {


//        1 method to pass text
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                editText = (EditText) findViewById(R.id.editText1);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);

                startActivity(intent);
            }
        });


        //        2 method to pass text
        button2 = (Button) findViewById(R.id.button2);
        editText2 = (EditText) findViewById(R.id.editText2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }


    private void sendData() {

        Intent intent = new Intent(this, Main2Activity.class);

        Bundle bundle = new Bundle();
        bundle.putString("name", editText2.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);


    }


    //    on click from xml (3rd way of passing data)
    public void onSendMessage(View view) {

        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(Main2Activity.EXTRA_MESSAGE2, messageText);
        startActivity(intent);
    }

    public void sendData4(View view) {


        // if no intent chooser then
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello");

        startActivity(intent);
    }

    public void sendData2(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);

        // Always use string resources for UI text.
// This says something like "Share this photo with"
        String title = getResources().getString(R.string.chooser_title);

//        MIME type (setType). full list of MIME (https://www.sitepoint.com/web-foundations/mime-types-complete-list/)
        intent.setType("video/mpeg");

//        extra info if needed in the intent
        intent.putExtra(Intent.EXTRA_TEXT, "Hello");
        // Create intent to show chooser
        Intent chooser = Intent.createChooser(intent, title);

// Verify the intent will resolve to at least one activity
        if (intent.resolveActivity(getPackageManager()) != null)

        {
            startActivity(chooser);
        }

    }

/*

// why boomerang app opens when pressing the button?
     public void sendData2(View view) {

//         EditText editText4 = (EditText) findViewById(R.id.editText4);


        Intent intent = new Intent(Intent.ACTION_SEND);

        Bundle bundle = new Bundle();
//        bundle.putString("name", editText4.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }
*/

}
