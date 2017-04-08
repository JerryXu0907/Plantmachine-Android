package com.example.jerry.application11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.CompoundButton;

/**
 * Created by jerry on 16/4/7.
 */
public class SettingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox_forsetting);
        Intent intent = getIntent();
        final String[] data = intent.getStringArrayExtra("extraString[]");
        final int days = intent.getIntExtra("number", 0);

        final Button button1 = (Button) findViewById(R.id.button_setting);
        final Button button2 = (Button) findViewById(R.id.button2_setting);
        final Button button3 = (Button) findViewById(R.id.button3_setting);
        Resources resource=(Resources)getBaseContext().getResources();
        final ColorStateList csl=(ColorStateList) resource.getColorStateList(R.color.button_color);
        button1.setTextColor(csl);
        button2.setTextColor(csl);
        button3.setTextColor(csl);

        Button buttonback = (Button) findViewById(R.id.title_forsettingback);
        buttonback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,DetailActivity.class);
                intent.putExtra("extraString[]",data);
                intent.putExtra("number",days);
                startActivity(intent);
                finish();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button1.setTextColor(csl);
                    button2.setTextColor(csl);
                    button3.setTextColor(csl);
                } else {
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button1.setTextColor(csl);
                    button2.setTextColor(csl);
                    button3.setTextColor(csl);
                }
            }
        });



    }
}