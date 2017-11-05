package herapheri.com.fintech.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import herapheri.com.fintech.Model.Item;
import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/5/2017.
 */

public class LenderActivity extends AppCompatActivity {
    File imgPath;
    ImageView v;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_lender);
        v = (ImageView) findViewById(R.id.ive);
        imgPath = (File) getIntent().getSerializableExtra("path");
        Picasso.with(this).load(imgPath).into(v);
        Log.d("LenderActivity",imgPath.getAbsolutePath());
        Item item = new Item();
        item.setName("Tractor Trailer");
        item.setActive(false);
        item.setBrand("Walmart");
        item.setCurrentTransactionId("000111");
        item.setId("1");
        item.setImageHash("#HASH");
        item.setModel("Oxford");
        item.setLenderId("001");
        item.setManufactureYear(Integer.parseInt("2017"));
        //Location l = new Location("provider");
        //item.setLocation(l);
        item.setPricePerday(3.50f);
        item.setRating(9.8f);
        item.setTimeRented(Long.parseLong("3333"));
        item.setTimeReturned(Long.parseLong("4444"));
        item.setType("A");
        item.setWeight(200.00f);

        //Created test item, ready to be sent
        Intent i = new Intent(this,TabbarActivity.class);
        startActivity(i);
    }


    public class CustomLenderAdapter extends ArrayAdapter<String>{

            Context c;
            int r;
            List<String> s;
            public CustomLenderAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {

                super(context, resource, objects);
                c = context;
                r = resource;
                s = objects;
            }

            @Override
            public int getCount() {
                return super.getCount();
            }

            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) c
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(r,parent,false);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent i = new Intent(getActivity(),PostActivity.class);
                        //i.putExtra("name",s.get(position).getName());
                        //i.putExtra("cost",s.get(position).getCostPerHour());
                        //i.putExtra("desc",s.get(position).getItemDescription());
                       // startActivity(i);

                    }
                });
                TextView et = (TextView) convertView.findViewById(R.id.lender_et);



                return convertView;
            }




    }
}
