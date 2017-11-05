package herapheri.com.fintech;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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

public class RequestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_request,container,false);
        ListView rv = (ListView) v.findViewById(R.id.rve);
        ArrayList<Request> items = new ArrayList<>();
        Request item = new Request();
        item.setCostPerHour("3.00$");
        item.setName("Mohamed");
        item.setStatus("Approved");

        items.add(item);
        //ArrayAdapter adapter = new ArrayAdapter<String> (this,R.layout.item, items);
        CustomRequestAdapter customArrayAdapter = new CustomRequestAdapter(getActivity(), R.layout.request, items);
        rv.setAdapter(customArrayAdapter);
        return v;
    }






        public class Request {
            String name;
            String costPerHour;
            String status;


            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Request() {
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


        public class CustomRequestAdapter extends ArrayAdapter<Request> {

            Context c;
            int r;
            List<Request> s;

            public CustomRequestAdapter(@NonNull Context context, int resource, @NonNull List<Request> objects) {

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

                TextView name = (TextView) convertView.findViewById(R.id.name_request);
                TextView status = (TextView) convertView.findViewById(R.id.status_request);
                TextView cost = (TextView) convertView.findViewById(R.id.cost_request);
                name.setText(s.get(position).getName());
                cost.setText(s.get(position).getCostPerHour());
                status.setText(s.get(position).getStatus());
                CardView cardView = (CardView) convertView.findViewById(R.id.cardView);
                if(s.get(position).getStatus().equals("Approved")){
                cardView.setCardBackgroundColor(Color.parseColor("#009900"));
                }
                else if(s.get(position).getStatus().equals("Pending")){
                    cardView.setCardBackgroundColor(Color.parseColor("#999999"));

                }
                else if(s.get(position).getStatus().equals("Declined")){
                    cardView.setCardBackgroundColor(Color.parseColor("#FF0000"));

                }
                return convertView;
            }
            }
        }

