package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    Spinner spnYesNo;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);
        final ArrayList<String> alNumbers;
        final ArrayAdapter<String> aaNumbers;

        alNumbers = new ArrayList<>();
        final String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        final String[] strNumbersOdd = getResources().getStringArray(R.array.odd_numbers);
        alNumbers.addAll(Arrays.asList(strNumbers));
        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn2.setAdapter(aaNumbers);

        /*btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if(pos == 0){
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setAdapter(aaNumbers);
                }
                else if(pos == 1){
                    alNumbers.addAll(Arrays.asList(strNumbersOdd));
                    spn2.setAdapter(aaNumbers);
                }
            }
        });
        */
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbersOdd));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
