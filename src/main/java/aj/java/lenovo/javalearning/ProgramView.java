package aj.java.lenovo.javalearning;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProgramView extends AppCompatActivity {

    private WebView webView;
    private String s,n;
    private WebSettings settings;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_view);

        getSupportActionBar().setTitle("Java Programs");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.program_webview);
        txt = (TextView) findViewById(R.id.program_name);

        s = getIntent().getStringExtra("program_key");
        n = getIntent().getStringExtra("program_name");

        webView.loadUrl(s);
        txt.setText(n);

        settings = webView.getSettings();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.second_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int i = item.getItemId();
        if (i == R.id.font){
            changeFont();
        }
        return true;
    }

    private void changeFont() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProgramView.this);
        View v = getLayoutInflater().inflate(R.layout.custom_font,null);
        RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.radiog);
        final RadioButton r1 = (RadioButton) v.findViewById(R.id.ten);
        final RadioButton r2 = (RadioButton) v.findViewById(R.id.twenty);
        final RadioButton r3 = (RadioButton) v.findViewById(R.id.thirty);
        final RadioButton r4 = (RadioButton) v.findViewById(R.id.forty);
        final RadioButton r5 = (RadioButton) v.findViewById(R.id.fifty);
        Button b = (Button) v.findViewById(R.id.font_setter_btn);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()){
                    settings.setDefaultFontSize(10);
                }
                if(r2.isChecked()){
                    settings.setDefaultFontSize(20);
                }
                if (r3.isChecked()){
                    settings.setDefaultFontSize(30);
                }
                if (r4.isChecked()){
                    settings.setDefaultFontSize(40);
                }
                if (r5.isChecked()){
                    settings.setDefaultFontSize(50);
                }
                dialog.dismiss();
            }
        });
    }

}
