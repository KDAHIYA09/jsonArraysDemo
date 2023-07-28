package com.example.jasonarraydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView data;
    Button btn;
//    String JsonString = "{\n\"StudentData\":[\n{\n\"Ram\":\n{\n\"Name\":\"Ram\",\n\"Rollno\":\"1\",\n\"Course\":\"Java\"\n},\n\"Shyam\":\n{\n\"Name\":\"Shyam\",\n\"Rollno\":\"2\",\n\"Course\":\"C++\"\n},\n\"Geeta\":\n{\n\"Name\":\"Geeta\",\n\"Rollno\":\"3\",\n\"Course\":\"android\"\n},\n\"Ritu\":\n{\n\"Name\":\"Ritu\",\n\"Rollno\":\"4\",\n\"Course\":\"c++\"\n}\n}\n]\n}";
    String JsonString="{\n\"StudentData\":[\n\n\n{\n\"Name\":\"Ram\",\n\"Rollno\":\"1\",\n\"Course\":\"Java\"\n},\n\n{\n\"Name\":\"Shyam\",\n\"Rollno\":\"2\",\n\"Course\":\"C++\"\n},\n\n{\n\"Name\":\"Geeta\",\n\"Rollno\":\"3\",\n\"Course\":\"android\"\n},\n\n{\n\"Name\":\"Ritu\",\n\"Rollno\":\"4\",\n\"Course\":\"c++\"\n}\n\n]\n}";
    String dataTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.data);
        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jsonObject = new JSONObject(JsonString);

                    JSONArray jsonArray = jsonObject.optJSONArray("StudentData");
                    for (int i=0; i<jsonArray.length() ; i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String name = jsonObject1.optString("Name").toString();
                        String rollNo = jsonObject1.optString("Rollno").toString();
                        String course = jsonObject1.optString("Course").toString();

                        dataTemp+=("Student Record : " + "\n" + "Student Name : " + name + "\n" + "Student Roll no. : " + rollNo + "\n" + "Student Course :" + course + "\n") ;

                       Log.d("output", jsonArray.toString());
                    }
                    data.setText(dataTemp);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });



    }
}