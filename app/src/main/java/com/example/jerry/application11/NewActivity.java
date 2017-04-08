package com.example.jerry.application11;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 16/4/7.
 */
public class NewActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button button1 = (Button) findViewById(R.id.title_fornewback);

        final MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "Vegetable.db",null,1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(NewActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.confirm_fornew);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                EditText editText1 = (EditText) findViewById(R.id.editname_fornew);
                EditText editText2 = (EditText) findViewById(R.id.editcity_fornew);
                EditText editText3 = (EditText) findViewById(R.id.editcategory_fornew);
                String str1 = editText1.getText().toString();
                String str2 = editText2.getText().toString();
                String str3 = editText3.getText().toString();
                insertAndUpdateData(dbHelper,str1,str2,str3,i);
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();

                /*
                String[] stringList = {str1,str2,str3};
                Intent intent = new Intent();
                intent.putExtra("data_return", stringList);
                setResult(RESULT_OK,intent);
                finish();
                */
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "New Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.jerry.application11/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "New Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.jerry.application11/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void insertAndUpdateData(MyDatabaseHelper myHelper, String a, String b, String c, int d){
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", a);
        values.put("location", b);
        values.put("category", c);
        values.put("days", d);
        db.insert("vegetable", null, values);
    }


}
