package com.example.jerry.application11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jerry on 16/4/7.
 */
public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        final String[] data = intent.getStringArrayExtra("extraString[]");
        final int days = intent.getIntExtra("number", 0);
        TextView textView = (TextView) findViewById(R.id.title_fordetailtext);
        textView.setText(data[0]);

        Button button1 = (Button) findViewById(R.id.title_fordetailedit);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, SettingActivity.class);
                intent.putExtra("extraString[]", data);
                intent.putExtra("number", days);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.title_fordetailback);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
