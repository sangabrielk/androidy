package com.turreta.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Button button;

    public static class MyEvent1 implements Serializable {
        private int code;
        private String from;
        private String data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public MyEvent1(int code, String from, String data) {
            this.code = code;
            this.from = from;
            this.data = data;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i= new Intent(v.getContext(), SecondActivity.class);
//                i.putExtra("code1","This is a public service annoucement");
//                startActivity(i);

                EventBus.getDefault().post(new MainActivity.MyEvent1(1, "SecondActivity", "You win!"));

            }
        });

    }

    @Subscribe(priority = 1, threadMode = ThreadMode.MAIN)
    public void onMyEvent1(MyEvent1 event) {
        TextView tv = (TextView) findViewById(R.id.txt);
        tv.setText(event.getData());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}