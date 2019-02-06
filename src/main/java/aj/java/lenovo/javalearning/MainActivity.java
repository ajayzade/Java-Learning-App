package aj.java.lenovo.javalearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.yasic.library.particletextview.MovingStrategy.BidiHorizontalStrategy;
import com.yasic.library.particletextview.Object.ParticleTextViewConfig;
import com.yasic.library.particletextview.View.ParticleTextView;


public class MainActivity extends AppCompatActivity {

    private ParticleTextView p1,p2;
    private GridView gridView;
    private String[] s = new String[] {
            "THEORY",
            "PROGRAMS",
            "QUESTIONS",
            "SOFTWARES",
            "ABOUT US",
            "REFERENCE"
    };
    private AdView mAdView;
    private MediaPlayer mediaPlayer;
    private InterstitialAd mInterstitialAd;



    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = (ParticleTextView) findViewById(R.id.one);
        p2 = (ParticleTextView) findViewById(R.id.two);
        gridView = (GridView) findViewById(R.id.grid);
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2919657393459579/4559719708");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        ParticleTextViewConfig c1 = new ParticleTextViewConfig.Builder()
                .setTargetText("Welcome To Java")
                .setReleasing(0.4)
                .setParticleRadius(4)
                .setMiniDistance(1)
                .setTextSize(120)
                .setRowStep(9)
                .setColumnStep(9)
                .instance();
        p1.setConfig(c1);

        BidiHorizontalStrategy m = new BidiHorizontalStrategy();

        ParticleTextViewConfig c2 = new ParticleTextViewConfig.Builder()
                .setTargetText("JAVA")
                .setReleasing(0.3)
                .setParticleRadius(4)
                .setMiniDistance(0.01)
                .setTextSize(130)
                .setRowStep(8)
                .setColumnStep(8)
                .setMovingStrategy(m)
                .instance();
        p2.setConfig(c2);

        p1.startAnimation();
        p2.startAnimation();

        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

        mediaPlayer = MediaPlayer.create(this,R.raw.clicker);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this,TheoryList.class));
                }
                if (position == 1){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this,ProgramsList.class));
                }
                if (position == 2){
                    mediaPlayer.start();
                    if (mInterstitialAd.isLoaded()){
                        mInterstitialAd.show();
                    }else {
                        startActivity(new Intent(MainActivity.this, Questions.class));
                    }
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            startActivity(new Intent(MainActivity.this, Questions.class));
                        }
                    });
                }
                if (position == 3){
                    mediaPlayer.start();
                    if (mInterstitialAd.isLoaded()){
                        mInterstitialAd.show();
                    }else {
                        startActivity(new Intent(MainActivity.this, Softwares.class));
                    }
                    mInterstitialAd.setAdListener(new AdListener(){
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            startActivity(new Intent(MainActivity.this, Softwares.class));
                        }
                    });
                }
                if (position == 4){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this,AboutUs.class));
                }
                if (position == 5){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this,References.class));
                }
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
            if (mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
            }else {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
        }
        if (i == R.id.reference){
            if (mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
            }else {
                startActivity(new Intent(MainActivity.this, References.class));
            }
        }
        return true;
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return s.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View v = inflater.inflate(R.layout.custom_grid,parent,false);
            TextView t = v.findViewById(R.id.custom_textview);
            t.setText(s[position]);
            return v;
        }
    }

}
