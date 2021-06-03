package com.example.androidappdev1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter{
    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final Double[] amountArray;

    //to store the list of countries
    private final String[] sellerArray;

    //to store the list of countries
    private final String[] noteArray;

    public CustomListAdapter(Activity context, String[] sellerArrayParam, String[] noteArrayParam, Double[] amountArrayParam){

        super(context,R.layout.listview_row , sellerArrayParam);
        this.context = context;
        this.sellerArray = sellerArrayParam;
        this.noteArray = noteArrayParam;
        this.amountArray = amountArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);
        TextView amountTextField = (TextView) rowView.findViewById(R.id.AmountHolder);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(sellerArray[position]);
        infoTextField.setText(noteArray[position]);
        amountTextField.setText("$"+Double.toString(amountArray[position]));

        return rowView;

    };
}
