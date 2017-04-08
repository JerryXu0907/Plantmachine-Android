package com.example.jerry.application11;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;
import android.database.Cursor;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by jerry on 16/4/7.
 */
public class FirstActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    //declare
    private List<Plant> plantList = new ArrayList<Plant>();
    private GoogleApiClient client;
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "Vegetable.db",null,1);
    int i = 0;

    //init
    /*
    SQLiteDatabase db = dbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    {
        values.put("name", "Veg1");
        values.put("location", "Shanghai");
        values.put("category", "Green");
        values.put("days", 31);
        db.insert("vegetable", null, values);
        values.clear();
        values.put("name", "Veg2");
        values.put("location", "Shanghai");
        values.put("category", "Green");
        values.put("days", 14);
        db.insert("vegetable", null, values);
        values.clear();
        values.put("name", "Veg3");
        values.put("location", "Shanghai");
        values.put("category", "Green");
        values.put("days", 7);
        db.insert("vegetable", null, values);

    }
    */

    //initalization of the plants
    public void initPlant() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("vegetable", null, null, null, null, null, null);
        if(i==1){
            int temp1 = plantList.size();
            for (int temp = 0; temp < temp1; temp++){
                plantList.remove(0);
            }
        }else{
            ContentValues values = new ContentValues();
            {
                values.put("name", "Veg1");
                values.put("location", "Shanghai");
                values.put("category", "Green");
                values.put("days", 31);
                db.insert("vegetable", null, values);
                values.clear();
                values.put("name", "Veg2");
                values.put("location", "Shanghai");
                values.put("category", "Green");
                values.put("days", 14);
                db.insert("vegetable", null, values);
                values.clear();
                values.put("name", "Veg3");
                values.put("location", "Shanghai");
                values.put("category", "Green");
                values.put("days", 7);
                db.insert("vegetable", null, values);
                i = 1;
            }

        }

        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String location = cursor.getString(cursor.getColumnIndex("location"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                int days = cursor.getInt(cursor.getColumnIndex("days"));
                Plant p = new Plant(name, location, category,days);
                plantList.add(p);
            }while (cursor.moveToNext());
        }
        cursor.close();



        /*
        Plant vege1 = new Plant("青菜1", "上海", "青菜", 31);
        plantList.add(vege1);
        Plant vege2 = new Plant("青菜2", "上海", "青菜", 11);
        Plant vege3 = new Plant("青菜3", "上海", "青菜", 21);
        Plant vege4 = new Plant("青菜4", "上海", "青菜", 7);
        Plant vege5 = new Plant("青菜5", "上海", "青菜", 9);
        plantList.add(vege2);
        plantList.add(vege3);
        plantList.add(vege4);
        plantList.add(vege5);
        */
    }




    //Intent get
    @Override
    protected void onActivityResult(int requesCode, int resultCode, Intent data) {
        switch (requesCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    /*
                    String[] returnedData = data.getStringArrayExtra("data_return");
                    String str1 = returnedData[0];
                    String str2 = returnedData[1];
                    String str3 = returnedData[2];
                    Plant plant = new Plant(str1, str2, str3, 0);
                    */

                    initPlant();

                }
                break;
            default:
                break;
        }
    }

    //main method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //get intent and show
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_first);


        //sqlite
        dbHelper.getReadableDatabase();


        //button_new
        Button button1 = (Button) findViewById(R.id.title_edit);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, NewActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        //initialization of the listview
        PlantAdapter adapter = new PlantAdapter(FirstActivity.this, R.layout.plant_view, plantList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Plant plant = plantList.get(position);
                Intent intent = new Intent(FirstActivity.this, DetailActivity.class);
                String[] things = {plant.getName(), plant.getCity(), plant.getCategory()};
                int number = plant.getTime();
                intent.putExtra("extraString[]", things);
                intent.putExtra("number", number);
                startActivity(intent);
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
                "First Page", // TODO: Define a title for the content shown.
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
                "First Page", // TODO: Define a title for the content shown.
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

}

