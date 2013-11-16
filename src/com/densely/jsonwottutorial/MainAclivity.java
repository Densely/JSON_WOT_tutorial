package com.densely.jsonwottutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 16.11.13
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class MainAclivity extends Activity {

    private EditText etNames;
    private Button btnSearch;
    private ListView lvSearchName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        etNames = (EditText) findViewById(R.id.etName);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        lvSearchName = (ListView) findViewById(R.id.lvNameList);


    }

    public void search(View view){

    }


}
