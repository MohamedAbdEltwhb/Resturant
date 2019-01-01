package com.example.mm.resturant.view.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mm.resturant.R;
import com.example.mm.resturant.models.SQLiteHelper.UserTable.DataBaseHelper;

import static com.example.mm.resturant.view.activities.LoginActivity.EXTRA_EMILE;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEditTextEmile;
    private TextView mConfirmButton;

    private DataBaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initObjects();
        initViews();
        initListeners();
    }

    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId){
            case R.id.confirm_button:
                verifyFromSQLite();
                break;
        }

    }

    private void verifyFromSQLite() {
        String emile = mEditTextEmile.getText().toString().trim();

        if (emile.isEmpty()){
            Toast.makeText(this, "Please fill your email", Toast.LENGTH_LONG).show();
            return;

        }if(mDatabaseHelper.checkAndGetUser(emile)){
            Intent toConfirmPassword = new Intent(this, ConfirmPassword.class);
            toConfirmPassword.putExtra(EXTRA_EMILE, emile);
            emptyInputEditText();
            startActivity(toConfirmPassword);

        } else {
            Toast.makeText(this, "FFFF", Toast.LENGTH_SHORT).show();
        }

    }

    private void initObjects(){
        mDatabaseHelper = new DataBaseHelper(this);
    }

    private void initViews() {
        mEditTextEmile = findViewById(R.id.editTextEmail);
        mConfirmButton = findViewById(R.id.confirm_button);

    }

    private void initListeners(){
        mConfirmButton.setOnClickListener(this);
    }

    private void emptyInputEditText(){
        mEditTextEmile.setText(null);
    }
}
