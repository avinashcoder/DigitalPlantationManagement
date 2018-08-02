package avinash.digitalplantationmanagement.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,pword;
    Button save;
    String user="admin";
    String pass="12345";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.username);
        pword=(EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=uname.getText().toString();
                String password=pword.getText().toString();
                if(username.equals(user) && password.equals(pass)){
                    Intent i=new Intent(MainActivity.this,Manage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
