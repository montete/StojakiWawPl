package pl.waw.stojaki.android.stojakiwawpl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;


public class MenuActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button2 = (Button)findViewById(R.id.button2);

        Button button4 = (Button)findViewById(R.id.button4);
        button2.setOnClickListener(this);

        button4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        Intent intent = null;
        switch(v.getId()){
            case R.id.button2:
                intent = new Intent(this, StojakiMapa.class);
                break;
            case R.id.button4:
                intent = new Intent(this, AboutProject.class);
                break;

        }
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
    public void clickAbout(View view){
        Intent intent = new Intent(this, AboutProject.class);
        startActivity(intent);
        finish();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
