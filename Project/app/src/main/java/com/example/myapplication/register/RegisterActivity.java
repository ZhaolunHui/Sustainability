package com.example.myapplication.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.UserDatabase.UserDatabaseHelper;
import com.example.myapplication.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity
{
    private UserDatabaseHelper dbHelper;

    // Create Registry Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new UserDatabaseHelper(this);
    }

    // onCLick listener of the button
    public void ClickOnRegister(View v)
    {
        // Get the information from edittext boxes
        EditText insert_username = (EditText)findViewById(R.id.editText3);
        EditText insert_password = findViewById(R.id.editText4);
        String username = insert_username.getText().toString();
        String password = insert_password.getText().toString();

        // Check user whether exist
        if (UserExist(username, password))
        {
            Toast.makeText(this,"User: " + username + " exist",Toast.LENGTH_SHORT).show();
        }
        else
        {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String sql="insert into user(username,password) values(?,?)";
            Object obj[]={username, password};
            db.execSQL(sql, obj);
            Toast.makeText(this, "User: " + username + " register successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    // Check the user in database
    public boolean UserExist(String username,String password)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=?";
        Cursor cursor = db.rawQuery(sql, new String[] {username});
        if (cursor.moveToFirst())
        {
            cursor.close();
            return true;
        }
        return false;
    }
}
