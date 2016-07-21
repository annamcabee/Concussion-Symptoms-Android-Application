package com.concussionconnect.concussionproject;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class RateListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        List<Symptom> symptoms = new ArrayList<Symptom>();
        symptoms.add(new Symptom("Headache", 10));
        symptoms.add(new Symptom("Pressure in head", 10));
        symptoms.add(new Symptom("Neck pain", 10));
        symptoms.add(new Symptom("Nausea or vomiting", 10));
        symptoms.add(new Symptom("Dizziness", 10));
        ArrayList<RowModel> list=new ArrayList<RowModel>();

        for (Symptom s : symptoms) {
            list.add(new RowModel(s.toString(), s.getScore()));
        }

        setListAdapter(new RatingAdapter(list));
    }

    private RowModel getModel(int position) {
        return(((RatingAdapter)getListAdapter()).getItem(position));
    }

    class RatingAdapter extends ArrayAdapter<RowModel> {
        RatingAdapter(ArrayList<RowModel> list) {
            super(RateListActivity.this, R.layout.row, list);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            ViewWrapper wrapper;
            RatingBar rate;
            if (row==null) {
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);
                wrapper=new ViewWrapper(row);
                System.out.println();
                System.out.println(wrapper);
                System.out.println();

                row.setTag(wrapper);
                rate=wrapper.getRatingBar();
                RatingBar.OnRatingBarChangeListener l=
                        new RatingBar.OnRatingBarChangeListener() {
                            public void onRatingChanged(RatingBar ratingBar,
                                                        float rating, boolean fromTouch) {
                                Integer myPosition=(Integer)ratingBar.getTag();
                                RowModel model=getModel(myPosition);
                                model.weight=(int) rating;
                                LinearLayout parent=(LinearLayout)ratingBar.getParent();
                                TextView label=(TextView)parent.findViewById(R.id.label);
                                label.setText(model.toString());
                            }
                        };

                System.out.println(rate);
                rate.setOnRatingBarChangeListener(l);
            }
            else {
                wrapper=(ViewWrapper)row.getTag();
                rate=wrapper.getRatingBar();
            }

            RowModel model=getModel(position);

            wrapper.getLabel().setText(model.toString());
            rate.setTag(new Integer(position));
            rate.setRating(model.weight);
            return(row);
        }
    }

    class RowModel {
        String label;
        int weight;

        RowModel(String label, int weight) {
            this.label=label;
        }

        public String toString() {
            if (weight>=3.0) {
                return(label.toUpperCase());
            }
            return(label);
        }
    }
}