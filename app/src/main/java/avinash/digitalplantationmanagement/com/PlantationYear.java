package avinash.digitalplantationmanagement.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PlantationYear extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText p_year;
    Spinner spinner;
    Button backplant,proceed;
    String journal;
    String range="Select";

    DatabasesHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantation_year);

        mDatabaseHelper=new DatabasesHelper(this);

        journal=getIntent().getExtras().getString("data");

        backplant=(Button)findViewById(R.id.backbuttonplant);
        p_year=(EditText)findViewById(R.id.p_year);
        proceed=(Button)findViewById(R.id.proceedfinal);
        spinner=(Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.range, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        backplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(PlantationYear.this,Manage.class);
                startActivity(j);
            }
        });
        proceed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String year=p_year.getText().toString();
                        if(p_year.length()!=4)
                        {
                            Toast.makeText(getApplicationContext(), "Plese Enter Valid Year", Toast.LENGTH_SHORT).show();
                        }
                        else if(range.equals("Select")){
                            Toast.makeText(getApplicationContext(), "Plese Select Range then Proceed ", Toast.LENGTH_SHORT).show();
                        }
                        else if(p_year.length()==4 && range !="Select") {
                            AddData(journal, p_year.getText().toString(), range);

                        }

                    }
                }
        );
    }
    public void AddData(String journal,String year,String range){
        boolean insertData= mDatabaseHelper.addData(journal,year,range);

        if(insertData==true){
            Toast.makeText(this,"Data Uploaded Successfully",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(PlantationYear.this,Manage.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Something Wrong...Failed",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        range=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
