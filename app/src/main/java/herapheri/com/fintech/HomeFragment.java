package herapheri.com.fintech;

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

/**
 * Created by codyj on 11/4/2017.
 */

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        RecyclerView rv = (RecyclerView)v.findViewById(R.id.rv);
        ArrayList<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setCostPerHour("Price: 3.00$");
        item.setName("User: Mohamed");

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
            rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(getActivity(),items);
        rv.setAdapter(customArrayAdapter);
        return v;
    }

    public class Item {
        String imgPath;
        String name;
        String costPerHour;
        String itemDescription;


        public Item() {
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCostPerHour() {
            return costPerHour;
        }

        public void setCostPerHour(String costPerHour) {
            this.costPerHour = costPerHour;
        }
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
                    ii.putExtra("name",items.get(i).getName());
                    ii.putExtra("cost",items.get(i).getCostPerHour());
                    ii.putExtra("desc",items.get(i).getItemDescription());
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
           // if (!TextUtils.isEmpty(feedItem.getThumbnail())) {
//                Picasso.with(mContext).load(feedItem.getThumbnail())
//                        .error(R.drawable.placeholder)
//                        .placeholder(R.drawable.placeholder)
//                        .into(customViewHolder.imageView);
         //   }

            //Setting text view title

            customViewHolder.name.setText(items.get(i).getName());
            customViewHolder.age.setText(items.get(i).getCostPerHour());
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
