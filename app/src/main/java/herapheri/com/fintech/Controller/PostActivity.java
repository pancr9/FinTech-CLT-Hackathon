package herapheri.com.fintech.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/4/2017.
 */

public class PostActivity extends AppCompatActivity {

    TextView name;
    TextView cost;
    TextView desc;
    String imagePath;
    ImageView img;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        name = (TextView) findViewById(R.id.name);
        cost = (TextView) findViewById(R.id.cost);
        desc = (TextView) findViewById(R.id.desc);
        name.setText(getIntent().getStringExtra("name"));
        cost.setText(getIntent().getStringExtra("cost"));
        desc.setText(getIntent().getStringExtra("desc"));
        imagePath = getIntent().getStringExtra("imgpath");
        img = (ImageView) findViewById(R.id.postimg);
        if (imagePath != null && imagePath.length() > 0) {
            Picasso.with(this).load(imagePath)
                    .placeholder(R.drawable.ic_action_name)
                    .into(img);
        }


    }
}
