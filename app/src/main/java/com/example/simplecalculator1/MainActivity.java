package com.example.simplecalculator1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onBtnClicked(View view) {
        EditText et1 = findViewById(R.id.num1);
        EditText et2 = findViewById(R.id.num2);
        TextView tvRes = findViewById(R.id.tvResult);

        String et1Text = et1.getText().toString();
        String et2Text = et2.getText().toString();

        if (et1Text.isEmpty() || et2Text.isEmpty()) {
            tvRes.setText("Error");
            return;
        }

        int num1 = Integer.parseInt(et1Text);
        int num2 = Integer.parseInt(et2Text);
        Integer result = null;

        if (view.getId() == R.id.btnPlus) {
            result = num1 + num2;
        } else if (view.getId() == R.id.btnMinus) {
            result = num1 - num2;
        } else if (view.getId() == R.id.btnMult) {
            result = num1 * num2;
        } else if (view.getId() == R.id.btnDiv) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                tvRes.setText("Div by 0");
                return;
            }
        }

        if (result != null) {
            tvRes.setText(result.toString());
        }
    }
}
