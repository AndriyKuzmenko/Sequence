package com.example.sequence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultsActivity extends AppCompatActivity
{
    ListView sequenceView;
    Intent gi;
    boolean type;
    double a1,d;
    double[] sequence,sums;
    String[] array;

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
