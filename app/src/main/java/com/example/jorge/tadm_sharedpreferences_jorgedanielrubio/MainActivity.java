package com.example.jorge.tadm_sharedpreferences_jorgedanielrubio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtCorreo;
    RadioButton rMale, rFemale;
    CheckBox cbCoding, cbWriting, cbJogging;
    Spinner Zodiac;
    Button btnSave, btnGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtCorreo = findViewById(R.id.editText);
        rMale = findViewById(R.id.radioButton);
        rFemale = findViewById(R.id.radioButton2);
        cbCoding = findViewById(R.id.checkBox);
        cbWriting = findViewById(R.id.checkBox2);
        cbJogging = findViewById(R.id.checkBox3);
        Zodiac = findViewById(R.id.spinner);
        btnSave = findViewById(R.id.button);
        btnGet = findViewById(R.id.button2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMe();
            }
        });

    }

    private void Save(){
        SharedPreferences.Editor editar = getPreferences(MODE_PRIVATE).edit();
        editar.putString("",txtCorreo.getText().toString());
        editar.putBoolean("",rMale.isChecked());
        editar.putBoolean("",rFemale.isChecked());
        editar.putBoolean("",cbCoding.isChecked());
        editar.putBoolean("",cbWriting.isChecked());
        editar.putBoolean("",cbJogging.isChecked());
        editar.putInt("",Zodiac.getSelectedItemPosition());
        editar.commit();
        Toast.makeText(this,"SAVED",Toast.LENGTH_SHORT).show();

    }

    private void getMe(){

        String email="";
        Boolean rbM,rbF,chekboxCo,chekboxWr,chekboxJo;
        int signos;

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        email  = sharedPreferences.getString("Correo",null);
        rbM = sharedPreferences.getBoolean("Male",false);
        rbF = sharedPreferences.getBoolean("Female",false);
        chekboxCo = sharedPreferences.getBoolean("Coding",false);
        chekboxJo = sharedPreferences.getBoolean("Jogging",false);
        chekboxWr = sharedPreferences.getBoolean("Writing",false);
        signos  = sharedPreferences.getInt("",0);

        txtCorreo.setText(email);
        rMale.setChecked(rbM);
        rFemale.setChecked(rbF);
        this.cbCoding.setChecked(chekboxCo);
        this.cbWriting.setChecked(chekboxWr);
        this.cbJogging.setChecked(chekboxJo);
        Zodiac.setSelection(signos);

        Toast.makeText(this,"Get Me",Toast.LENGTH_SHORT).show();

    }
}
