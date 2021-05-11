package exercise.find.roots;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivityR extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r);

        Intent intentCreatedMe = getIntent();
        TextView result = findViewById(R.id.result);

        long originalNum = savedInstanceState.getLong("original_number");
        long root1 = savedInstanceState.getLong("roo1");
        long root2 = savedInstanceState.getLong("root2");
        long timeUntilGiveUp = savedInstanceState.getLong("time_until_give_up_seconds");

        // set success UI:
        result.setText(originalNum + " = " + root1 + " * " + root2 + "  calculation duration: " + timeUntilGiveUp + " sec"); // cleanup text in edit-text
    }
}