package iutinfo.bourgeop.devicestraker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import iutinfo.bourgeop.devicestraker.utils.ListAdapter;
import iutinfo.bourgeop.devicestraker.utils.Modele;

public class MainActivity extends AppCompatActivity {


    private Modele model;
    private String[] students;
    private String[] tablets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = getResources().getStringArray(R.array.students);
        tablets =  getResources().getStringArray(R.array.tablets);
        this.model = new Modele(tablets, students, savedInstanceState);

        ListView lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(new ListAdapter(this, tablets,students, model));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        model.save(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        model=new Modele(tablets,students,savedInstanceState);
    }
}
