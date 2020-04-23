package com.Taguwa.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int RESULT_SUBACTIVITY = 1000;


    @Override
    //アクティビティが生成されたとき
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.newButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(MainActivity.this, MakeTodo.class);

                intent.putExtra("asd", "aho");
                startActivityForResult(intent, RESULT_SUBACTIVITY);
            }
        });
    }
}