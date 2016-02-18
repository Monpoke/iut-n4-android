package iutinfo.bourgeop.democycle;

import android.content.Intent;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected int valeur = 1;
    private EditText numb;
    private Button btn;
    private TextView tvCumul;
    private TextView tvInserse;
    private Button btnAppel;


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("valeur", valeur);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        valeur = savedInstanceState.getInt("valeur");
        refreshData();
    }


    protected void refreshData() {
        tvInserse.setText("" + (1.0 / valeur));
        tvCumul.setText("" + (valeur));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        numb = (EditText) findViewById(R.id.number);
        btn = (Button) findViewById(R.id.go);

        tvCumul = (TextView) findViewById(R.id.cumul);
        tvInserse = (TextView) findViewById(R.id.inverse);
        btnAppel = (Button) findViewById(R.id.appel);

        btnAppel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(contactPickerIntent, 1001);
            }
        });
    }


    public void doGo(View view) {
        // add value
        double num = Integer.parseInt(numb.getText().toString());
        valeur += num;

        refreshData();
    }
}
