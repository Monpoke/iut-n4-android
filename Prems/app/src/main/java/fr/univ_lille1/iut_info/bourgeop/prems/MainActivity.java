package fr.univ_lille1.iut_info.bourgeop.prems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;
    private Button btnOk;
    private Button btnReset;
    private EditText tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        tvText = (TextView)findViewById(R.id.message);
        btnOk = (Button)findViewById(R.id.button);
        btnReset = (Button)findViewById(R.id.reset);
        tvName = (EditText)findViewById(R.id.name);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOk(v);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doReset(v);
            }
        });

    }

    private void doReset(View v) {
        tvText.setText("Bienvenue !" );
        tvText.setTextColor(getResources().getColor(R.color.red));
        tvName.setText("");
    }

    /**
     * Check messages.
     * @param view
     */
    public void doOk(View view){
        tvText.setText("Bienvenue " + tvName.getText() + " !");
        tvText.setTextColor(getResources().getColor(R.color.blue));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
