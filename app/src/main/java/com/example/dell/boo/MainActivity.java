package com.example.dell.boo;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static long I=0;
    Context context = this;
    Menu menu;
    EditText ContactName,ContactId,ContactPassword,email;
    ProgressDialog progressDialog=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mmainn);
        ContactId=(EditText)findViewById(R.id.edit_text_userid_create);
        ContactName=(EditText)findViewById(R.id.edit_text_username_create);
        ContactPassword=(EditText)findViewById(R.id.edit_text_password_create);
        email=(EditText)findViewById(R.id.edit_text_email_create);

        Firebase.setAndroidContext(this);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

       //Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
       // setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void onCreateAccountPressed(View view) {

        final String id = ContactId.getText().toString();

        final String name = ContactName.getText().toString();
       String Email1 = email.getText().toString();
        final String Email = Email1.replace(".com","");
        final String password = ContactPassword.getText().toString();

        if(password.isEmpty() || Email.isEmpty() ||name.isEmpty())
        {

            Toast.makeText(getBaseContext(),"All fields are required.",Toast.LENGTH_LONG).show();


            return;
        }



            else
            //if (!password.equals(password2)) {
              //  Toast.makeText(getBaseContext(), "password donot match !", Toast.LENGTH_LONG).show();
            //} else
             {
                 progressDialog = ProgressDialog.show(context, "", "creating.. !!!", true);
               // userDbHelper = new UserDbHelper(context);
               // sqLiteDatabase = userDbHelper.getWritableDatabase();
                //userDbHelper.addInformation(id, name, password, password2, sqLiteDatabase);
                //Toast.makeText(getBaseContext(), "signed up !", Toast.LENGTH_LONG).show();
                //userDbHelper.close();
                 final Firebase ref = new Firebase("https://intense-fire-5197.firebaseio.com/");
                 ref.createUser(Email1, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                     @Override
                     public void onSuccess(Map<String, Object> result) {
                         Firebase alanRef = ref.child("users").child(id);
                         Map<String,Object>nick = new HashMap<String, Object>();
                         nick.put("id", Email);
                         alanRef.updateChildren(nick);

                   /*     Firebase alanRef1  =ref.child("users").child(id).child("Issued_Book_1:");
                         Map<String,Object>nickname1 = new HashMap<String, Object>();
                         nickname1.put("Name",0);
                         nickname1.put("Book_Code",0);
                         nickname1.put("DateIssued",0);
                         nickname1.put("ReturnDate", 0);
                         alanRef1.updateChildren(nickname1);

                         Firebase alanRef2  =ref.child("users").child(id).child("Issued_Book_2:");
                         Map<String,Object>nickname2 = new HashMap<String, Object>();
                         nickname2.put("Name",0);
                         nickname2.put("Book_Code",0);
                         nickname2.put("DateIssued",0);
                         nickname2.put("ReturnDate",0);
                         alanRef2.updateChildren(nickname2);

                         Firebase alanRef3  = ref.child("users").child(id).child("Issued_Book_3:");
                         Map<String,Object>nickname3 = new HashMap<String, Object>();
                         nickname3.put("Name",0);
                         nickname3.put("Book_Code",0);
                         nickname3.put("DateIssued",0);
                         nickname3.put("ReturnDate",0);
                         alanRef3.updateChildren(nickname3);
*/
                        progressDialog.dismiss();
                         System.out.println("Successfully created user account with uid: " + result.get("uid"));
                      Toast.makeText(getBaseContext(),"Successfully created user account with uid:" + result.get("uid"),Toast.LENGTH_LONG).show();
                     }
                     @Override
                     public void onError(FirebaseError firebaseError) {
                         switch (firebaseError.getCode()) {

                             case FirebaseError.NETWORK_ERROR:
                                 progressDialog.dismiss();
                             Toast.makeText(getBaseContext(), "Check your inernet connection!", Toast.LENGTH_LONG).show();
                                 break;
                             case FirebaseError.INVALID_EMAIL:
                                 progressDialog.dismiss();
                                 Toast.makeText(getBaseContext(),"Invalid Email",Toast.LENGTH_LONG).show();
                                 break;
                             default:
                                 progressDialog.dismiss();
                                 Toast.makeText(getBaseContext(),"User already exists !",Toast.LENGTH_LONG).show();
                                 break;
                         }
                     }
                 });


            }
        }
    public  void onSignInPressed(View view){
        startActivity(new Intent(this, NewContentActivty.class));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.menu = menu;


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.item1).setVisible(false);
        menu.findItem(R.id.item2).setVisible(false);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }

}
