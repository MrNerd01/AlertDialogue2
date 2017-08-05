package com.example.swarathesh60.alertdialogue;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button);
         final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("hello");
        alert.setMessage("world");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.create();
        alert.show();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("dialogue list ");
                final CharSequence[] sequence = new CharSequence[]{"idli","vada","sambar"};
                final List<String> simple = new ArrayList<String>();
                alert.setMultiChoiceItems(sequence, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            simple.add(sequence[i].toString());
                        }else if (simple.contains(sequence[i].toString())){
                            simple.remove(sequence[i].toString());
                        }

                    }
                });
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int j = 0; i < simple.size(); j++) {
                            StringBuilder stringBuilder  = new StringBuilder();
                            stringBuilder.append(simple.get(j).toString());
                        }


                    }
                });
                alert.create();
                alert.show();
            }
        });
    }
}
