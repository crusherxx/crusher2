package com.example.crusher2.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crusher2.R;
import com.example.crusher2.okhttp.Internet;
import com.example.crusher2.task.InternetTask;
import com.example.crusher2.task.XiaohuaTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.text2)
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);
        ButterKnife.bind (this);
        String result = new InternetTask ().getData ();
        text2.setText (result);
    }
}