package com.example.backgroudtask;

//package com.codewithharry.jsonvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.backgroudtask.contacts.Contacts;
import com.example.backgroudtask.data.MyDbHandler;
import com.example.backgroudtask.params.Params;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDbHandler db = new MyDbHandler(MainActivity.this, Params.DB_NAME, null, Params.DB_VERSION);

//      adding numbers in contact list

//        Contacts kas = new Contacts();
//        db.addContacts(kas); //In this case id of 'kas' object is 0 but database automatically incremental value daal dega row me
//        Contacts las = new Contacts("zero", "09543365");
//        db.addContacts(las);
//        Contacts mashish = new Contacts("mashish", "647764764");
//        db.addContacts(mashish);
//        Log.d("kashish", "las and mashish's id are "+ las.getId()+ mashish.getId());

        //Updating some contact

//        Contacts mithu = new Contacts(57,"mithunew57", "1111111111"); //here passing 'id' makes sense but not while using addContacts() function. Cuz whatever 'id' you pas while adding contact, it'll take incremental value only.
//        db.updateContact(mithu);

        //Detele a contact
//        db.deleteContact(65);

        //getting whole contact List

        List<Contacts> allContacts = db.getAllContacts();
        for (Contacts contact: allContacts) {
                Log.d("kashish", "id : "+ contact.getId() + "\n" +
                                            "name : "+ contact.getName() + "\n"+
                                        "number : "+contact.getNumber());
        }

        //get count of number of contacts present in the List

//        Log.d("kashish", String.valueOf(db.getCount()));

        //Putting these contacts in a ListView

        ArrayList<String> name = new ArrayList<>();
        for (Contacts contact:allContacts) {
            name.add(contact.getName()+"  :  "+contact.getNumber());
        }
        listView = findViewById(R.id.listview);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(ad);
    }
}

