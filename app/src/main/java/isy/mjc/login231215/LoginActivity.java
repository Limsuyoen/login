package isy.mjc.login231215;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    EditText editemail, editpasswd;
    TextView txtsignup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin = findViewById(R.id.btnlogin);
        editemail = findViewById(R.id.editemail);
        editpasswd = findViewById(R.id.editpasswd);
        txtsignup = findViewById(R.id.txtsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editemail.getText().toString();
                String passwd = editpasswd.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                if (id.equals("") && passwd.equals("")) {
                    Toast.makeText(LoginActivity.this, "올바르게 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (id.equals("") || passwd.equals("")) {
                    Toast.makeText(LoginActivity.this, "올바르게 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("id", id);
                    intent.putExtra("passwd", passwd);
                    startActivity(intent);
                }
            }
        });

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


    }
}