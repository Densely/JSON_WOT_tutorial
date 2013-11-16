package com.densely.jsonwottutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 16.11.13
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class MainActivity extends Activity implements OnPlayerSearchListener {

    private EditText etNames;
    private ListView lvSearchName;
    private Api mApi;
    private SearchPlayerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        etNames = (EditText) findViewById(R.id.etName);

        lvSearchName = (ListView) findViewById(R.id.lvNameList);

        mApi = new Api(getApplicationContext());
        mApi.setOnPlayerChangeListener(this);


    }

    public void search(View view) {

        mApi.searchPlayer(etNames.getText().toString());

    }

    @Override
    public void onPlayerSearch(ArrayList<String> players) {
        mAdapter = new SearchPlayerAdapter(getApplicationContext(), players);
        lvSearchName.setAdapter(mAdapter);

    }
}
