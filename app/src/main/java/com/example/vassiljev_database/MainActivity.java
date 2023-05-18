package com.example.vassiljev_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db",
                MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Dogs (name TEXT, age INTEGER,color TEXT, breed Text,UNIQUE(name))");
        db.execSQL("INSERT OR IGNORE INTO Dogs VALUES ('JAKE', 23, 'Blue', 'DOG'),('LOGAN', 31, 'Brown', 'DOBERMAN');");

        Cursor query = db.rawQuery("SELECT * FROM Dogs;", null);

        TextView textView = findViewById(R.id.textView);
        textView.setText("");

        while(query.moveToNext()){
            String name = query.getString(0);
            int age = query.getInt(1);
            String Color = query.getString(2);
            String Breed = query.getString(3);
            textView.append("Name: " + name + " Age: " + age + "\n" + "Color: " + Color + " Breed: " + Breed + "\n" + "\n");
        }

        query.close();
        db.close();
    }



}