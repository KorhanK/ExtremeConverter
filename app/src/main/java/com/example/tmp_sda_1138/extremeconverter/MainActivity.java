package com.example.tmp_sda_1138.extremeconverter;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

//import com.wortyhgame.korha.totalconverter.R;

public class MainActivity extends AppCompatActivity {

    public double enteredNumber;
    public double convertedNumber;

    Spinner firstSpinner;
    Spinner secondSpinner;
    ArrayAdapter<CharSequence> firstAdapter;
    ArrayAdapter<CharSequence> secondAdapterDistances;
    ArrayAdapter<CharSequence> secondAdapterWeights;
    ArrayAdapter<CharSequence> secondAdapterVolume;

    String measureSelectedOnFirstSpinnerG;
    String measureSelectedOnSecondSpinnerG;

   String typeSelectedOnFirstSpinner;
   String typeSelectedOnSecondSpinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Resources res = getResources();

        final String[] distances = {"Meters", "Feet", "Inches", "Yard", "Mile", "Centimeters"};
        final String[] weights = {"Grams", "Kilograms", "Pounds", "Ounces", "Grains", "Tons"};
        final String[] volume = {"Pints", "Cups", "FluidOunces", "Gallons", "Liters"};



        firstSpinner = (Spinner) findViewById(R.id.firstSpinner);
        secondSpinner = (Spinner) findViewById(R.id.secondSpinner);
        firstAdapter = ArrayAdapter.createFromResource(this,R.array.all,android.R.layout.simple_spinner_item);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpinner.setAdapter(firstAdapter);

        secondAdapterDistances = ArrayAdapter.createFromResource(this,R.array.distances,android.R.layout.simple_spinner_item);
        secondAdapterDistances.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        secondAdapterWeights = ArrayAdapter.createFromResource(this,R.array.weights,android.R.layout.simple_spinner_item);
        secondAdapterWeights.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        secondAdapterVolume = ArrayAdapter.createFromResource(this,R.array.volume,android.R.layout.simple_spinner_item);
        secondAdapterVolume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String measureSelectedOnFirstSpinner = parent.getItemAtPosition(position).toString();
                String test = null;


                for (int i = 0; i < secondAdapterDistances.getCount(); i++) {
                    test = distances[i];
                    if (test.equals(measureSelectedOnFirstSpinner)) {
                        secondSpinner.setAdapter(secondAdapterDistances);
                        typeSelectedOnFirstSpinner = "distance";
                        measureSelectedOnFirstSpinnerG = measureSelectedOnFirstSpinner;


                    }
                }
                for (int i = 0; i < secondAdapterWeights.getCount(); i++) {
                    test = weights[i];
                    if (test.equals(measureSelectedOnFirstSpinner)) {
                        secondSpinner.setAdapter(secondAdapterWeights);
                        typeSelectedOnFirstSpinner = "weight";
                        measureSelectedOnFirstSpinnerG = measureSelectedOnFirstSpinner;


                    }
                }
                for (int i = 0; i < secondAdapterVolume.getCount(); i++) {
                    test = volume[i];
                    if (test.equals(measureSelectedOnFirstSpinner)) {
                        secondSpinner.setAdapter(secondAdapterVolume);
                        typeSelectedOnFirstSpinner = "volume";
                        measureSelectedOnFirstSpinnerG = measureSelectedOnFirstSpinner;


                    }
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String measureSelectedOnFirstSpinner = null;
            }
        });

        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                measureSelectedOnSecondSpinnerG = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }



//    public void convert(View p){
//        EditText entered = (EditText) findViewById(R.id.numberText);
//        double m = 3.28084;
//
//        enteredNumber = Double.parseDouble(entered.getText().toString());
//        convertedNumber = enteredNumber*m;
//
//        TextView result = (TextView) findViewById(R.id.targetText);
//        result.setText(convertedNumber + "");
//
//    }

    public double convertToCM(double number){
        double finalNumber=0;
        if (measureSelectedOnFirstSpinnerG.equals("Meters"))
            finalNumber = number * 100;
        else if (measureSelectedOnFirstSpinnerG.equals("Feet"))
            finalNumber = number * 30.48;
        else if (measureSelectedOnFirstSpinnerG.equals("Inches"))
            finalNumber = number * 2.54;
        else if (measureSelectedOnFirstSpinnerG.equals("Yard"))
            finalNumber = number * 91.44;
        else if (measureSelectedOnFirstSpinnerG.equals("Mile"))
            finalNumber = number * 160934;
        else if (measureSelectedOnFirstSpinnerG.equals("Centimeters"))
            finalNumber = number;
        return finalNumber;
    }

    public double convertDistance(double number){
        double convertedNumber=0;
        if (measureSelectedOnSecondSpinnerG.equals("Meters"))
            convertedNumber = number / 100;
        else if (measureSelectedOnSecondSpinnerG.equals("Feet"))
            convertedNumber = number * 0.0328084    ;
        else if (measureSelectedOnSecondSpinnerG.equals("Inches"))
            convertedNumber = number / 2.54;
        else if (measureSelectedOnSecondSpinnerG.equals("Yard"))
            convertedNumber = number / 91.44;
        else if (measureSelectedOnSecondSpinnerG.equals("Mile"))
            convertedNumber = number / 160934;
        else if (measureSelectedOnSecondSpinnerG.equals("Centimeters"))
            convertedNumber = number;
        return convertedNumber;

    }

    public double convertToLiters(double number){

        double finalNumber=0;
        if (measureSelectedOnFirstSpinnerG.equals("Pints"))
            finalNumber = number * 0.473176;
        else if (measureSelectedOnFirstSpinnerG.equals("Cups"))
            finalNumber = number * 0.236588;
        else if (measureSelectedOnFirstSpinnerG.equals("FluidOunces"))
            finalNumber = number * 0.0295735;
        else if (measureSelectedOnFirstSpinnerG.equals("Gallons"))
            finalNumber = number * 3.78541;
        else if (measureSelectedOnFirstSpinnerG.equals("Liters"))
            finalNumber = number;
        return finalNumber;


    }

    public double convertVolume(double number){

        double convertedNumber=0;
        if (measureSelectedOnSecondSpinnerG.equals("Pints"))
            convertedNumber = number * 2.11338;
        else if (measureSelectedOnSecondSpinnerG.equals("Cups"))
            convertedNumber = number * 4.22675    ;
        else if (measureSelectedOnSecondSpinnerG.equals("FluidOunces"))
            convertedNumber = number * 33.814;
        else if (measureSelectedOnSecondSpinnerG.equals("Gallons"))
            convertedNumber = number * 0.264172;
        else if (measureSelectedOnSecondSpinnerG.equals("Liters"))
            convertedNumber = number;
        return convertedNumber;


    }

    public double convertToGrams(double number){

        double convertedNumber=0;
        if (measureSelectedOnFirstSpinnerG.equals("Kilograms"))
            convertedNumber = number * 1000;
        else if (measureSelectedOnFirstSpinnerG.equals("Pounds"))
            convertedNumber = number * 453.592    ;
        else if (measureSelectedOnFirstSpinnerG.equals("Ounces"))
            convertedNumber = number * 28.3495;
        else if (measureSelectedOnFirstSpinnerG.equals("Grains"))
            convertedNumber = number * 0.0647989;
        else if (measureSelectedOnFirstSpinnerG.equals("Tons"))
            convertedNumber = number * 1000000;
        else if (measureSelectedOnFirstSpinnerG.equals("Grams"))
            convertedNumber = number;
        return convertedNumber;


    }

    public double convertWeight(double number){

        double convertedNumber=0;
        if (measureSelectedOnSecondSpinnerG.equals("Kilograms"))
            convertedNumber = number * 0.001;
        else if (measureSelectedOnSecondSpinnerG.equals("Pounds"))
            convertedNumber = number * 0.00220462    ;
        else if (measureSelectedOnSecondSpinnerG.equals("Ounces"))
            convertedNumber = number * 0.035274;
        else if (measureSelectedOnSecondSpinnerG.equals("Grains"))
            convertedNumber = number * 15.4324;
        else if (measureSelectedOnSecondSpinnerG.equals("Tons"))
            convertedNumber = number * 0.000001;
        else if (measureSelectedOnSecondSpinnerG.equals("Grams"))
            convertedNumber = number;
        return convertedNumber;

    }




    public void clickOnConvert(View v){
        EditText entered = (EditText) findViewById(R.id.numberText);
        enteredNumber = Double.parseDouble(entered.getText().toString());
        TextView result = (TextView) findViewById(R.id.targetText);

        if(typeSelectedOnFirstSpinner.equals("distance")){
            double x = convertToCM(enteredNumber);
            x = convertDistance(x);
            result.setText(x + "");
        }
        else if (typeSelectedOnFirstSpinner.equals("volume")){
            double x = convertToLiters(enteredNumber);
            x = convertVolume(x);
            result.setText(x + "");

        }

        else if (typeSelectedOnFirstSpinner.equals("weight")){
            double x = convertToGrams(enteredNumber);
            x = convertWeight(x);
            result.setText(x + "");

        }

        else
            result.setText(0 + "");

    }

}
