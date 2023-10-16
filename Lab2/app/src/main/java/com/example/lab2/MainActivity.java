package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eduserinput;
    private TextView tvresult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.eduserinput = findViewById(R.id.eduserinput);
        this.tvresult = findViewById(R.id.tvresult);
        this.spinner = (Spinner) findViewById(R.id.spcountoption);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);
    }

    public void btncountclick(View view) {
        String selectedCountType = this.spinner.getSelectedItem().toString();
        String userinput = this.eduserinput.getText().toString();

        if (userinput.isEmpty()) {
            Toast.makeText(this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show();
        } else {
            int count = 0;
            if (selectedCountType.equals(getString(R.string.selection_words))) {
                count = WordCounter.getWordsCount(userinput);
            } else if (selectedCountType.equals(getString(R.string.selection_chars))) {
                count = WordCounter.getCharsCount(userinput);
            }

            this.tvresult.setText(String.valueOf(count));
        }
    }
}
