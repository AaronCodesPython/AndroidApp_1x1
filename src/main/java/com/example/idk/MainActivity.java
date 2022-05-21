package com.example.idk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView1);
        final ArrayList<Integer> Numbers123 = new ArrayList<Integer>();


        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, Numbers123);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(" Number:", String.valueOf(Numbers123.get(i)));
            }
        });

        SeekBar NumberSlider = (SeekBar) findViewById(R.id.seekBar);
        int maxValue=100;

        NumberSlider.setMax(maxValue);
        NumberSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int ProgressValueChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ProgressValueChanged= i;
                Numbers123.clear();
                Numbers123.add((int) i*1);
                Numbers123.add((int) i*2);
                Numbers123.add((int) i*3);
                Numbers123.add((int) i*4);
                Numbers123.add((int) i*5);
                Numbers123.add((int) i*6);
                Numbers123.add((int) i*7);
                Numbers123.add((int) i*8);
                Numbers123.add((int) i*9);
                Numbers123.add((int) i*10);

                arrayAdapter.notifyDataSetChanged();



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}


