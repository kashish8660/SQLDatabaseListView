package com.example.backgroudtask;

//package com.codewithharry.jsonvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Log;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDbHandler db = new MyDbHandler(MainActivity.this, Params.DB_NAME, null, Params.DB_VERSION);
        Contacts kas = new Contacts("kashishbhai", "0909009090");
        db.addContacts(kas);
        Contacts las = new Contacts("lasssa", "09543365");
        db.addContacts(las);
        Contacts mashish = new Contacts("mashish", "647764764");
        db.addContacts(mashish);
        Log.d("kashish", "las and mashish's id are "+ las.getId()+ mashish.getId());
//        db.getContacts(0);
        List<Contacts> allContacts = db.getAllContacts();
        for (Contacts contact: allContacts) {
                Log.d("kashish", "id : "+ contact.getId() + "\n" +
                                            "name : "+ contact.getName() + "\n"+
                                        "number : "+contact.getNumber());
        }
    }
}

