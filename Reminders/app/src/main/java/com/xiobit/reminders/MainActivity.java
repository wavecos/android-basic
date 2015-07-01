package com.xiobit.reminders;

import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.xiobit.reminders.adapter.TodoArrayAdapter;
import com.xiobit.reminders.model.Todo;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "Reminder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testSaveTodo();

        Realm realm = Realm.getInstance(this);

        RealmResults<Todo> results = realm.where(Todo.class)
                                        .findAll();

        Todo[] todos = results.toArray(new Todo[results.size()]);

        // Show List
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new TodoArrayAdapter(this, todos));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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


    // Realm Tests

    public void testSaveTodo() {
        Log.d(TAG, "***** Realm Integration *****");

        Realm realm = Realm.getInstance(this);

        Log.d(TAG, "Realm Path: " + realm.getPath());

        realm.beginTransaction();
        Todo todo1 = realm.createObject(Todo.class);
        todo1.setName("Test 1 de Realm");
        todo1.setDate(new Date());
        todo1.setPriority(1);
        realm.commitTransaction();

    }

}
