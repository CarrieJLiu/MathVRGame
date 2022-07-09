package com.cst2335.chatroomactivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ChatRoomActivity2 extends AppCompatActivity {

    Button sd;
    Button rc;
    EditText edit;
//    RecyclerView rView;
//    RecyclerView.ViewHolder viewHolder;
    MyAdapter theAdapter; //<<cannot be anonymous<<
    ListView rView;
    ArrayList<Message> messages = new ArrayList<>();
    private static int ACTIVITY_VIEW_CONTACT = 33;
    SQLiteDatabase db;
    MyOpener myOpener;
    int positionClicked = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room2);

        sd = findViewById(R.id.send);
        rc = findViewById(R.id.receive);
        edit = findViewById(R.id.editText);
        rView = findViewById(R.id.myRecycleView);
        theAdapter = new ChatRoomActivity2.MyAdapter();

        //create an adapter object and send it to the listVIew
        theAdapter = new MyAdapter();
        rView.setAdapter((ListAdapter) theAdapter);
        //initialize it in onCreate

        loadDataFromDatabase(); //get any previously saved Contact objects


//        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setOnItemClickListener(( parent,  view,  position,  id) -> {
            showContact( position );
        });

        //send button
        sd.setOnClickListener(click -> {
            String whatIsTyped = edit.getText().toString();
            ContentValues newRowValues = new ContentValues();
            if (!whatIsTyped.isEmpty()) {


                ContentValues newRow = new ContentValues();// like intent or Bundle

                //Message column:
                newRow.put(MyOpener.COL_MESSAGE, whatIsTyped);


                long id = db.insert(MyOpener.TABLE_NAME, null, newRow); //returns the id

                Message cm = new Message(whatIsTyped, id);

                //adding a new message to our history:
                messages.add(cm); //what is the database id?

                edit.setText("");//clear the text

                //notify that new data was added at a row:
                theAdapter.notifyDataSetChanged(); //at the end of ArrayList,
                // call onCreateViewHolder, onBindViewHolder()
            }
        });


        //receive button
        rc.setOnClickListener( click -> {
            String whatIsTyped = edit.getText().toString();

            if (!whatIsTyped.isEmpty()) {


                ContentValues newRow = new ContentValues();// like intent or Bundle

                //Message column:
                newRow.put(MyOpener.COL_MESSAGE, whatIsTyped);

                long id = db.insert(MyOpener.TABLE_NAME, null, newRow); //returns the id

                Message cm = new Message(whatIsTyped, id);

                //adding a new message to our history:
                messages.add(cm); //what is the database id?

                edit.setText("");//clear the text

                //notify that new data was added at a row:
                theAdapter.notifyDataSetChanged(); //at the end of ArrayList,

            }
        });
    }



    private void loadDataFromDatabase()
    {
        //get a database connection:
        MyOpener dbOpener = new MyOpener(this);
        db = dbOpener.getWritableDatabase(); //This calls onCreate() if you've never built the table before, or onUpgrade if the version here is newer


        // We want to get all of the columns. Look at MyOpener.java for the definitions:
        String [] columns = {MyOpener.COL_ID, MyOpener.COL_MESSAGE};
        //query all the results from the database:
        Cursor results = db.query(false, MyOpener.TABLE_NAME, columns, null, null, null, null, null, null);

        //Now the results object has rows of results that match the query.
        //find the column indices:
        int messageColumnIndex = results.getColumnIndex(MyOpener.COL_MESSAGE);
        int idColIndex = results.getColumnIndex(MyOpener.COL_ID);

        //iterate over the results, return true if there is a next item:
        while(results.moveToNext())
        {
            String messageTyped = results.getString(messageColumnIndex);

            long id = results.getLong(idColIndex);

            //add the new Contact to the array list:
            messages.add(new Message(messageTyped, id));
        }

        //At this point, the contactsList array has loaded every row from the cursor.
    }

    protected void showContact(int position)
    {
        Message selectedContact = messages.get(position);

        View contact_view = getLayoutInflater().inflate(R.layout.contact_edit, null);
        //get the TextViews
        EditText rowName = contact_view.findViewById(R.id.row_name);

        TextView rowId = contact_view.findViewById(R.id.row_id);

        //set the fields for the alert dialog
        rowName.setText(selectedContact.getMessageTyped());
        rowId.setText("id:" + selectedContact.getId());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You clicked on item #" + position)
                .setMessage("You can update the fields and then click update to save in the database")
                .setView(contact_view) //add the 3 edit texts showing the contact information
                .setPositiveButton("Update", (click, b) -> {
                    selectedContact.update(rowName.getText().toString());
                    updateContact(selectedContact);
                    theAdapter.notifyDataSetChanged(); //the email and name have changed so rebuild the list
                })
                .setNegativeButton("Delete", (click, b) -> {
                    deleteContact(selectedContact); //remove the contact from database
                    messages.remove(position); //remove the contact from contact list
                    theAdapter.notifyDataSetChanged(); //there is one less item so update the list
                })
                .setNeutralButton("dismiss", (click, b) -> { })
                .create().show();
    }

    protected void updateContact(Message c)
    {
        //Create a ContentValues object to represent a database row:
        ContentValues updatedValues = new ContentValues();
        updatedValues.put(MyOpener.COL_MESSAGE, c.getMessageTyped());


        //now call the update function:
        db.update(MyOpener.TABLE_NAME, updatedValues, MyOpener.COL_ID + "= ?", new String[] {Long.toString(c.getId())});
    }

    protected void deleteContact(Message c)
    {
        db.delete(MyOpener.TABLE_NAME, MyOpener.COL_ID + "= ?", new String[] {Long.toString(c.getId())});
    }


    private class MyAdapter extends BaseAdapter{
        public int getCount() { return messages.size();}

//        public Object getItem(int position) { return "This is row " + position; }
public Message getItem(int position){
    return messages.get(position);
}

        public long getItemId(int position) { return position; }

        public View getView(int position, View old, ViewGroup parent)
        {
            View newView = getLayoutInflater().inflate(R.layout.right_row2, parent, false );
            Message thisRow = getItem(position);
            //get the TextViews
            TextView rowName = (TextView)newView.findViewById(R.id.ReceiveView);
            TextView rowId = (TextView)newView.findViewById(R.id.row_id);
            //update the text fields:
            rowName.setText(  thisRow.getMessageTyped());
            rowId.setText("id:" + thisRow.getId());
            //return the row:
            return newView;
        }





//        {
//            LayoutInflater inflater = getLayoutInflater();
//
//            //make a new row:
//            View newView = inflater.inflate(R.layout.left_row2, parent, false);
//            //set what the text should be for this row:
//            TextView tView = newView.findViewById(R.id.sendView);
//            tView.setText( getItem(position).toString() );
//
//            //You will need to make the change in row_layout as well
//            //Button b =  newView.findViewById(R.id.textGoesHere);
//            //b.setText( getItem(position).toString() );
//            //return it to be put in the table
//            return newView;
//        }

    }


//    public class MyAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder >  {
//
//        //        Context context;
//        RecyclerView.ViewHolder viewHolder;
//        //        RecyclerView.ViewHolder viewHolder;
//        @NonNull
//        @Override
//        // 再建LIFT_ROW!
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//            switch (viewType) {
//                case 0:
////                    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//                    return new ViewHolder1(inflater.inflate(R.layout.left_row2, parent, false));
//                case 1:
////                    LayoutInflater inflater2 = LayoutInflater.from(parent.getContext());
//                    return new ViewHolder2(inflater.inflate(R.layout.right_row2, parent, false));
//
////                    return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.left_row2, parent, false));
//            }
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return super.getItemId(position);
//        }
//
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
////            Message viewHolder = messages.get(position);
//
//            switch( getItemViewType(position)){
//                case 0:
//                    Message ViewHolder1 = messages.get(position);
//                    ViewHolder1 holder1 = (ViewHolder1)holder;
//                    holder1.messageView1.setText(ViewHolder1.getMessageTyped());
//                    break;
//                case 1:
//                    Message ViewHolder2 = messages.get(position);
//                    ViewHolder2 holder2 = (ViewHolder2)holder;
//
//                    holder2.messageView2.setText( ViewHolder2.getMessageTyped());
//                    break;
//
//            }
//        }
//
//        @Override
//        public int getItemCount() {
//            return messages.size();
//        }
//
//    }

//    public class ViewHolder1 extends RecyclerView.ViewHolder{
//
//        TextView messageView1;
//
//        public ViewHolder1(View itemView) {
//            super(itemView);
//            messageView1 = itemView.findViewById(R.id.sendView);
//
//                itemView.setOnClickListener( click -> {
//                    int position = getAdapterPosition();//which row was clicked.
//                    Message whatWasClicked = messages.get(position);
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder( ChatRoomActivity2.this );
//
//                    builder.setTitle("Question:")
//                            .setMessage("Do you want to delete this:" + whatWasClicked.getMessageTyped())
//                            .setNegativeButton("Negative", (dialog, click1)->{ })
//                            .setPositiveButton("Positive", (dialog, click2)->{
//                                //actually delete something:
//                                messages.remove(position);
//                                theAdapter.notifyItemRemoved(position);
//                                Snackbar.make(sd, "You removed item # " + position, Snackbar.LENGTH_LONG)
//                                        .setAction("Undo", (click4)-> {
//                                            messages.add(position, whatWasClicked);
//                                            theAdapter.notifyItemInserted(position);
//                                            //reinsert into the database
//                                            db.execSQL( String.format( Locale.CANADA, " Insert into %s values (\"%d\", \"%s\", \"%d\", \"%s\" );",
//                                                    MyOpener.TABLE_NAME      , whatWasClicked.getId()  , whatWasClicked.getMessageTyped() , 1 ));
//
//                                        })
//                                        .show();
//                                db.delete(MyOpener.TABLE_NAME,
//                                        MyOpener.COL_ID +" = ?", new String[] { Long.toString( whatWasClicked.getId() )  });
//                            }).create().show();
//                });
//        }
//    }
//
//    public class ViewHolder2 extends RecyclerView.ViewHolder{
//
//         TextView messageView2;
//
//        //View will be a ConstraintLayout
//        public ViewHolder2(View itemView) {
//            super(itemView);
//            messageView2 = itemView.findViewById(R.id.ReceiveView);
//
//                itemView.setOnClickListener( click -> {
//                    int position = getAdapterPosition();//which row was clicked.
//                    Message whatWasClicked = messages.get(position);
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder( ChatRoomActivity2.this );
//
//                    builder.setTitle("Question:")
//                            .setMessage("Do you want to delete this:" + whatWasClicked.getMessageTyped())
//                            .setNegativeButton("Negative", (dialog, click1)->{ })
//                            .setPositiveButton("Positive", (dialog, click2)->{
//                                //actually delete something:
//                                messages.remove(position);
//                                theAdapter.notifyItemRemoved(position);
//                            }).create().show();
//                });
//        }
    }

