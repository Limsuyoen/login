package isy.mjc.login231215;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$");

    private FirebaseAuth firebaseAuth;
    Button btnsignup;
    EditText editname, editemail, editpasswd, editcheckpasswd;

    String name = "", id = "", passwd = "", check = "";
    TextView txtsignin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        btnsignup = findViewById(R.id.btnsignup);
        editname = findViewById(R.id.editname);
        editemail = findViewById(R.id.editemail);
        editpasswd = findViewById(R.id.editpasswd);
        editcheckpasswd = findViewById(R.id.editcheckpasswd);
        txtsignin = findViewById(R.id.txtsignin);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editname.getText().toString();
                id = editemail.getText().toString();
                passwd = editpasswd.getText().toString();
                check = editcheckpasswd.getText().toString();

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                if (name.equals("") && id.equals("") && passwd.equals("") && check.equals("")) {
                    Toast.makeText(SignupActivity.this, "올바르게 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (name.equals("") || id.equals("") || passwd.equals("") || check.equals("")) {
                    Toast.makeText(SignupActivity.this, "올바르게 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    editname.setText("");
                    editemail.setText("");
                    editpasswd.setText("");
                    editcheckpasswd.setText("");
                    startActivity(intent);
                }
            }
        });
        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editname.setText("");
                editemail.setText("");
                editpasswd.setText("");
                editcheckpasswd.setText("");
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });



    }
}