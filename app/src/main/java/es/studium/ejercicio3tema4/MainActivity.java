package es.studium.ejercicio3tema4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements OnInterface, View.OnClickListener {

    DialogoNombre dialogoNombre;
    Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnComenzar = findViewById(R.id.btnComenzar);
        btnComenzar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dialogoNombre = new DialogoNombre();
        dialogoNombre.setCancelable(false);
        dialogoNombre.show(getSupportFragmentManager(), "");
    }

    @Override
    public void onNombreyApellidos(String nombre) {
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFechaNacimiento(String fecha) {

    }

    @Override
    public void onCiudadNacimiento(String ciudad) {

    }
}