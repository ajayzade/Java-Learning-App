package aj.java.lenovo.javalearning;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramsList extends AppCompatActivity {

    HashMap<String,List<String>> header;
    List<String> child;
    ExpandableListView expandableListView;
    CustomAdapter myAdapter;
    AdView mAdView;
    Intent intent;
    String[] s = new String[] {
            "file:///android_asset/HelloWorld.html",
            "file:///android_asset/Variables.html",
            "file:///android_asset/If.html",
            "file:///android_asset/IfElse.html",
            "file:///android_asset/NestedIfElse.html",
            "file:///android_asset/DoWhile.html",
            "file:///android_asset/While.html",
            "file:///android_asset/For.html",
            "file:///android_asset/Switch.html",
            "file:///android_asset/Goto.html",
            "file:///android_asset/Continue.html",
            "file:///android_asset/OneDArray.html",
            "file:///android_asset/MergeTwoArrays.html",
            "file:///android_asset/TransposeOfMatrix.html",
            "file:///android_asset/AdditionOfMatrices.html",
            "file:///android_asset/MultiplicationOfMatrices.html",
            "file:///android_asset/LinearSearch.html",
            "file:///android_asset/BinarySearch.html",
            "file:///android_asset/BubbleSort.html",
            "file:///android_asset/SelectionSort.html",
            "file:///android_asset/InsertionSort.html",
            "file:///android_asset/Instantiation.html",
            "file:///android_asset/ObjectAsArgument.html",
            "file:///android_asset/Constructor.html",
            "file:///android_asset/SimpleInheritence.html",
            "file:///android_asset/MultilevelInheritence.html",
            "file:///android_asset/HeirarichalInheritence.html",
            "file:///android_asset/Strings.html",
            "file:///android_asset/StringBuilders.html",
            "file:///android_asset/BinaryToDecimal.html",
            "file:///android_asset/DecimalToBinary.html",
            "file:///android_asset/TryCatchFinally.html",
            "file:///android_asset/NestedTryCatch.html",
            "file:///android_asset/MathClass.html",
            "file:///android_asset/RandomClass.html",
            "file:///android_asset/WriteInFile.html",
            "file:///android_asset/ReadFile.html",
            "file:///android_asset/Fibonacci.html"
    };

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_list);

        getSupportActionBar().setTitle("JAVA PROGRAMS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        expandableListView = (ExpandableListView) findViewById(R.id.expandable_listview);
        mAdView = (AdView) findViewById(R.id.adView4);

        AdRequest request = new AdRequest.Builder().build();
        mAdView.loadAd(request);

        header = Data.getInfo();
        child = new ArrayList<String>(header.keySet());
        myAdapter = new CustomAdapter(this,header,child);
        expandableListView.setAdapter(myAdapter);

        intent = new Intent(ProgramsList.this,ProgramView.class);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childName = header.get(child.get(groupPosition)).get(childPosition);
                Toast.makeText(ProgramsList.this, ""+childName, Toast.LENGTH_SHORT).show();
                switch(childName){
                    case "Hello World":
                        intent.putExtra("program_key",s[0]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Variables":
                        intent.putExtra("program_key",s[1]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "If":
                        intent.putExtra("program_key",s[2]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "If-else":
                        intent.putExtra("program_key",s[3]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Nested if-else":
                        intent.putExtra("program_key",s[4]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "do-while":
                        intent.putExtra("program_key",s[5]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "while":
                        intent.putExtra("program_key",s[6]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "for":
                        intent.putExtra("program_key",s[7]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "switch":
                        intent.putExtra("program_key",s[8]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "goto":
                        intent.putExtra("program_key",s[9]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "continue":
                        intent.putExtra("program_key",s[10]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "One dimensional Array":
                        intent.putExtra("program_key",s[11]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Merge Two Arrays":
                        intent.putExtra("program_key",s[12]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Transpose of Matrix":
                        intent.putExtra("program_key",s[13]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Addition of Matrix":
                        intent.putExtra("program_key",s[14]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Multiplication of Matrix":
                        intent.putExtra("program_key",s[15]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Linear Search":
                        intent.putExtra("program_key",s[16]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Binary Search":
                        intent.putExtra("program_key",s[17]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Bubble sort":
                        intent.putExtra("program_key",s[18]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Selection sort":
                        intent.putExtra("program_key",s[19]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Insertion sort":
                        intent.putExtra("program_key",s[20]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Instantiation":
                        intent.putExtra("program_key",s[21]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Object as Argument":
                        intent.putExtra("program_key",s[22]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Constructor":
                        intent.putExtra("program_key",s[23]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Simple":
                        intent.putExtra("program_key",s[24]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Multilevel":
                        intent.putExtra("program_key",s[25]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Hierarichal":
                        intent.putExtra("program_key",s[26]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Functions of Strings":
                        intent.putExtra("program_key",s[27]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Functions of StringBuilder":
                        intent.putExtra("program_key",s[28]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Binary to Decimal":
                        intent.putExtra("program_key",s[29]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Decimal to Binary":
                        intent.putExtra("program_key",s[30]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "try-catch-finally":
                        intent.putExtra("program_key",s[31]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "nested try-catch":
                        intent.putExtra("program_key",s[32]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Math class":
                        intent.putExtra("program_key",s[33]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Random class":
                        intent.putExtra("program_key",s[34]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Write":
                        intent.putExtra("program_key",s[35]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Read":
                        intent.putExtra("program_key",s[36]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;
                    case "Fibonacci series":
                        intent.putExtra("program_key",s[37]);
                        intent.putExtra("program_name",childName);
                        startActivity(intent);
                        break;

                }
                return true;
            }
        });

    }
}

class CustomAdapter extends BaseExpandableListAdapter{

    private Context cx;
    private HashMap<String,List<String>> childTitles;
    private List<String> headerTitles;

    CustomAdapter(Context cx,HashMap<String,List<String>> childTitles,List<String> headerTitles){
        this.cx = cx;
        this.childTitles = childTitles;
        this.headerTitles = headerTitles;
    }

    @Override
    public int getGroupCount() {
        return headerTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childTitles.get(headerTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childTitles.get(headerTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)this.getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_header,null);
        }
        TextView txt = (TextView)convertView.findViewById(R.id.list_header);
        txt.setTypeface(null,Typeface.BOLD);
        txt.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String)this.getChild(groupPosition,childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_childs,null);
        }
        TextView txt = (TextView)convertView.findViewById(R.id.list_childs);
        txt.setTypeface(null,Typeface.BOLD);
        txt.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

class Data{
    public static HashMap<String,List<String>> getInfo()
    {
        HashMap<String,List<String>> headerDetails = new HashMap<String, List<String>>();
        List<String> childDetails1 = new ArrayList<String>();
        childDetails1.add("Hello World");
        childDetails1.add("Variables");
        List<String> childDetails2 = new ArrayList<String>();
        childDetails2.add("If");
        childDetails2.add("If-else");
        childDetails2.add("Nested if-else");
        List<String> childDetails3 = new ArrayList<String>();
        childDetails3.add("do-while");
        childDetails3.add("while");
        childDetails3.add("for");
        childDetails3.add("Fibonacci series");
        List<String> childDetails4 = new ArrayList<String>();
        childDetails4.add("switch");
        childDetails4.add("goto");
        childDetails4.add("continue");
        List<String> childDetails5 = new ArrayList<String>();
        childDetails5.add("One dimensional Array");
        childDetails5.add("Merge Two Arrays");
        childDetails5.add("Transpose of Matrix");
        childDetails5.add("Addition of Matrix");
        childDetails5.add("Multiplication of Matrix");
        List<String> childDetails6 = new ArrayList<String>();
        childDetails6.add("Linear Search");
        childDetails6.add("Binary Search");
        List<String> childDetails7 = new ArrayList<String>();
        childDetails7.add("Bubble sort");
        childDetails7.add("Selection sort");
        childDetails7.add("Insertion sort");
        List<String> childDetails8 = new ArrayList<String>();
        childDetails8.add("Instantiation");
        childDetails8.add("Object as Argument");
        childDetails8.add("Constructor");
        List<String> childDetails9 = new ArrayList<String>();
        childDetails9.add("Simple");
        childDetails9.add("Multilevel");
        childDetails9.add("Hierarichal");
        List<String> childDetails10 = new ArrayList<String>();
        childDetails10.add("Functions of Strings");
        childDetails10.add("Functions of StringBuilder");
        List<String> childDetails11 = new ArrayList<String>();
        childDetails11.add("Binary to Decimal");
        childDetails11.add("Decimal to Binary");
        List<String> childDetails12 = new ArrayList<String>();
        childDetails12.add("try-catch-finally");
        childDetails12.add("nested try-catch");
        List<String> childDetails13 = new ArrayList<String>();
        childDetails13.add("Math class");
        childDetails13.add("Random class");
        List<String> childDetails14 = new ArrayList<String>();
        childDetails14.add("Write");
        childDetails14.add("Read");

        headerDetails.put("Simple",childDetails1);
        headerDetails.put("Conditional",childDetails2);
        headerDetails.put("Looping",childDetails3);
        headerDetails.put("Jump Statements",childDetails4);
        headerDetails.put("Arrays",childDetails5);
        headerDetails.put("Searching",childDetails6);
        headerDetails.put("Sorting",childDetails7);
        headerDetails.put("Object,classes and methods",childDetails8);
        headerDetails.put("Inheritence",childDetails9);
        headerDetails.put("Strings",childDetails10);
        headerDetails.put("Conversion",childDetails11);
        headerDetails.put("Exception Handling",childDetails12);
        headerDetails.put("Math and Random",childDetails13);
        headerDetails.put("File Handling",childDetails14);

        return headerDetails;
    }
}
