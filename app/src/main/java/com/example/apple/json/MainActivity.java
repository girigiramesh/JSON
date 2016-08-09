package com.example.apple.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn_show;
    TextView  text_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_show = (TextView) findViewById(R.id.text_show);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strJson = " {\"Employee\" :[ {\"id\":\"01\",\"name\":\"hari\",\"salary\":\"500000\"},{\"id\":\"02\",\"name\":\"Sai\",\"salary\":\"500000\"},{\"id\":\"03\",\"name\":\"Suresh\",\"salary\":\"600000\"} ]}";
                String data = "";
                try {
                    JSONObject jsonRootObject = new JSONObject(strJson);

                    //Get the instance of JSONArray that contains JSONObjects
                    JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

                    //Iterate the jsonArray and print the info of JSONObjects
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = Integer.parseInt(jsonObject.optString("id").toString());
                        String name = jsonObject.optString("name").toString();
                        float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                        data += "Employee:" + i + " : \n id= " + id + " \n Name= " + name + " \n Salary= " + salary + " \n ";
                    }
                    text_show.setText(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
