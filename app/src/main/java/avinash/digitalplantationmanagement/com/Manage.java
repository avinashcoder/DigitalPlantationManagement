package avinash.digitalplantationmanagement.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Manage extends AppCompatActivity {

    private static final String TAG="ManageActivity";


    EditText journal;
    Button proceed,find,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        journal=(EditText)findViewById(R.id.journal);
        proceed=(Button)findViewById(R.id.proceedbutton);
        find=(Button)findViewById(R.id.findbutton);
        back=(Button)findViewById(R.id.backbutton);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jrnl=journal.getText().toString();
                if(!jrnl.equals("")){
                    Intent i=new Intent(Manage.this,PlantationYear.class);
                    i.putExtra("data",jrnl);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Plese fill the Journel Number",Toast.LENGTH_SHORT).show();
                }
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(Manage.this,SelectJournal.class);
                startActivity(ii);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii=new Intent(Manage.this,MainActivity.class);
                startActivity(iii);
            }
        });

    }
    /**/
}
