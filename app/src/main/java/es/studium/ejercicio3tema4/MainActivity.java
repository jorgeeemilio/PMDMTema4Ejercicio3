package es.studium.ejercicio3tema4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements OnInterface, View.OnClickListener {

    DialogoNombre dialogoNombre;
    Button btnComenzar;
    TextView txtNombre, txtZodiaco, txtChino, txtEquipo;

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

        txtNombre = findViewById(R.id.txtNombre);
        txtZodiaco = findViewById(R.id.txtZodiaco);
        txtChino = findViewById(R.id.txtChino);
        txtEquipo = findViewById(R.id.txtEquipo);
    }

    @Override
    public void onClick(View v) {
        dialogoNombre = new DialogoNombre();
        dialogoNombre.setCancelable(false);
        dialogoNombre.show(getSupportFragmentManager(), "");
    }

    @Override
    public void onNombreyApellidos(String nombre) {
       txtNombre.setText(nombre);
    }

    @Override
    public void onFechaNacimiento(String fecha) {
        // Fecha viene en formato "dd/MM/yyyy"
    String[] parts = fecha.split("/");
    int day = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int year = Integer.parseInt(parts[2]);

    // Calcular signo zodiacal
    String zodiaco = "";
    if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
        zodiaco = "Aries";
    } else if ((month == 4 && day > 20) || (month == 5 && day < 20)) {
        zodiaco = "Tauro";
    } else if ((month == 5 && day >= 21) || (month == 6 && day < 20)) {
        zodiaco = "Géminis";
    } else if ((month == 6 && day >= 21) || (month == 7 && day < 22)) {
        zodiaco = "Cáncer";
    } else if ((month == 7 && day >= 23) || (month == 8 && day < 22)) {
        zodiaco = "Leo";
    } else if ((month == 8 && day >= 23) || (month == 9 && day < 22)) {
        zodiaco = "Virgo";
    } else if ((month == 9 && day >= 23) || (month == 10 && day < 22)) {
        zodiaco = "Libra";
    } else if ((month == 10 && day >= 23) || (month == 11 && day < 21)) {
        zodiaco = "Escorpio";
    } else if ((month == 11 && day >= 22) || (month == 12 && day < 21)) {
        zodiaco = "Sagitario";
    } else if ((month == 12 && day >= 22) || (month == 1 && day < 19)) {
        zodiaco = "Capricornio";
    } else if ((month == 1 && day >= 20) || (month == 2 && day < 18)) {
        zodiaco = "Acuario";
    } else if ((month == 2 && day >= 19) || (month == 3 && day < 20)) {
        zodiaco = "Piscis";
    }
    txtZodiaco.setText(zodiaco);

    // Calcular signo chino
    String[] chino = {"Mono", "Gallo", "Perro", "Cerdo", "Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Cabra"};
    txtChino.setText(chino[year % 12]);
    }

    @Override
    public void onCiudadNacimiento(String ciudad) {
        String equipo = "";
        switch (ciudad.toLowerCase()) {
            case "a coruña":
                equipo = "Deportivo de la Coruña";
                break;
            case "álava":
                equipo = "Deportivo Alavés";
                break;
            case "almería":
                equipo = "UD Almería";
                break;
            case "bilbao":
                equipo = "Athletic Club";
                break;
            case "barcelona":
                equipo = "FC Barcelona";
                break;
            case "cádiz":
                equipo = "Cádiz CF";
                break;
            case "getafe":
                equipo = "Getafe CF";
                break;
            case "girona":
                equipo = "Girona FC";
                break;
            case "granada":
                equipo = "Granada CF";
                break;
            case "las palmas":
                equipo = "UD Las Palmas";
                break;
            case "madrid":
                equipo = "Real Madrid CF";
                break;
            case "mallorca":
                equipo = "RCD Mallorca";
                break;
            case "pamplona":
                equipo = "CA Osasuna";
                break;
            case "sevilla":
                equipo = "Sevilla FC";
                break;
            case "san sebastián":
                equipo = "Real Sociedad";
                break;
            case "valencia":
                equipo = "Valencia CF";
                break;
            case "vigo":
                equipo = "RC Celta de Vigo";
                break;
            case "villareal":
                equipo = "Villarreal CF";
                break;
            default:
                equipo = "No hay un equipo de primera en tu ciudad";
                break;
        }
        txtEquipo.setText(equipo);
    }
}