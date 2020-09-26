package com.example.sequence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity
{
    ListView sequenceView;
    Intent gi;
    boolean type;
    double a1,d;
    double[] sequence,sums;
    String[] array;
    TextView a1Label, dLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        sequence=new double[20];
        sums=new double[20];
        array=new String[20];

        sequenceView=(ListView)findViewById(R.id.sequenceView);
        gi=getIntent();
        type=gi.getBooleanExtra("type",false);
        a1=gi.getDoubleExtra("a1",0);
        d=gi.getDoubleExtra("d",0);
        a1Label=(TextView)findViewById(R.id.a1Label);
        dLabel=(TextView)findViewById(R.id.dLabel);

        if (!type) arithmetic();
        else geometric();

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, array);
        sequenceView.setAdapter(adp);
    }

    public void arithmetic()
    {
        sequence[0]=a1;
        array[0]=sequence[0]+"";

        for (int i=1; i<20; i++)
        {
            sequence[i]=sequence[i-1]+d;
            sums[i]=sums[i-1]+sequence[i];
            array[i]=sequence[i]+"";
        }
    }

    public void geometric()
    {
        a1Label.setText("b1=");
        dLabel.setText("q=");

        sequence[0]=a1;
        sums[0]=a1;
        array[0]=sequence[0]+"";

        for (int i=1; i<20; i++)
        {
            sequence[i]=sequence[i-1]*d;
            sums[i]=sums[i-1]+sequence[i];
            array[i]=sequence[i]+"";
        }
    }
}
