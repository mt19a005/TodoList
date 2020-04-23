package com.Taguwa.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MakeTodo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_todo);
        Intent intent = getIntent();
        String message = intent.getStringExtra("asd");

        EditText text = findViewById(R.id.inputText);
        text.setText(message);
        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = findViewById(R.id.inputText);

                Intent intent = new Intent();
                intent.putExtra("back", text.getText().toString());
//                intent.putExtra("back2", 1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
