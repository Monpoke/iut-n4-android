package fr.univ_lille1.iut_info.bourgeop.prems_empileur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected int amount = 0;
    private EditText tvAmount;
    private Button addBtn;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAmount = (EditText)findViewById(R.id.amount);
        addBtn = (Button)findViewById(R.id.add);
        result = (TextView)findViewById(R.id.result);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double t = Integer.parseInt(tvAmount.getText().toString());
                    amount += t;

                    result.setText(""+amount);
                    tvAmount.setText("");

                } catch(Exception e){
                    Toast.makeText(v.getContext(), "Sorry... Enter a good number!", Toast.LENGTH_LONG);
                }
            }
        });

    }
}
