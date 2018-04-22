package com.example.android.omegamusicquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int TotalPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SubmitAnswers(View view) {
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        RadioButton no1RadioButton = findViewById(R.id.no1);
        boolean No1isChecked = no1RadioButton.isChecked();
        RadioButton yes2RadioButton = findViewById(R.id.yes2);
        boolean Yes2isChecked = yes2RadioButton.isChecked();
        RadioButton a3RadioButton = findViewById(R.id.A3);
        boolean A3isChecked = a3RadioButton.isChecked();
        RadioButton a4RadioButton = findViewById(R.id.A4);
        boolean A4isChecked = a4RadioButton.isChecked();
        CheckBox five3Checkbox = findViewById(R.id.checkboxFive_3);
        boolean Five3isChecked = five3Checkbox.isChecked();
        CheckBox five4Checkbox = findViewById(R.id.checkboxFive_4);
        boolean Five4isChecked = five4Checkbox.isChecked();

        //calculate the score
        int TotalPoints = calculatePoints(No1isChecked, Yes2isChecked, A3isChecked, A4isChecked, Five3isChecked, Five4isChecked);
        String PointsMessage = createPointsMessage(name, TotalPoints);
        displayPointsMessage(PointsMessage);
    }

    /**
     * Create points message
     * @param name        of the user.
     * @param TotalPoints of the user.
     * @return PointsMessage.
     */
    private String createPointsMessage(String name, int TotalPoints) {
        String PointsMessage = name;
        PointsMessage = PointsMessage + " your points are " + TotalPoints + "\n out of 100";
        return PointsMessage;
    }

    /**
     * Calculates the points of the user.
     *
     * @param No1isChecked   which is right.
     * @param Yes2isChecked  which is right.
     * @param A3isChecked    which is right.
     * @param A4isChecked    which is right.
     * @param Five3isChecked which is right.
     * @param Five4isChecked which is right.
     * @return total points
     */
    private int calculatePoints(boolean No1isChecked, boolean Yes2isChecked, boolean A3isChecked, boolean A4isChecked, boolean Five3isChecked, boolean Five4isChecked) {

        if (No1isChecked) {
            TotalPoints += 20;
        }
        if (Yes2isChecked) {
            TotalPoints += 20;
        }
        if (A3isChecked) {
            TotalPoints += 20;
        }
        if (A4isChecked) {
            TotalPoints += 20;
        }
        if (Five3isChecked) {
            TotalPoints += 10;
        }
        if (Five4isChecked) {
            TotalPoints += 10;
        }

        return TotalPoints;
    }

    private void displayPointsMessage(String PointsMessage) {

        TextView pointsTextView = findViewById(R.id.points_text_view);
        pointsTextView.setText(String.valueOf(PointsMessage));
        if (TotalPoints == 100){
            Toast.makeText(this,getString(R.string.PointsMessage) + " You are going to be a great musician!", Toast.LENGTH_LONG).show();

        } else if (TotalPoints>=80) {
            Toast.makeText(this,getString(R.string.PointsMessage) + " You are good!", Toast.LENGTH_LONG).show();

        } else if (TotalPoints>=60){
            Toast.makeText(this,getString(R.string.PointsMessage) + " You need to try harder!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this,getString(R.string.PointsMessage)+ " Try in another field!", Toast.LENGTH_LONG).show();
        }

    }

}








