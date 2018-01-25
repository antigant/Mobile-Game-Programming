package sidm.com.assignment1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class PauseConfirmDialogFrament extends DialogFragment
{
    public static boolean IsShown = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        // This is our duplicate guard (ensure there are no duplicates)
        IsShown = true;

        // We are going to use the builder class to create our very
        // nice confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Try not to use a constant string for builder.setMessage() (what if need to do translation work? eg Eng, Chi etc...)
        // Use a reference of a string instead
        builder.setMessage("Confirm Pause?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO - Trigger pause
                        GameSystem.Instance.SetIsPaused(!GameSystem.Instance.GetIsPaused());
                        IsShown = false;
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO - DON'T DO ANYTHING
                        GamePage.Instance.finish();
                        IsShown = false;
                    }
                })
        ;
        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dialog)
    {
        IsShown = false;
    }

    @Override
    public void onDismiss(DialogInterface dialog)
    {
        IsShown = false;
    }
}
