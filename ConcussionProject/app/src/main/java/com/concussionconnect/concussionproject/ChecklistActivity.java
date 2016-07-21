package com.concussionconnect.concussionproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annamcabee on 4/7/15.
 */
public class ChecklistActivity extends ListActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        List<Symptom> symptoms = new ArrayList<Symptom>();
        symptoms.add(new Symptom("I have a headache", 10));
        symptoms.add(new Symptom("My neck hurts", 10));
        symptoms.add(new Symptom("I have an upset stomach", 8));
        symptoms.add(new Symptom("I feel dizzy", 20));
        symptoms.add(new Symptom("I feel tired", 20));
        symptoms.add(new Symptom("I feel emotional", 20));
        symptoms.add(new Symptom("My vision is blurry", 10));

        ArrayAdapter<Symptom> adapter = new ArrayAdapter<Symptom>(this, android.R.layout.simple_list_item_multiple_choice, symptoms);
        setListAdapter(adapter);
    }

    /**
     * handles interaction with fragment
     *
     * @param id string
     */
    public void onFragmentInteraction(String id) {


        System.out.println(id);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void continueToWordMemory(View view) {
        Intent intent = new Intent(this, WordMemoryActivity.class);
        startActivity(intent);
    }
}
