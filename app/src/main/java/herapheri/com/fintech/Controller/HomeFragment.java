package herapheri.com.fintech.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import herapheri.com.fintech.Model.Item;
import herapheri.com.fintech.R;
import herapheri.com.fintech.Utils.RetrofitAPI;
import herapheri.com.fintech.Utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by codyj on 11/4/2017.
 */

public class HomeFragment extends Fragment {
    Item item;
    ArrayList<Item> items;
    CustomArrayAdapter customArrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.rv);
        ArrayList<Item> items = new ArrayList<>();
        item = new Item();
        item.setPricePerday(3.05F);
        item.setName("Tractor Trailer");
        //item.setLocation();

        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        //fetchAllItems();
        rv.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        rv.setLayoutManager(gridLayoutManager);
        customArrayAdapter = new CustomArrayAdapter(getActivity(), items);
        rv.setAdapter(customArrayAdapter);
        return v;
    }

    private void fetchAllItems() {
        RetrofitAPI retrofit = ServiceGenerator.createServiceForCloud(RetrofitAPI.class, 1);
        items = new ArrayList<>();

        Call<ArrayList<Item>> listCall = retrofit.getItemsForRenting();
        listCall.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                if (response.body() != null && response.isSuccessful()) {
                    //Display items.
                    items = response.body();
                }
                customArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {

            }
        });


    }

    public Double getDistanceBetweenPoints() {
        double lat = 35.311707f;
        double lon = -80.743051f;
        double ilat = item.getLocation().getLatitude();
        double ilon = item.getLocation().getLatitude();
        return distance(lat, lon, ilat, ilon);

    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    class CustomArrayAdapter extends RecyclerView.Adapter<CustomArrayAdapter.CustomViewHolder> {
        private List<Item> items;
        private Context mContext;

        CustomArrayAdapter(Context context, List<Item> items) {
            this.items = items;
            this.mContext = context;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ii = new Intent(getActivity(), PostActivity.class);

                    Item item = items.get(i);
                    item.setName("Tractor Trailer");
                    item.setActive(false);
                    item.setBrand("Walmart");
                    item.setCurrentTransactionId("000111");
                    item.setId("1");
                    item.setImageHash("#HASH");
                    item.setModel("Oxford");
                    item.setLenderId("001");
                    item.setManufactureYear(Integer.parseInt("2017"));
                    item.setPricePerday(3.50f);
                    item.setRating(9.8f);
                    item.setTimeRented(Long.parseLong("3333"));
                    item.setTimeReturned(Long.parseLong("4444"));
                    item.setType("A");
                    item.setWeight(200.00f);
                    ii.putExtra("item", item);
                    startActivity(ii);
                }
            });

            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {

            //Setting text view title
            customViewHolder.name.setText(items.get(i).getName());
            customViewHolder.age.setText(items.get(i).getPricePerday() + "$ cost per day");
        }

        @Override
        public int getItemCount() {
            return (null != items ? items.size() : 0);
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            protected ImageView imageView;
            TextView name;
            TextView age;

            CustomViewHolder(View view) {
                super(view);
                this.name = (TextView) view.findViewById(R.id.person_name);
                this.age = (TextView) view.findViewById(R.id.person_age);
            }
        }
    }

//    public class CustomArrayAdapter extends RecyclerView.Adapter<ItemViewHolder> {
//
//        Context c;
//        int r;
//        List<Item> s;
//        public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
//
//            super(context, resource, objects);
//            c = context;
//            r = resource;
//            s = objects;
//        }
//
//        @Override
//        public int getCount() {
//            return super.getCount();
//        }
//
//        @NonNull
//        @Override
//        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater inflater = (LayoutInflater) c
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(r,parent,false);
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(getActivity(),PostActivity.class);
//                    i.putExtra("name",s.get(position).getName());
//                    i.putExtra("cost",s.get(position).getCostPerHour());
//                    i.putExtra("desc",s.get(position).getItemDescription());
//                    startActivity(i);
//
//                }
//            });
//            TextView name = (TextView) convertView.findViewById(R.id.person_name);
//            TextView age = (TextView) convertView.findViewById(R.id.person_age);
//            name.setText(s.get(position).getName());
//            age.setText(s.get(position).getCostPerHour());
//
//
//            return convertView;
//        }
//    }


}
