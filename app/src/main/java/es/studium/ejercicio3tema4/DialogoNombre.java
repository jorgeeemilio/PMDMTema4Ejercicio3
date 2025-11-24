package es.studium.ejercicio3tema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

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
                .setPositiveButton(R.string.btnSiguiente, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onInterface.onNombreyApellidos(nombreyApellidos.getText().toString());
                        dialogoFechaNacimiento = new DialogoFechaNacimiento();
                        dialogoFechaNacimiento.setCancelable(false);
                        dialogoFechaNacimiento.show(getActivity().getSupportFragmentManager(), "");
                        dialog.dismiss();
                    }
                });
        return builder.create();
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
