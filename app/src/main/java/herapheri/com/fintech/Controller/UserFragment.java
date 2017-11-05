package herapheri.com.fintech.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import herapheri.com.fintech.Model.Money;
import herapheri.com.fintech.Model.Name;
import herapheri.com.fintech.Model.Networth;
import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/5/2017.
 */

public class UserFragment extends Fragment {

    Networth networth;
    TextView fname;
    TextView networth_tv;
    TextView liability_tv;
    TextView assets_tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user,container,false);
        fname = (TextView) v.findViewById(R.id.fname);
        networth_tv = (TextView) v.findViewById(R.id.networth);
        liability_tv = (TextView) v.findViewById(R.id.liability);
        assets_tv = (TextView) v.findViewById(R.id.assets);
        networth = new Networth();
        Name name = new Name();
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
        networth_tv.setText("Networth : "+networth.getNetworth().getAmount()+" "+networth.getNetworth().getCurrency());
        assets_tv.setText("Assets : "+networth.getAsset().getAmount()+" "+networth.getAsset().getCurrency());
        liability_tv.setText("Liability : "+networth.getLiability().getAmount()+" "+networth.getLiability().getCurrency());
        return v;
    }
}
