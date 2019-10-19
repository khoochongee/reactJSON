package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONTutorial extends AppCompatActivity {
    private Button btnGetName,btnGetCourse,btnGetAge,btnGetBooks,btnGetLibraryId,btnGetBorrowedBooks,btnGetStatus,btnGetFriends,btnBack;
    private TextView tvDisplay;
    private String myJSONObjectString="{\n" +
            "  \"name\": \"Khoo Chong Ee\",\n" +
            "  \"courseName\": \"Web Development\",\n" +
            "  \"age\": \"19\",\n" +
            "  \"libraryProfile\": {\n" +
            "    \"id\": \"0003\",\n" +
            "    \"borrowBooks\": [\n" +
            "      \"Rich Dad\",\n" +
            "      \"DeepLearning\",\n" +
            "      \"Think And Grow Rich\",\n" +
            "      \"Leader Golden Principle\"\n" +
            "    ],\n" +
            "    \"numberOfBorrowedBooks\": \"4\",\n" +
            "    \"status\": \"true\"\n" +
            "  },\n" +
            "  \"friends\": [\n" +
            "    {\n" +
            "      \"name\": \"Robert\",\n" +
            "      \"status\": \"Best Friend\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Justin Bieber\",\n" +
            "      \"status\": \"unfriended\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"JSON\",\n" +
            "      \"status\": \"normal friend\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Katty\",\n" +
            "      \"status\": \"girl friend\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private JSONObject myJSONObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        findViews();
        setListeners();
        prepareJSON();
    }

    private void findViews(){
        btnGetName=findViewById(R.id.btnGetName);
        btnGetAge=findViewById(R.id.btnGetAge);
        btnGetCourse=findViewById(R.id.btnGetCourse);
        btnGetBooks=findViewById(R.id.btnGetBooks);
        btnGetLibraryId=findViewById(R.id.btnGetLibraryId);
        btnGetBorrowedBooks=findViewById(R.id.btnGetBorrowedBooks);
        btnGetStatus=findViewById(R.id.btnGetStatus);
        btnGetFriends=findViewById(R.id.btnGetFriends);
        btnBack=findViewById(R.id.btnBack);
        tvDisplay=findViewById(R.id.tvDisplay);
    }

    private void setListeners(){
        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name=myJSONObject.getString("name");
                    tvDisplay.setText(name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGetAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String age = myJSONObject.getString("age");
                    tvDisplay.setText(age);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGetCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String course=myJSONObject.getString("courseName");
                    tvDisplay.setText(course);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGetBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray bookArray=new JSONArray(myJSONObject.getString("borrowedBooks"));
                    String result="";
                    for(int i=0;i<bookArray.length();i++){
                        result+=bookArray.getString(i)+"\n";
                    }
                    tvDisplay.setText(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGetLibraryId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject libraryJSONObject=new JSONObject(myJSONObject.getString("libraryProfile"));  //JSONObject libraryJSONObject=myJSONObject.getJSoNObject("libraryProfile"));
                    String libraryId=libraryJSONObject.getString("id");
                    tvDisplay.setText(libraryId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGetBorrowedBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject borrowedBooks=new JSONObject(myJSONObject.getString("libraryProfile"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGetFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray friendsArray=myJSONObject.getJSONArray("friends");
                    for (int i=0;i<friendsArray.length();i++){
                        JSONObject friend=friendsArray.getJSONObject(i);
                        String name=friend.getString("name");
                        if(name.equalsIgnoreCase("justin bieber")){
                            tvDisplay.setText(friend.getString("status"));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void prepareJSON(){
        try {
            myJSONObject=new JSONObject(myJSONObjectString);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
