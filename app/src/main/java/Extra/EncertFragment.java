package Extra;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import joandev.waterquest.R;
import joandev.waterquest.Views.AcercameActivity;

public class EncertFragment extends android.app.DialogFragment {

    @Override
    public void onDestroy() {
        getActivity().finish();
        super.onDestroy();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getResources().getString(R.string.pregunta_encertada))
                .setPositiveButton(getResources().getString(R.string.Continuar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getActivity(), AcercameActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
        return builder.create();
    }
    
}