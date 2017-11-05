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

/**
 * Created by codyj on 11/4/2017.
 */

public class HomeFragment extends Fragment {
    Item item;
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
        //ArrayAdapter adapter = new ArrayAdapter<String> (this,R.layout.item, items);
        //CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getActivity(),R.layout.item,items);
        //rv.setAdapter(customArrayAdapter);
        rv.setHasFixedSize(true);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        //gridLayoutManager.set
        rv.setLayoutManager(gridLayoutManager);
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getActivity(), items);
        rv.setAdapter(customArrayAdapter);
        return v;
    }

    public Double getDistanceBetweenPoints(){
        double lat = 35.311707f;
        double lon = -80.743051f;
        double ilat = item.getLocation().getLatitude();
        double ilon = item.getLocation().getLatitude();
        return distance(lat,lon,ilat,ilon);

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



    public class CustomArrayAdapter extends RecyclerView.Adapter<CustomArrayAdapter.CustomViewHolder> {
        private List<Item> items;
        private Context mContext;

        public CustomArrayAdapter(Context context, List<Item> items) {
            this.items = items;
            this.mContext = context;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ii = new Intent(getActivity(),PostActivity.class);
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
                    //ii.putExtra("name",items.get(i).getName());
                    //ii.putExtra("cost",items.get(i).getCostPerHour());
                    //ii.putExtra("desc",items.get(i).getItemDescription());
                   // ii.putExtra("path",items.get(i).getImgPath());
                    ii.putExtra("item",item);
                    startActivity(ii);
                }
            });
            CustomViewHolder viewHolder = new CustomViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
            //Item feedItem = feedItemList.get(i);

            //Render image using Picasso library
//            if (items.get(i).getImgPath() != null && items.get(i).getImgPath().length() > 0) {
//                Picasso.with(mContext).load(items.get(i).getImgPath())
//                        .placeholder(R.drawable.ic_action_name)
//                        .into(customViewHolder.imageView);
//            }

            //Setting text view title

            customViewHolder.name.setText(items.get(i).getName());
            customViewHolder.age.setText(items.get(i).getPricePerday()+"$ cost per day");
        }

        @Override
        public int getItemCount() {
            return (null != items ? items.size() : 0);
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            protected ImageView imageView;
            TextView name;
            TextView age;

            public CustomViewHolder(View view) {
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