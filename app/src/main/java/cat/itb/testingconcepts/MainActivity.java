package cat.itb.testingconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    Button button;

    EditText usernameEditText;
    EditText passwordEditText;

    boolean activated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.titleTextView);
        button = findViewById(R.id.mainButton);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        activated = true;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString(), password = passwordEditText.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    button.setText(R.string.logged);
                    Intent i = new Intent(MainActivity.this, WelcomeBackActivity.class);
                    i.putExtra("username", username);
                    startActivity(i);
                } else {
                    button.setText(R.string.next);
                    activated = true;
                }
            }
        });
    }


}