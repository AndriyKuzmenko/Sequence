package com.example.sequence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{
    ToggleButton typeToggleButton;
    TextView firstItem, difference;

    boolean type; //false=arithmetic  true=geometric

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeToggleButton=(ToggleButton)findViewById(R.id.typeToggleButton);
        firstItem=(TextView)findViewById(R.id.firstItem);
        difference=(TextView)findViewById(R.id.difference);

        type=false;
    }

    public void changeTypeOfProgression(View view)
    {
        type=typeToggleButton.isChecked();
        if (type)
        {
            firstItem.setText("b1=");
            difference.setText("q=");
        }
        else
        {
            firstItem.setText("a1=");
            difference.setText("d=");
        }
    }
}