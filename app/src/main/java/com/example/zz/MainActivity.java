package com.example.zz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Integer counter = 0;
    public static final String TAG = "StartActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            counter = savedInstanceState.getInt("count");
        }
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnAddDog(View view) {
        counter++;
        TextView counterView = (TextView)findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
    }
    @Override
    protected void onStart() {
        super.onStart();
        resetUI();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", counter);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            counter = savedInstanceState.getInt("count");
        }
    }
    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());

    }


}
