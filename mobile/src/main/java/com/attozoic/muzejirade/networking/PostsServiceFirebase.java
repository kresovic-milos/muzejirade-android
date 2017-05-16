package com.attozoic.muzejirade.networking;

import com.attozoic.muzejirade.entities.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kresa on 5/16/17.
 */

public class PostsServiceFirebase {

    public void getPosts(String page, final FirebaseDatabaseListener callback) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        Query query = page == null ? mDatabase.child("posts").orderByChild("createdAt").limitToLast(30) : mDatabase.child("posts").orderByChild("createdAt").endAt(page, "createdAt").limitToLast(30);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Post> posts = new ArrayList<Post>();

                if (dataSnapshot != null && dataSnapshot.getValue() != null) {

                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        posts.add(0, postSnapshot.getValue(Post.class));
                    }
                }



                callback.onSuccess(posts);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }
}
