package me.visitors.vms;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;


public class Thirdactivity extends AppCompatActivity {

    Button bt3;
    ImageView imageView;
    EditText visitorname,hostname,IDnum,duration,persons,remark;
    Spinner dname,cname,IDname,vtype,location;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        visitorname=(EditText)findViewById(R.id.visitorname);
        hostname=(EditText)findViewById(R.id.hostname);
        dname=(Spinner) findViewById(R.id.dname);
        cname=(Spinner) findViewById(R.id.cname);
        IDname=(Spinner) findViewById(R.id.IDname);
        IDnum=(EditText)findViewById(R.id.IDnum);
        vtype=(Spinner) findViewById(R.id.vtype);
        duration=(EditText)findViewById(R.id.duration);
        location=(Spinner) findViewById(R.id.location);
        persons=(EditText)findViewById(R.id.persons);
        remark=(EditText)findViewById(R.id.remark);


        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        bt3 = (Button) findViewById(R.id.buttonRegi);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(visitorname.getText().toString().equals("")){
                    visitorname.requestFocus();
                    visitorname.setError("FIELD CANNOT BE EMPTY");
                }

                else if(hostname.getText().toString().equals("")){
                    hostname.requestFocus();
                    hostname.setError("Enter host's name");
                }

                else if(IDnum.getText().toString().equals("")){
                    IDnum.requestFocus();
                    IDnum.setError("Please fill this field");
                }

                else if(duration.getText().toString().equals("")){
                    duration.requestFocus();
                    duration.setError("Enter Duration");
                }

                else if(persons.getText().toString().equals("")){
                    persons.requestFocus();
                    persons.setError("Please fill this field");
                }
                else {


                    Intent myintent2 = new Intent(Thirdactivity.this, Fourthactivity.class);
                    startActivity(myintent2);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }




}

