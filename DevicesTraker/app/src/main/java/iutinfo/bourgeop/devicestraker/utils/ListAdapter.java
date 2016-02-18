package iutinfo.bourgeop.devicestraker.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import iutinfo.bourgeop.devicestraker.MainActivity;
import iutinfo.bourgeop.devicestraker.R;

public class ListAdapter extends BaseAdapter {

    String[] result;
    Context context;
    private Modele model;
    String[] students;
    private static LayoutInflater inflater = null;

    public ListAdapter(MainActivity mainActivity, String[] tablets, String[] students, Modele model) {
        // TODO Auto-generated constructor stub
        result = tablets;
        context = mainActivity;
        this.model = model;
        this.students = students;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView tv;
        //  ImageView img;
    }

    @Override
    public View getView(final int tabletPositon, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.item_list, null);
        holder.tv = (TextView) rowView.findViewById(R.id.terminal);
        holder.tv.setText(result[tabletPositon]);

        final Spinner studentSpinner = (Spinner) rowView.findViewById(R.id.spinner);
        ArrayAdapter adTerminal = ArrayAdapter.createFromResource(context, R.array.students,
                android.R.layout.simple_spinner_item);

        studentSpinner.setAdapter(adTerminal);


        //  holder.img.setImageResource(students[position]);
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int studentPosition, long id) {

                //selectedItemView.findViewById("");
                if(!model.setStudent(studentPosition, tabletPositon)){
                    Toast.makeText(context.getApplicationContext(), "Il semblerait que cette utilisateur ai déjà emprunté une tablette !", Toast.LENGTH_LONG).show();
                    studentSpinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        // set first position
        int p = model.getTerminal(tabletPositon);
        studentSpinner.setSelection(p);


        return rowView;
    }

}