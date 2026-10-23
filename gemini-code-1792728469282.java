package com.example.autoshorts;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText urlInput;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 32, 24, 24);
        layout.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("AI Auto Shorts");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(20, 130, 70));
        layout.addView(title);

        TextView description = new TextView(this);
        description.setText("Enter a video URL to prepare your clipping job.");
        description.setTextSize(16);
        layout.addView(description);

        urlInput = new EditText(this);
        urlInput.setHint("Paste an authorized video URL");
        urlInput.setSingleLine(true);
        layout.addView(urlInput);

        Button button = new Button(this);
        button.setText("Prepare Video");
        layout.addView(button);

        status = new TextView(this);
        status.setText("Ready");
        status.setTextSize(16);
        layout.addView(status);

        button.setOnClickListener(v -> {
            String url = urlInput.getText().toString().trim();

            if (url.isEmpty()) {
                status.setText("Please enter a video URL.");
            } else if (!url.startsWith("https://")) {
                status.setText("Please enter a valid HTTPS URL.");
            } else {
                status.setText(
                    "URL received. Connect a video-processing " +
                    "backend to generate clips."
                );
            }
        });

        setContentView(layout);
    }
}