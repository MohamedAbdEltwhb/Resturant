package com.example.mm.resturant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mm.resturant.R;
import com.example.mm.resturant.Util.InputValidation;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Regular;
import com.example.mm.resturant.models.SQLiteHelper.DataBaseHelper;
import com.example.mm.resturant.models.data.UserInfo;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private MyTextView_Roboto_Regular mSignUpButton;
    private EditText mFirstName, mLastName,mPassword, mRe_password, mEmail, mPhoneN;

    private InputValidation mInputValidation;
    private DataBaseHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initObjects();
        initViews();
        initListeners();
    }

    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId) {
            case R.id.sign_Un_button:
                connectAndStoreData();
                break;

        }

    }

    public void connectAndStoreData(){

        if (!mInputValidation.isValidName(mFirstName)){
            mFirstName.setError("Please Enter Correct Name..");
            return;
        }else if (!mInputValidation.isValidName(mLastName)){
            mLastName.setError("Please Enter Correct Name..");
            return;
        }else if (!mInputValidation.isValidPassword(mPassword)){
            mPassword.setError("Please Enter Strong Password..");
            return;
        }else if (!mInputValidation.isValidRePassword(mRe_password, mPassword)){
            mRe_password.setError("Re Password Is not equal Password..");
            return;
        }else if (!mInputValidation.isValidMail(mEmail)){
            mEmail.setError("Please Enter Correct Email..");
            return;
        }else if (!mInputValidation.isValidMobile(mPhoneN)){
            mPhoneN.setError("Please Enter Correct mobile number..");
            return;
        }else {

            String _mFirstName = mFirstName.getText().toString().trim();
            String _mLastName = mLastName.getText().toString().trim();
            String _mPassword = mPassword.getText().toString().trim();
            String _mRe_password = mRe_password.getText().toString().trim();
            String _mEmail = mEmail.getText().toString().trim();
            String _mPhoneN = mPhoneN.getText().toString().trim();

//            SharedPreferencesStorage.saveFirstName(_mFirstName, this);
//            SharedPreferencesStorage.saveLastName(_mLastName, this);
//            SharedPreferencesStorage.savePhone(_mPhoneN, this);


            UserInfo userInfo = new UserInfo(_mFirstName,
                    _mLastName, _mPassword,
                    _mRe_password, _mEmail, _mPhoneN);

            Long id = mDataBaseHelper.addNweUser(userInfo);

            Toast.makeText(SignUpActivity.this, "id is:" + id, Toast.LENGTH_SHORT).show();

            emptyInputEditText();
            startActivity(new Intent(this, LoginActivity.class));
            finish();

        }
    }

    private void initObjects(){
        mInputValidation = new InputValidation();
        mDataBaseHelper = new DataBaseHelper(this);
    }

    private void initViews() {
        mFirstName = findViewById(R.id.f_name_id);
        mLastName = findViewById(R.id.l_name_id);
        mPassword = findViewById(R.id.password_id);
        mRe_password = findViewById(R.id.re_password_id);
        mEmail = findViewById(R.id.email_id);
        mPhoneN = findViewById(R.id.phone_id);

        mSignUpButton = findViewById(R.id.sign_Un_button);
    }

    private void initListeners(){
        mSignUpButton.setOnClickListener(this);
    }

    private void emptyInputEditText(){
        mFirstName.setText(null);
        mLastName.setText(null);
        mPassword.setText(null);
        mRe_password.setText(null);
        mEmail.setText(null);
        mPhoneN.setText(null);
    }

}
