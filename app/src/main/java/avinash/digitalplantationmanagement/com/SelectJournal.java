package avinash.digitalplantationmanagement.com;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectJournal extends AppCompatActivity {
    Button backselect;
    Spinner spinner;

    DatabasesHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_journal);
        backselect=(Button)findViewById(R.id.backbuttonselect);
        spinner=(Spinner)findViewById(R.id.spinner_select);

        mDatabaseHelper=new DatabasesHelper(this);
        Cursor data=mDatabaseHelper.getListContent();

        ArrayList<String> list =new ArrayList<>();
        list.add("Select");
        if(data.getCount()>0){
            while (data.moveToNext()){
                String journals=data.getString(data.getColumnIndex("JOURNALS"));
                list.add(journals);
            }
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);


        backselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelectJournal.this,Manage.class);
                startActivity(i);
            }
        });
    }
}
