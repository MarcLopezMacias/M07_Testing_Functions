package cat.itb.testingconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeBackActivity extends AppCompatActivity {

    TextView titleTextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        Intent i = getIntent();
        String username = i.getStringExtra("username");

        titleTextView = findViewById(R.id.welcomeBackTextView);
        titleTextView.setText("Welcome Back" + " " + username);

        button = findViewById(R.id.welcomeButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeBackActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}