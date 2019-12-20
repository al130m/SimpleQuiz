package com.example.simplequiz;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.simplequiz.R.id;
import com.example.simplequiz.R;


public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView( R.layout.activity_main );

        Button submitButton = findViewById( id.submitButton );

        submitButton.setOnClickListener( (OnClickListener) (new OnClickListener() {
            public final void onClick(View it) {
                int score = 0;
                String answer = "";
                RadioGroup answerGroup1 = (RadioGroup) findViewById(id.radioGroup);
                int selectedRadioId = answerGroup1.getCheckedRadioButtonId();

                if ( selectedRadioId != -1 ) {
                    RadioButton selectedRadioButton = findViewById( selectedRadioId );
                    answer = (String)selectedRadioButton.getText();
                }

                if ( answer.equals( "Sam Hill" ) ) {
                    score += 10;
                }

                /*
                 *
                 * Another question
                 *
                 */
                answerGroup1 = (RadioGroup) findViewById(id.radioQuestion_2);
                selectedRadioId = answerGroup1.getCheckedRadioButtonId();

                if ( selectedRadioId != -1 ) {
                    RadioButton selectedRadioButton = findViewById( selectedRadioId );
                    answer = (String)selectedRadioButton.getText();
                }

                if ( answer.equals( "Question_2_Answer_3" ) ) {
                    score += 10;
                }



                if ( score > 60 ) {
                    Toast.makeText( getApplicationContext(), "You passed! Your score {" + score + '}', Toast.LENGTH_SHORT ).show();
                }
                else {
                    Toast.makeText( getApplicationContext(), "You failed! Your score " + score, Toast.LENGTH_SHORT ).show();
                }

            }
        }));
    }
}
