package es.studium.ejercicio3tema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment {

    DialogoFechaNacimiento dialogoFechaNacimiento;
    OnInterface onInterface;
    EditText nombreyApellidos;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_nombre, null);
        nombreyApellidos = myView.findViewById(R.id.editTextText);
        builder.setView(myView)
            .setTitle(R.string.tituloDialogoNombre)
                .setPositiveButton(R.string.btnSiguiente, null) // Cambiar comportamiento por defecto
                .setNegativeButton(R.string.btnCancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (nombreyApellidos.getText().toString().isEmpty())
                {
                    nombreyApellidos.setError(getString(R.string.errorNombre));
                    nombreyApellidos.requestFocus();
                }
                else
                {
                    onInterface.onNombreyApellidos(nombreyApellidos.getText().toString());
                    dialogoFechaNacimiento = new DialogoFechaNacimiento();
                    dialogoFechaNacimiento.setCancelable(false);
                    dialogoFechaNacimiento.show(getActivity().getSupportFragmentManager(), "");
                }
            }
        });
        return dialog;
    }

    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        try {
            onInterface = (OnInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnInterface");
        }
    }
}
