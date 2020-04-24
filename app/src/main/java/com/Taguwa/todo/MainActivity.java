package com.Taguwa.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList data = new ArrayList<>();
    static final int requestCodeMakeTodo = 1;
    Button button;

    @Override
    //アクティビティが生成されたとき
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.newButton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(MainActivity.this, MakeTodo.class);
//
//                intent.putExtra("asd", "aho");
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
                    String returnFromMakeTodo = data.getStringExtra("back");
//                    String name2 = data.getStringExtra("back2");
                    Log.d("hoge", returnFromMakeTodo);
                    AddListView(returnFromMakeTodo);
//                    Log.d("hoge", name2);
                }
                break;
        }
    }

    void AddListView(String  returnFromMakeTodo){
        data.add(returnFromMakeTodo);

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.memoList);
        listView.setAdapter(adapter);
    }
}