package com.pandeyrahul.lawleaks.DATA;

import android.content.Intent;
import com.pandeyrahul.lawleaks.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText queryInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI elements
        Button ipcLawsButton = findViewById(R.id.ipcLawsButton);
        Button publicRecordsButton = findViewById(R.id.publicRecordsButton);
        Button signInButton = findViewById(R.id.signInButton);
        Button askButton = findViewById(R.id.askButton);
        queryInput = findViewById(R.id.queryInput);

        // Button Click Listeners
        ipcLawsButton.setOnClickListener(v -> openIpcLawsPage());
        publicRecordsButton.setOnClickListener(v -> openPublicRecordsPage());
        signInButton.setOnClickListener(v -> openSignInPage());
        askButton.setOnClickListener(v -> searchAI());
    }

    private void openIpcLawsPage() {
        Intent intent = new Intent(this, IPCLawsActivity.class);
        startActivity(intent);
    }

    private void openPublicRecordsPage() {
        Toast.makeText(this, "Opening Public Records...", Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(this, PublicRecordsActivity.class);
        // startActivity(intent);
    }

    private void openSignInPage() {
        Toast.makeText(this, "Redirecting to Sign In...", Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(this, SignInActivity.class);
        // startActivity(intent);
    }

    private void searchAI() {
        String query = queryInput.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a query.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Searching: " + query, Toast.LENGTH_SHORT).show();
            // Future: Send query to AI for response
        }
    }
}