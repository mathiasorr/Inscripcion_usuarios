package com.example.inscripcion_usuarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etCedula, etNombres, etFechaNacimiento, etCiudad, etCorreo, etTelefono;
    private AutoCompleteTextView rgGenero;
    private Button btnLimpiar, btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etCedula = findViewById(R.id.txtcedula);
        etNombres = findViewById(R.id.txtnombre);
        etFechaNacimiento = findViewById(R.id.txtfnacimiento);
        etCiudad = findViewById(R.id.txtciudad);
        etCorreo = findViewById(R.id.txtcorreo);
        etTelefono = findViewById(R.id.txttelefono);
        rgGenero = findViewById(R.id.txtgenero);
        btnLimpiar = findViewById(R.id.bttncancelar);
        btnEnviar = findViewById(R.id.bttnguardar);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] datos = new String[]{"Femenino",
                "Masculino",
                "Otro",};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, datos);
        AutoCompleteTextView textView =
                findViewById(R.id.txtgenero);
        textView.setAdapter(adapter);
    }
    private void limpiarFormulario() {
        etCedula.setText("");
        etNombres.setText("");
        etFechaNacimiento.setText("");
        etCiudad.setText("");
        rgGenero.setText("");
        etCorreo.setText("");
        etTelefono.setText("");
    }

    private void enviarDatos() {
        String cedula = etCedula.getText().toString();
        String nombres = etNombres.getText().toString();
        String fechaNacimiento = etFechaNacimiento.getText().toString();
        String genero = rgGenero.getText().toString();
        String ciudad = etCiudad.getText().toString();
        String correo = etCorreo.getText().toString();
        String telefono = etTelefono.getText().toString();


        Intent intent = new Intent(MainActivity.this, Datos.class);
        intent.putExtra("CEDULA", cedula);
        intent.putExtra("NOMBRES", nombres);
        intent.putExtra("FECHA_NACIMIENTO", fechaNacimiento);
        intent.putExtra("CIUDAD", ciudad);
        intent.putExtra("GENERO", genero);
        intent.putExtra("CORREO", correo);
        intent.putExtra("TELEFONO", telefono);
        startActivity(intent);
    }
}