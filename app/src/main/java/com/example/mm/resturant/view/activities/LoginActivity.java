package com.example.mm.resturant.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mm.resturant.R;
import com.example.mm.resturant.Util.InputValidation;
import com.example.mm.resturant.customfonts.MyTextView_Roboto_Regular;
import com.example.mm.resturant.models.SQLiteHelper.UserTable.DataBaseHelper;
import com.example.mm.resturant.models.sharedpreferenceshelber.UserLoginStorage;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;



public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_EMILE = "EMAIL";

    public static final int RC_SIGN_IN = 3600;
    GoogleSignInClient mGoogleSignInClient;

    private EditText mEditTextEmail, mEditTextPassword;
    private MyTextView_Roboto_Regular mLoginButton, mForgotLink;
    private MyTextView_Roboto_Regular mSignLink;

    private InputValidation mInputValidation;
    private DataBaseHelper mDataBaseHelper;
    private UserLoginStorage mSharedPreferencesStorage;

    @Override
    protected void onStart() {
        super.onStart();

        mSharedPreferencesStorage = new UserLoginStorage(LoginActivity.this);
        if (mSharedPreferencesStorage.getEmail() != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        //mLoginButton.setOnClickListener(this);

        initObjects();
        initViews();
        initListeners();


        //ImageButton signInButton = findViewById(R.id.sign_in_by_google_button);

        this.findViewById(R.id.sign_in_by_google_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               signIn();
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken("605146353395-ci75hn21v844dsftcvra6b8hs07uk83n.apps.googleusercontent.com")
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    private void updateUI(GoogleSignInAccount account) {
        if (account == null){
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "yas", Toast.LENGTH_SHORT).show();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            //String emaile = account.getEmail();
        } catch (ApiException e) {
            updateUI(null);
        }
    }


    /**
     *
     * */

    @Override
    public void onClick(View v) {

        int getId = v.getId();
        switch (getId){

            case R.id.sign_in_button:
                connectAndStoreData();
                break;

            case R.id.signUp_link:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.forgotLink:
                startActivity(new Intent(this, ForgotPasswordActivity.class));
                break;
        }

    }

    public void connectAndStoreData(){
        String textMail = mEditTextEmail.getText().toString().trim();
        String textPassword = mEditTextPassword.getText().toString().trim();

        if (!mInputValidation.isValidMail(mEditTextEmail)) {
            mEditTextEmail.setError("Please Enter Correct Email..");
            return;

        }else if (!mInputValidation.isValidPassword(mEditTextPassword)) {
            mEditTextPassword.setError("Please Enter Strong Password..");
            return;

        }else {
            if (mDataBaseHelper.checkAndGetUser(textMail, textPassword)){

                mSharedPreferencesStorage.putEmail(textMail);
                mSharedPreferencesStorage.putPassword(textPassword);



                Intent toMain = new Intent(this, MainActivity.class);
                toMain.putExtra(EXTRA_EMILE, textMail);

                toMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                toMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                Toast.makeText(this, ""+mSharedPreferencesStorage.getEmail(), Toast.LENGTH_SHORT).show();

                emptyInputEditText();
                startActivity(toMain);
                finish();

            }else {
                Toast.makeText(this, "FFFF", Toast.LENGTH_SHORT).show();

            }
        }

    }

    private void initObjects(){
        mDataBaseHelper = new DataBaseHelper(this);
        mSharedPreferencesStorage = new UserLoginStorage(LoginActivity.this);
        mInputValidation = new InputValidation();
    }

    private void initViews() {
        mEditTextPassword = findViewById(R.id.password_id);
        mEditTextEmail = findViewById(R.id.email_id);
        mLoginButton = findViewById(R.id.sign_in_button);
        mSignLink = findViewById(R.id.signUp_link);
        mForgotLink = findViewById(R.id.forgotLink);
    }

    private void initListeners(){
        mLoginButton.setOnClickListener(this);
        mSignLink.setOnClickListener(this);
        mForgotLink.setOnClickListener(this);
    }

    private void emptyInputEditText(){
        mEditTextEmail.setText(null);
        mEditTextPassword.setText(null);
    }



}
