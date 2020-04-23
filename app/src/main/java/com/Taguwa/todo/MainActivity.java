package com.Taguwa.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int requestCodeMakeTodo = 1;


    @Override
    //アクティビティが生成されたとき
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.newButton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeTodo.class);

                intent.putExtra("asd", "aho");
                startActivityForResult(intent, requestCodeMakeTodo);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case requestCodeMakeTodo:
                if (RESULT_OK == resultCode) {
                    String name = data.getStringExtra("back");
//                    String name2 = data.getStringExtra("back2");
                    Log.d("hoge", "result Yes");
                    Log.d("hoge", name);
//                    Log.d("hoge", name2);


                }
                Log.d("hoge", "result No");
                break;
        }
    }
}