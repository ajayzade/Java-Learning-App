package aj.java.lenovo.javalearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;

public class TheoryList extends AppCompatActivity {

    private ListView listView;
    private String[] topicsNames = new String[] {
            "INTRODUCTION TO JAVA",
            "JDK,JRE AND JVM",
            "KEYWORDS OF JAVA",
            "DATA TYPES IN JAVA",
            "OPERATORS IN JAVA",
            "CONTROL STATEMENTS IN JAVA",
            "ITERATION STATEMENTS IN JAVA",
            "JUMP STATEMENTS IN JAVA",
            "METHODS IN JAVA",
            "ARRAY IN JAVA",
            "CLASSES AND OBJECTS",
            "CONSTRUCTOR IN JAVA",
            "INHERITENCE IN JAVA",
            "METHOD OVERRIDING AND OVERLOADING IN JAVA",
            "ABSTRACT CLASS AND METHODS IN JAVA",
            "INTERFACE,PACKAGES AND ACCESS CONTROL",
            "FINAL,STATIC AND OTHER KEYWORDS",
            "EXCEPTION HANDLING IN JAVA",
            "STRING AND STRINGBUFFER",
            "WRAPPER CLASSES IN JAVA",
            "FILE HANDLING IN JAVA",
            "JAVAFX FOR GRAPHICAL USER INTERFACE(GUI)"
    };
    private AdView mAdView;
    private String[] urls = new String[]{
            "file:///android_asset/Intro.html",
            "file:///android_asset/JDK.html",
            "file:///android_asset/Keywords.html",
            "file:///android_asset/DataTypes.html",
            "file:///android_asset/Operators.html",
            "file:///android_asset/ControlStatements.html",
            "file:///android_asset/Loops.html",
            "file:///android_asset/jump.html",
            "file:///android_asset/Methods.html",
            "file:///android_asset/Array.html",
            "file:///android_asset/ClassesObjects.html",
            "file:///android_asset/Constructors.html",
            "file:///android_asset/Inheritence.html",
            "file:///android_asset/Overloading.html",
            "file:///android_asset/Abstract.html",
            "file:///android_asset/Interface.html",
            "file:///android_asset/Final.html",
            "file:///android_asset/Exception.html",
            "file:///android_asset/String.html",
            "file:///android_asset/Wrapper.html",
            "file:///android_asset/File.html",
            "file:///android_asset/JavaFX.html"
    };

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_list);

        getSupportActionBar().setTitle("JAVA TOPICS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        listView = (ListView) findViewById(R.id.theory_list);
        mAdView = (AdView) findViewById(R.id.adView1);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,topicsNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.CYAN);
                Intent intent = new Intent(TheoryList.this,TheoryView.class);
                intent.putExtra("topic",topicsNames[position]);
                intent.putExtra("url",urls[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int i = item.getItemId();
        if (i == R.id.about){
            startActivity(new Intent(TheoryList.this,AboutUs.class));
        }
        if (i == R.id.reference){
            startActivity(new Intent(TheoryList.this,References.class));
        }
        return true;
    }

}
