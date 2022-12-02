package com.example.priklad7;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        stringList = new ArrayList<>();
        EditText editText = findViewById(R.id.editText);
        String str = editText.getText().toString();
        for(String st:str.split(" ")) {
            if(st.equals("")) {continue;}
            stringList.add(st);
        }
        if(stringList.size() == 0) {
            return;
        }
        switch (v.getId()) {
            case R.id.button: {
                Snackbar.make(v,btn1(stringList),Snackbar.LENGTH_LONG).show();
                break;
            }
            case R.id.button2: {
                Snackbar.make(v,btn2(stringList),Snackbar.LENGTH_LONG).show();
                break;
            }
            case R.id.button3: {
                Snackbar.make(v,btn3(stringList),Snackbar.LENGTH_LONG).show();
                break;
            }

        }
    }

    private String btn1(List<String> stringList) {

        Comparator<String> stringLengthComparator = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Collections.sort(stringList, stringLengthComparator);
        return stringList.get(stringList.size()-1);
    }
    private String btn2(List<String> stringList) {
        return String.valueOf(stringList.size());
    }

    private String btn3(List<String> stringList) {
        int s = 0;
        List<String> values = new ArrayList<>(Arrays.asList("a","e","i","o","u","y"));
        for(String str: stringList) {
            for(String st : str.split("(?!^)")) {
                if(values.contains(st)) {s++;}
            }
        }
        return String.valueOf(s);
    }
}