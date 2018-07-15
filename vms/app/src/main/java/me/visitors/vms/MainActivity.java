package me.visitors.vms;



import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    EditText Phnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText Phnum = (EditText) findViewById(R.id.Phnum);
        Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        bt1 = (Button)findViewById(R.id.buttonSubmit);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidPhone(Phnum.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Phone number is valid", Toast.LENGTH_SHORT).show();
                    Intent myntent = new Intent(MainActivity.this, Secondactivity.class);
                    startActivity(myntent);


                } else {

                    Toast.makeText(getApplicationContext(), "Phone number is not valid", Toast.LENGTH_SHORT).show();
                    Intent myntent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(myntent);



                }




            }
        });

    }

    public boolean isValidPhone(String phone)
    {
        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+", phone))
        {
            if(phone.length() != 10 )
            {
                check = false;

            }
            else
            {
                check = true;

            }
        }
        else
        {
            check=false;
        }
        return check;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}

