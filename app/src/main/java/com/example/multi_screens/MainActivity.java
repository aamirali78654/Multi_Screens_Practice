package com.example.multi_screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.order_menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void orderNow(View view)
    {
        Intent intent = new Intent(this,OrderActivity.class);
        EditText edittext = findViewById(R.id.editText);
        EditText edittext2 = findViewById(R.id.editText2);
        EditText edittext3 = findViewById(R.id.editTextText3);
        String message = edittext.getText().toString()+" , "+
                edittext2.getText().toString()+" & "+
                edittext3.getText().toString();
        intent.putExtra(MSG,message);
        startActivity(intent);
    }
}