package exercise.find.roots;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivityR extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r);

        Intent intent = getIntent();

        TextView result = findViewById(R.id.result);

        String originalNum = String.valueOf(intent.getLongExtra("original_number", 0));
        String root1 = String.valueOf(intent.getLongExtra("roo1", 0));
        String root2 = String.valueOf(intent.getLongExtra("root2", 0));
        String timeUntilGiveUp = String.valueOf(intent.getLongExtra("time_until_give_up_seconds", 0));

        System.out.println(root1);
        System.out.println(root2);
        System.out.println(timeUntilGiveUp);

        // set success UI:
        result.setText(originalNum + " = " + root1 + " * " + root2 + "  calculation duration: " + timeUntilGiveUp + " sec"); // cleanup text in edit-text
    }
}