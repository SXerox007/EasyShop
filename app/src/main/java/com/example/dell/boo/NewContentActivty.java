package com.example.dell.boo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

/**
 * Created by Dell on 14-Apr-16.
 */
public class NewContentActivty extends AppCompatActivity {
    EditText email,pwd;
    ProgressBar progress;
    public  static  String title;
     ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        progress = (ProgressBar) findViewById(R.id.progress);
        email=(EditText)findViewById(R.id.edit_text_email);
        pwd = (EditText)findViewById(R.id.edit_text_password);

    }
public void onSignInPressed(View view){

    String Email1 = email.getText().toString();
   final String Email = Email1.replace(".com","");
    final String password = pwd.getText().toString();
   final Firebase ref = new Firebase("https://intense-fire-5197.firebaseio.com/");
    progressDialog = ProgressDialog.show(this, "", "logging in... !!!", true);

    ref.authWithPassword(Email1, password, new Firebase.AuthResultHandler() {
        @Override
        public void onAuthenticated(AuthData authData) {

            progressDialog.dismiss();
            //System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
//            Toast.makeText(getBaseContext(),"User ID:" + authData.getUid() + ", Provider:" + authData.getProvider(),Toast.LENGTH_LONG).show();
            startnewactivty();
            Toast.makeText(getBaseContext(), "Welcome !", Toast.LENGTH_LONG).show();
            Firebase  refw = new  Firebase("https://intense-fire-5197.firebaseio.com/users");
            Query query = refw.orderByChild("id").equalTo(Email);
                query.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                         title= dataSnapshot.getKey();
                       // Toast.makeText(getBaseContext(), title,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });









           /* final Firebase ref1 = new Firebase("https://intense-fire-5197.firebaseio.com/users");
                   Query query = ref1.child("users").equalTo(Email);
            query.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getKey();


                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                 }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(getBaseContext(), "Erroe !", Toast.LENGTH_LONG).show();

                }
            });
*/
// Attach an listener to read the data at our posts reference





        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
            // there was an error

            switch (firebaseError.getCode()) {
                case FirebaseError.USER_DOES_NOT_EXIST:
                    progressDialog.dismiss();
                    Toast.makeText(getBaseContext(),"User ain't exists !",Toast.LENGTH_LONG).show();
                    break;
                case FirebaseError.INVALID_PASSWORD:
                    // handle an invalid password
                    progressDialog.dismiss();
                    Toast.makeText(getBaseContext(),"password isn't correct !",Toast.LENGTH_LONG).show();

                    break;
                case FirebaseError.NETWORK_ERROR:
                    progressDialog.dismiss();
                    Toast.makeText(getBaseContext(),"Check your internet conn. !",Toast.LENGTH_LONG).show();
                   break;

                default:
                    progressDialog.dismiss();
                    Toast.makeText(getBaseContext(),"User and password aren't correct !",Toast.LENGTH_LONG).show();

                    // handle other errors
                    break;
            }
        }
    });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.item1).setVisible(false);
        menu.findItem(R.id.item2).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){
            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }

    public void startnewactivty(){
    startActivity(new Intent(this, Details.class));

}
public void onSignUpPressed(View v){
    startActivity(new Intent(this,MainActivity.class));
}

}