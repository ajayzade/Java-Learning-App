package aj.java.lenovo.javalearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class References extends AppCompatActivity {

    private TextView textView;
    private String str;
    private InterstitialAd mInterstitialAd;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        getSupportActionBar().setTitle("References");

        str = "Java Learning" + "\n\n" + "www.tutorialspoint.com" + "\n" + "www.javapoint.com" + "\n" + "Book : " +
                "Y. Daniel Liang-Introduction to Java Programming,Brief Version-Prentice Hall(2012)";

        textView = (TextView) findViewById(R.id.reference_textview);

        textView.setText(str);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2919657393459579/4559719708");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        intent = new Intent(References.this,MainActivity.class);

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try{
            mInterstitialAd.show();
        }finally {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

}
