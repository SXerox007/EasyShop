package com.example.dell.boo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

/**
 * Created by Dell on 22-Apr-16.
 */
public class Profile extends AppCompatActivity {
    static String kl;
    Firebase ref = new Firebase("https://intense-fire-5197.firebaseio.com/users");
    TextView textView, textView1, textView2, textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        textView = (TextView) findViewById(R.id.tvTitle1);
        textView1 = (TextView) findViewById(R.id.tvCode1);
        textView2 = (TextView) findViewById(R.id.tvDateIssued);
        textView3 = (TextView) findViewById(R.id.tvReturnDate);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              /*  String Au = (String) dataSnapshot.child(NewContentActivty.title).child(Availability.key).child("Book_Code").getValue();
                textView1.setText(Au);
                String A = (String) (dataSnapshot.child(NewContentActivty.title).child(Availability.key).child("Name").getValue());
                textView.setText(A);
                String BC = (String) dataSnapshot.child(NewContentActivty.title).child(Availability.key).child("DateIssued").getValue();
                textView2.setText(BC);
*/
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


}

