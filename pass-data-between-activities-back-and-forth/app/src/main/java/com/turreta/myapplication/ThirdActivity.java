package com.turreta.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

public class ThirdActivity extends AppCompatActivity {

    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);


        Bundle extras = getIntent().getExtras();

        if(extras!=null)
        {
            String code1 = extras.getString("code1");
            Toast.makeText(this, code1, Toast.LENGTH_LONG).show();

        }

        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent returnIntent = new Intent();
                returnIntent.putExtra("code2", "value");
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });
    }
}