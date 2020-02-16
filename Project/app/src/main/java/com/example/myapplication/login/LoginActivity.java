package com.example.myapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.UserDatabase.UserDatabaseHelper;
import com.example.myapplication.navigation.NaviActivity;
import com.example.myapplication.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity
{
    private UserDatabaseHelper dbHelper;

    // Create the login activity
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new UserDatabaseHelper(this);
    }

    // onClick method
    public void ClickOnLogin(View v)
    {
        // Get the information from the edittext boxes
        EditText insert_username = (EditText)findViewById(R.id.editText);
        EditText insert_password = findViewById(R.id.editText2);
        String username = insert_username.getText().toString();
        String password = insert_password.getText().toString();

        // Check the user whether exist
        if (UserExist(username, password))
        {
            Toast toast = Toast.makeText(this,"\nWelcome " + username + " !\n",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            Intent intent = new Intent(LoginActivity.this, NaviActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Username or Password not correct", Toast.LENGTH_SHORT).show();
        }
    }

    // Check user whether exist through the database
    public boolean UserExist(String username,String password)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {username, password});
        if (cursor.moveToFirst())
        {
            cursor.close();
            return true;
        }
        return false;
    }

    // An intent, jump to Registry activity
    public void startRegisterActivity(View v)
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
