package herapheri.com.fintech.Controller;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import herapheri.com.fintech.Model.Item;
import herapheri.com.fintech.Model.Money;
import herapheri.com.fintech.Model.Transaction;
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
    Item item;
    ListView post_lv;
    Button purchase;
    Transaction t;
    CheckBox trace;
    CheckBox insure;
    Boolean trac;
    Boolean insur;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        name = (TextView) findViewById(R.id.name);
        cost = (TextView) findViewById(R.id.cost);
        desc = (TextView) findViewById(R.id.desc);
        item = (Item) getIntent().getSerializableExtra("item");
        name.setText("Name : " + item.getName());
        cost.setText("Cost per day : " + item.getPricePerday() + "$");
        //desc.setText(getIntent().getStringExtra("desc"));
        //imagePath = getIntent().getStringExtra("imgpath");
        img = (ImageView) findViewById(R.id.postimg);
        insure = (CheckBox) findViewById(R.id.insure);
        insure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                insur = isChecked;
            }
        });
        trace = (CheckBox) findViewById(R.id.track);
        trace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                trac = isChecked;
            }
        });
        post_lv = (ListView) findViewById(R.id.post_info);
        purchase = (Button) findViewById(R.id.purchaseBtn);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PostActivity.this, "Sending order!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

//        if (imagePath != null && imagePath.length() > 0) {
//            Picasso.with(this).load(imagePath)
//                    .placeholder(R.drawable.ic_action_name)
//                    .into(img);
//        }

        ArrayList<String> contents = new ArrayList<>();
        item.setActive(false);
        item.setBrand("Walmart");
        item.setCurrentTransactionId("000111");
        item.setId("1");
        item.setImageHash("#HASH");
        item.setModel("Oxford");
        item.setLenderId("001");
        item.setManufactureYear(Integer.parseInt("2017"));
        Location l = new Location("provider");
        //item.setLocation(l);
        item.setPricePerday(item.getPricePerday());
        item.setRating(9.8f);
        item.setTimeRented(Long.parseLong("3333"));
        item.setTimeReturned(Long.parseLong("4444"));
        item.setType("A");
        item.setWeight(200.00f);
        contents.add("Active : " + item.getActive());
        contents.add("Brand : " + item.getBrand());
        contents.add("Current Transaction ID : " + item.getCurrentTransactionId());
        contents.add("ID : " + item.getId());
        contents.add("Image Hash : " + item.getImageHash());
        contents.add("Model : " + item.getModel());
        contents.add("LenderID : " + item.getLenderId());
        contents.add("Manufacture Year : " + item.getManufactureYear());
        //contents.add("Location : "+item.getLocation());
        contents.add("Price Per Day : " + item.getPricePerday());
        contents.add("Rating : " + item.getRating());
        contents.add("Time Rented : " + item.getTimeRented());
        contents.add("Time Returned : " + item.getTimeReturned());
        contents.add("Type : " + item.getType());
        contents.add("Weight : " + item.getWeight());
        CustomPstAdapter customPstAdapter = new CustomPstAdapter(this, R.layout.activity_post_item, contents);
        post_lv.setAdapter(customPstAdapter);

        t = new Transaction();
        t.setBeforeImageURL("");
        t.setAfterImageURL("");
        t.setEndTime(Long.parseLong("10002"));
        t.setExtraCost(4.50f);
        t.setId(Long.parseLong("1"));
        t.setLeaseBroken(false);
        Money m = new Money();
        m.setCurrency("USD");
        m.setAmount("78.00$");
        t.setPrice(m);
        t.setInsuranceOpted(insur);
        t.setTracking(trac);
        t.setLenderId("00");
        t.setRenterId("09");
        t.setItemId("01U2M");
        t.setTransactionCost("0.30");
        t.setStartTime(Long.parseLong("1300"));
        sendTransaction();


    }

    public void sendTransaction() {

    }

    private class CustomPstAdapter extends ArrayAdapter<String> {

        Context c;
        int r;
        List<String> s;

        CustomPstAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {

            super(context, resource, objects);
            c = context;
            r = resource;
            s = objects;
        }

        @Override
        public int getCount() {
            return s.size();
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(r, parent, false);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });


            TextView name = (TextView) convertView.findViewById(R.id.post_item);
            name.setText(s.get(position));
            return convertView;
        }
    }
}
