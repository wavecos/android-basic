package com.xiobit.reminders.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.xiobit.reminders.R;
import com.xiobit.reminders.model.Todo;

/**
 * Created by onix on 6/30/15.
 */
public class TodoArrayAdapter extends ArrayAdapter<Todo> {

    private final Context context;
    private final Todo[] values;

    public TodoArrayAdapter(Context context, Todo[] values) {

        super(context, R.layout.todo_item, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.todo_item, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.todoLabel);

        Todo t = values[position];

        textView.setText(t.getName());

        return rowView;
    }

}
