package com.example.myprofile;

import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String selectedSuperStar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView profile = (ImageView) findViewById(R.id.user_profile_photo);
        final EditText editName = (EditText) findViewById(R.id.editName);
        final EditText editDBO = (EditText) findViewById(R.id.editDOB);
        final EditText editInters = (EditText) findViewById(R.id.editInters);
        final RadioButton male = (RadioButton) findViewById(R.id.male);
        final RadioButton female = (RadioButton)findViewById(R.id.female);
        Button update = (Button) findViewById(R.id.save);
        final Button facebook = (Button) findViewById(R.id.facebook);
        final Button twitter = (Button) findViewById(R.id.twitter);

       // function is here by abdullah abu rtiam 120150781

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().isEmpty() ||
                        editDBO.getText().toString().isEmpty() ||
                        editInters.getText().toString().isEmpty() ||
                        male.getText().toString().isEmpty()||
                        female.getText().toString().isEmpty()
                ){
                    Toast.makeText(getApplicationContext(),"Enter your data",Toast.LENGTH_SHORT).show();

                }else{
                    if(male.isChecked()){
                        selectedSuperStar = male.getText().toString();
                    }else if (female.isChecked()){
                        selectedSuperStar = female.getText().toString();
                    }
                    Toast.makeText(getApplicationContext(),"Name -"+
                            editName.getText().toString()+"\n"+"date of birth -"+
                            editDBO.getText().toString()+"\n"+"gender - " + selectedSuperStar+"\n"+
                            "Intreste -"+ editInters.getText().toString(),Toast.LENGTH_SHORT ).show();
                }
                SharedPreferences pref =
                        getApplication().getSharedPreferences("myPref",0);
                        editName.setText(pref.getString("Name","").toString());
                        editDBO.setText(pref.getString("DOB","").toString());
                        editInters.setText(pref.getString("Intreste","").toString());

                        // here i will add socail media part
                        facebook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_OPENABLE);
                                intent.setData(Uri.parse("https://www.facebook.com/EpicCode97"));
                                startActivity(intent);
                            }
                        });
                        twitter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_OPENABLE);
                                intent.setData(Uri.parse("https://twitter.com/abdullahrt97"));
                                startActivity(intent);
                            }
                        });
            }
        });
    }
}
