package epicodus.com.discussit.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import epicodus.com.discussit.Constants;
import epicodus.com.discussit.R;
import epicodus.com.discussit.adapters.FirebaseCategoryViewHolder;
import epicodus.com.discussit.models.Category;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {
    private ValueEventListener mCategoryReferenceListener;
    ArrayList<Category> cat = new ArrayList<Category>();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.categoryEditText) EditText mCategoryEditText;
    @Bind(R.id.createCategory) TextView mCreateCategory;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private DatabaseReference mCategoryReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        ButterKnife.bind(this);
        mCreateCategory.setOnClickListener(this);

        mCategoryReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_CATEGORY);

        setUpFirebaseAdapter();
    }


    private void setUpFirebaseAdapter(){
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Category, FirebaseCategoryViewHolder>
                (Category.class, R.layout.category_list_item, FirebaseCategoryViewHolder.class,
                        mCategoryReference) {

            @Override
            protected void populateViewHolder(FirebaseCategoryViewHolder viewHolder, Category model, int position) {
                viewHolder.bindCategory(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    public void onClick(View v){
        if(v == mCreateCategory){
            String name = mCategoryEditText.getText().toString();
            Category x = new Category(name);

            saveCategory(x);
        }
    }
    public void saveCategory(Object cat) {
        mCategoryReference.push().setValue(cat);
    }
}
