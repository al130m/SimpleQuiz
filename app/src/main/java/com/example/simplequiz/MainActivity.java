package com.example.simplequiz;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.simplequiz.R.id;
import com.example.simplequiz.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView( R.layout.activity_main );

        Button submitButton = findViewById( id.submitButton );

        // When the submit button is clicked, fire setOnClickListener function
        submitButton.setOnClickListener( ( OnClickListener ) ( new OnClickListener() {

            public final void onClick(View it) {
                // Configuration
                float finalScore = 0.0f;
                float minimumScore = 0.5f;
                int numberOfQuestions = 3;

                // Variables
                int points = 0;
                int selectedRadioId;
                int multipleChoiceValidation = 0;

                DecimalFormat percentage = new DecimalFormat("##%" );

                String answer = "";
                String test_status_msg;
                RadioGroup answerGroup;
                TextView textViewTestStatus;


                answerGroup = (RadioGroup) findViewById(id.radioQuestion_1);

                if ( answerGroup != null ) {

                    for (int i = 0; i < answerGroup.getChildCount(); i++) {
                        CheckBox checkbox = (CheckBox) answerGroup.getChildAt( i );

                        if ( checkbox.isChecked() ) {

                            switch ( (String) checkbox.getText() ) {

                                case "Greg Minaar":
                                    multipleChoiceValidation += 1;
                                    break;

                                case "Steve Peat":
                                    multipleChoiceValidation += 3;
                                    break;

                                case "Brett Rheeder":
                                    multipleChoiceValidation += 5;
                                    break;

                                case "Martin Maes":
                                    multipleChoiceValidation += 7;
                                    break;
                            }

                        }
                    }
                }

                if ( multipleChoiceValidation == 11 ) {
                    points += 1;
                }



                /*
                 *
                 * Another question
                 *
                 */
                answerGroup = (RadioGroup) findViewById(id.radioQuestion_2);
                selectedRadioId = answerGroup.getCheckedRadioButtonId();

                if ( selectedRadioId != -1 ) {
                    RadioButton selectedRadioButton = findViewById( selectedRadioId );
                    answer = (String)selectedRadioButton.getText();
                }

                if ( answer.equals( "Sam Hill" ) ) {
                    points += 1;
                }



                /*
                 *
                 * Boolean question
                 *
                 */
                answerGroup = (RadioGroup) findViewById( id.radioQuestion3 );
                selectedRadioId = answerGroup.getCheckedRadioButtonId();

                if ( selectedRadioId != -1 ) {
                    RadioButton selectedRadioButton = findViewById( selectedRadioId );
                    answer = (String)selectedRadioButton.getText();
                }

                if ( answer.equals( "True" ) ) {
                    points += 1;
                }

                finalScore = (float) points / numberOfQuestions;

                if ( finalScore  > minimumScore ) {
                    test_status_msg = "You passed! Your score " + percentage.format( finalScore );
                    Toast.makeText( getApplicationContext(), test_status_msg, Toast.LENGTH_SHORT ).show();
                    textViewTestStatus = (TextView) findViewById( id.textViewTestStatus );
                    textViewTestStatus.setText( test_status_msg );
                }
                else {
                    test_status_msg = "You failed! Your score " + percentage.format( finalScore );
                    Toast.makeText( getApplicationContext(), test_status_msg, Toast.LENGTH_SHORT ).show();
                    textViewTestStatus = (TextView) findViewById( id.textViewTestStatus );
                    textViewTestStatus.setText( test_status_msg );
                }

            }
        }));
    }
}