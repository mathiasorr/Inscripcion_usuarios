package com.example.inscripcion_usuarios;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Datos extends AppCompatActivity {

    private TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_datos);

        tvDatos = findViewById(R.id.tvDatos);

        String cedula = getIntent().getStringExtra("CEDULA");
        String nombres = getIntent().getStringExtra("NOMBRES");
        String fechaNacimiento = getIntent().getStringExtra("FECHA_NACIMIENTO");
        String ciudad = getIntent().getStringExtra("CIUDAD");
        String genero = getIntent().getStringExtra("GENERO");
        String correo = getIntent().getStringExtra("CORREO");
        String telefono = getIntent().getStringExtra("TELEFONO");

        String datos = "Cédula: " + cedula + "\n" +
                "Nombres: " + nombres + "\n" +
                "Fecha Nacimiento: " + fechaNacimiento + "\n" +
                "Ciudad: " + ciudad + "\n" +
                "Género: " + genero + "\n" +
                "Correo: " + correo + "\n" +
                "Teléfono: " + telefono;

        tvDatos.setText(datos);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}