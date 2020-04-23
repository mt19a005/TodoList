package com.Taguwa.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }
}
