package com.example.buatcontoh;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdatafak = {"Teknik Informatika S1", "Sistem Informasi S1", "Desain Komunikasi Visual S1", "Manajemen Informatika D3", "Teknik Sipil S1"};
    EditText lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener((TextWatcher) this);
        ac.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
    }

    public void pilihfakultas (View v) { lv = (EditText)
            findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Fakultas Ilmu Komputer");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        }).show();
    }

    public void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi lagi pause  nih", LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);

        String lifeCycle = null;
        Log.i(lifeCycle, "onPause() called");
        // Ubah warna latar belakang LinearLayout
        linearLayout.setBackgroundColor(getResources().getColor(R.color.purple_200));
        AutoCompleteTextView dataautocomplete = findViewById(R.id.dataautocomplete);
        EditText datalistview = findViewById(R.id.datalistview);
        dataautocomplete.setText("POSISI LAGI PAUSE");
        dataautocomplete.setTextColor(getColor(R.color.black));
        datalistview.setText("POSISI LAGI PAUSE");
        datalistview.setTextColor(getColor(R.color.black));

    }


    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    public void afterTextChanged(Editable s) { }
}