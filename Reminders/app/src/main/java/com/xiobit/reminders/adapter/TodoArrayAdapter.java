package com.xiobit.reminders.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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


//public class TodoArrayAdapter extends RecyclerView.Adapter<TodoArrayAdapter.TodoViewHolder> {
//
//    private Todo[] todos;
//
//    public static class TodoViewHolder extends RecyclerView.ViewHolder {
//        CardView cv;
//        TextView todoLabel;
//
//        TodoViewHolder(View itemView) {
//            super(itemView);
//            cv = (CardView) itemView.findViewById(R.id.todoCardView);
//            todoLabel = (TextView) itemView.findViewById(R.id.todoLabel);
//        }
//
//    }
//
//    public TodoArrayAdapter(Todo[] todos) {
//        this.todos = todos;
//    }
//
//    @Override
//    public int getItemCount() {
//        return todos.length;
//    }
//
//    @Override
//    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
//        TodoViewHolder tvh = new TodoViewHolder(v);
//        return tvh;
//    }
//
//    @Override
//    public void onBindViewHolder(TodoViewHolder holder, int position) {
//        holder.todoLabel.setText(todos[position].getName());
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }
//}




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

