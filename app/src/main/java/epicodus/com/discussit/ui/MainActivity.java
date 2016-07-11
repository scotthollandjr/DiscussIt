package epicodus.com.discussit.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import epicodus.com.discussit.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.boardPath) TextView mBoardPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBoardPath.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mBoardPath){
            Intent intent = new Intent(MainActivity.this, BoardActivity.class);
            startActivity(intent);

        }
    }
}
