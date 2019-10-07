package com.aaa.wisewordsinlife.Activity;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aaa.wisewordsinlife.BuildConfig;
import com.aaa.wisewordsinlife.R;

public class MainActivity extends AppCompatActivity {
    CardView wiseW, encourageW, rateMe, followOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wiseW = findViewById(R.id.wiseWord);
        encourageW = findViewById(R.id.encourageWords);
        rateMe = findViewById(R.id.rateUs);
        followOn = findViewById(R.id.followUs);
        wiseW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wiseWordActivity();
            }
        });

        encourageW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attitudeQActivity();
            }
        });

        rateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=${this.packageName}")
                        )
                );

            }
        });

        followOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/imran_sk_96/"));
                startActivity(intent);
            }
        });

    }

    private void attitudeQActivity() {
        Intent intent = new Intent(this, CourageAndStrengthQuotes_AttitudeQActivity.class);
        startActivity(intent);

    }

    private void wiseWordActivity() {
        Intent intent = new Intent(this, WisdomQuotes_MainActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//menu
        getMenuInflater().inflate(R.menu.pager_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share) {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage = "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }
        }
        return true;
    }
}
