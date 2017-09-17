package app.somyost.easyform.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import app.somyost.easyform.R;
import app.somyost.easyform.utility.MyAlertDialog;

/**
 * Created by Chaiwoot on 17/9/2560.
 */

public class MainFragment extends Fragment{

    //Explicit var
    // Ctrl Space ins Type
    private String nameString,genderString, provinceString;
    private boolean genderABoolean = true;
    private int indexAnInt = 0;
    private String[] provinceStrings = new String[]{
            "Please Choose Province",
            "Bk",
            "Sk",
            "Sm",
            "Ss",
            "Sp"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //AddData Controller
        addDataController();

        //Radio Controller
        radioController();

        //Spinner Controller
        spinnerController();


    }

    private void spinnerController() {
        Spinner spinner = getView().findViewById(R.id.spnProvince);
        //Show String in Dropdown
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,
                provinceStrings
        );
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexAnInt = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                indexAnInt = 0;
            }
        });

    }

    private void radioController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                genderABoolean = false;
                switch (i) {
                    case R.id.radMale:
                        genderString = "Male";
                        break;
                    case R.id.radFemale:
                        genderString = "Female";
                        break;
                }

            }
        });
    }

    private void addDataController() {
        Button button = getView().findViewById(R.id.btnAddData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From Edittext
                EditText editText = getView().findViewById(R.id.edtName);
                nameString = editText.getText().toString().trim();

                //Check Space
                if (nameString.equals("")) {
                    //Have Space
                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                    myAlertDialog.myDialog("Have Space","Please Fill All Blank");
                } else if (genderABoolean) {
                    //None Choose Gender
                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                    myAlertDialog.myDialog("None Choose Gender",
                            "Please Choose Male or Female ?");
                } else if (indexAnInt ==0) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                    //myAlertDialog.myDialog("");
                    myAlertDialog.myDialog(getResources().getString(R.string.title),
                            getResources().getString(R.string.message));
                } else {

                }


            } // onClick
        });
    }
}//Main Class
