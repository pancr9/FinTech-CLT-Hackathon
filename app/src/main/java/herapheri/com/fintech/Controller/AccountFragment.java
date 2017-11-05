package herapheri.com.fintech.Controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import herapheri.com.fintech.Model.Address;
import herapheri.com.fintech.Model.EntityAccessTokens;
import herapheri.com.fintech.Model.EntityPrefrences;
import herapheri.com.fintech.Model.EntitySession;
import herapheri.com.fintech.Model.Money;
import herapheri.com.fintech.Model.Name;
import herapheri.com.fintech.Model.Networth;
import herapheri.com.fintech.Model.User;
import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/4/2017.
 */

public class AccountFragment extends Fragment {

    ListView list;
    ArrayList<String> users;
    Networth networth;
    TextView fname;
    TextView networth_tv;
    TextView liability_tv;
    TextView assets_tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        list = (ListView) v.findViewById(R.id.info);
        users = new ArrayList<>();


        User u = new User();
        u.setAddress(new Address("Woodward Hall", "UNC Charlotte", null, null, null));
        u.setEmail("6amigos.com");
        u.setId(0);
        u.setName(new Name("The 6", "Amigos"));
        u.setLoginName("The 6 amigos Log Name");
        EntityAccessTokens entityAccessTokens = new EntityAccessTokens();
        entityAccessTokens.setAppId("0DAFASNJDA000");
        entityAccessTokens.setUrl("https://www.6amingos.com");
        entityAccessTokens.setValue("3.50$");
        EntitySession session = new EntitySession();
        session.setUserSession("0001123");
        EntityPrefrences preferences = new EntityPrefrences();
        preferences.setCurrency("USD");
        preferences.setDateFormat("MM/dd/YYYY");
        preferences.setLocale("PM");
        preferences.setTimeZone("East");


        //u.setEntityAccessTokens();
        //for(int i =0; i <10; i++){
        users.add("Email : " + u.getEmail());
        users.add("Long name : " + u.getLoginName());
        users.add("Address : " + u.getAddress());
        users.add("User ID : " + u.getId() + "");
        users.add("App ID : " + entityAccessTokens.getAppId());
        users.add("URL : " + entityAccessTokens.getUrl());
        users.add("Value : " + entityAccessTokens.getValue());
        users.add("Currency : " + preferences.getCurrency());
        users.add("Locale : " + preferences.getLocale());
        users.add("DateFormat : " + preferences.getDateFormat());
        users.add("Time Zone : " + preferences.getTimeZone());
        users.add("User Session : " + session.getUserSession());
        CustomRequestAdapter customRequestAdapter = new CustomRequestAdapter(getActivity(), R.layout.fragment_account_item, users);
        list.setAdapter(customRequestAdapter);
        fname = (TextView) v.findViewById(R.id.fname);
        networth_tv = (TextView) v.findViewById(R.id.networth);
        liability_tv = (TextView) v.findViewById(R.id.liability);
        assets_tv = (TextView) v.findViewById(R.id.assets);
        networth = new Networth();
        Name name = new Name("John", "Doe");
        Money m = new Money();
        m.setAmount("450,000.00$");
        m.setCurrency("USD");
        networth.setAsset(m);
        Date d = new Date();
        networth.setDate(d);
        Money liability = new Money();
        liability.setAmount("0.00$");
        liability.setCurrency("USD");
        networth.setLiability(liability);
        Money netw = new Money();
        netw.setAmount("5,002,401.53$");
        netw.setCurrency("USD");
        networth.setNetworth(netw);
        name.setFirst("Mohamed");
        name.setLast("Salad");
        name.setFullName("Mohamed Salad");
        fname.setText(name.getFullName());
        networth_tv.setText("Networth : " + networth.getNetworth().getAmount() + " " + networth.getNetworth().getCurrency());
        assets_tv.setText("Assets : " + networth.getAsset().getAmount() + " " + networth.getAsset().getCurrency());
        liability_tv.setText("Liability : " + networth.getLiability().getAmount() + " " + networth.getLiability().getCurrency());

        // }
        return v;
    }

/*
    public class User {
        long id;
        String longName;
        String email;
        String name;
        String address;
        Entitypreferences entitypreferences;
        EntitySession entitySession;
        EntityAccessTokens entityAccessTokens;
        String validUntil;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getLongName() {
            return longName;
        }

        public void setLongName(String longName) {
            this.longName = longName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Entitypreferences getEntitypreferences() {
            return entitypreferences;
        }

        public void setEntitypreferences(Entitypreferences entitypreferences) {
            this.entitypreferences = entitypreferences;
        }

        public EntitySession getEntitySession() {
            return entitySession;
        }

        public void setEntitySession(EntitySession entitySession) {
            this.entitySession = entitySession;
        }

        public EntityAccessTokens getEntityAccessTokens() {
            return entityAccessTokens;
        }

        public void setEntityAccessTokens(EntityAccessTokens entityAccessTokens) {
            this.entityAccessTokens = entityAccessTokens;
        }

        public String getValidUntil() {
            return validUntil;
        }

        public void setValidUntil(String validUntil) {
            this.validUntil = validUntil;
        }
    }
*/


    public class CustomRequestAdapter extends ArrayAdapter<String> {

        Context c;
        int r;
        List<String> s;

        public CustomRequestAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {

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
            convertView = inflater.inflate(r, parent, false);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        Intent i = new Intent(getActivity(), PostActivity.class);
//                        i.putExtra("name", s.get(position).getName());
//                        i.putExtra("cost", s.get(position).getCostPerHour());
//                        i.putExtra("desc", s.get(position).getRequestDescription());
//                        startActivity(i);

                }
            });


            TextView name = (TextView) convertView.findViewById(R.id.account_item);
            name.setText(s.get(position));
            return convertView;
        }
    }


}
