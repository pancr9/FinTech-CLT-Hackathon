package herapheri.com.fintech;

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
import java.util.List;

/**
 * Created by codyj on 11/4/2017.
 */

public class AccountFragment extends Fragment {

    ListView list;
    ArrayList<String> users;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account,container,false);
        list = (ListView) v.findViewById(R.id.info);
        users = new ArrayList<>();
        User u = new User();
        u.setAddress("Woodward Hall");
        u.setEmail("6amigos.com");
        u.setId(0);
        u.setName("The 6 Amigos");
        u.setLongName("The 6 amigos Long Name");
        EntityAccessTokens entityAccessTokens = new EntityAccessTokens();
        entityAccessTokens.setAppId("0DAFASNJDA000");
        entityAccessTokens.setUrl("https://www.6amingos.com");
        entityAccessTokens.setValue("3.50$");
        EntitySession session = new EntitySession();
        session.setUserSession("0001123");
        EntityPrefrences prefrences = new EntityPrefrences();
        prefrences.setCurrency("USD");
        prefrences.setDateFormat("MM/dd/YYYY");
        prefrences.setLocale("PM");
        prefrences.setTimeZone("East");
        //u.setEntityAccessTokens();
        //for(int i =0; i <10; i++){
            users.add("Email : "+u.getEmail());
            users.add("Long name : "+u.getLongName());
            users.add("Address : "+u.getAddress());
            users.add("Valid until : "+u.getValidUntil());
            users.add("User ID : "+u.getId()+"");
            users.add("App ID : "+entityAccessTokens.getAppId());
            users.add("URL : "+entityAccessTokens.getUrl());
            users.add("Value : "+entityAccessTokens.getValue());
            users.add("Currency : "+prefrences.getCurrency());
            users.add("Locale : "+prefrences.getLocale());
            users.add("DateFormat : "+prefrences.getDateFormat());
            users.add("Time Zone : "+prefrences.getTimeZone());
            users.add("User Session : "+session.getUserSession());
            CustomRequestAdapter customRequestAdapter = new CustomRequestAdapter(getActivity(),R.layout.fragment_account_item,users);
            list.setAdapter(customRequestAdapter);
       // }
        return v;
    }

    public class User {
        long id;
        String longName;
        String email;
        String name;
        String address;
        EntityPrefrences entityPrefrences;
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

        public EntityPrefrences getEntityPrefrences() {
            return entityPrefrences;
        }

        public void setEntityPrefrences(EntityPrefrences entityPrefrences) {
            this.entityPrefrences = entityPrefrences;
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
