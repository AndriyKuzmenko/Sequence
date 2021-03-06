package com.example.sequence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    ListView sequenceView;
    Intent gi;
    boolean type;
    double a1,d, currentItem, previousItem;
    double[] sums;
    String[] sequence;
    TextView a1Label, dLabel;
    EditText a1View, dView, nView, SnView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        sums=new double[20];
        sequence=new String[20];

        sequenceView=(ListView)findViewById(R.id.sequenceView);
        gi=getIntent();
        type=gi.getBooleanExtra("type",false);
        a1=gi.getDoubleExtra("a1",0);
        d=gi.getDoubleExtra("d",0);
        a1Label=(TextView)findViewById(R.id.a1Label);
        dLabel=(TextView)findViewById(R.id.dLabel);
        a1View=(EditText)findViewById(R.id.a1View);
        dView=(EditText)findViewById(R.id.dView);
        nView=(EditText)findViewById(R.id.nView);
        SnView=(EditText)findViewById(R.id.SnView);
        a1View.setText(String.valueOf(a1));
        dView.setText(String.valueOf(d));

        sequenceView.setOnItemClickListener(this);
        sequenceView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        if (!type) arithmetic();
        else geometric();

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, sequence);
        sequenceView.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        nView.setText(String.valueOf(position+1));
        SnView.setText(String.valueOf(sums[position]));
    }

    public void arithmetic()
    {
        currentItem=a1;
        sums[0]=a1;
        sequence[0]=currentItem+"";

        for (int i=1; i<20; i++)
        {
            previousItem=currentItem;
            currentItem=previousItem+d;
            sums[i]=sums[i-1]+currentItem;
            sequence[i]=currentItem+"";
        }
    }

    public void geometric()
    {
        a1Label.setText("b1=");
        dLabel.setText("q=");

        currentItem=a1;
        sums[0]=a1;
        sequence[0]=currentItem+"";

        for (int i=1; i<20; i++)
        {
            previousItem=currentItem;
            currentItem=previousItem*d;
            sums[i]=sums[i-1]+currentItem;
            sequence[i]=currentItem+"";
        }
    }
}