package com.example.tabsfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import com.google.android.material.textview.MaterialTextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class tab2 extends Fragment {

    private View card;
    private Button mDatePicker;

    MaterialTextView nametext;

    public tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        TextInputEditText textInput= view.findViewById(R.id.goa);
        textInput.setFocusable(false);

        mDatePicker= view.findViewById(R.id.datebtn);
        final MaterialTextView dateview= (MaterialTextView) view.findViewById(R.id.birthtxt);

        MaterialDatePicker.Builder builder= MaterialDatePicker.Builder.datePicker();
        final MaterialDatePicker materialDatePicker= builder.build();

        MaterialTextView nametext= view.findViewById(R.id.nametxt);

        mDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getFragmentManager(),"Date_Picker");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                dateview.setText(materialDatePicker.getHeaderText().toString());

            }
        });
        return view;
    }

}
