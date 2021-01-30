package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    Context context;
    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvScreenName;
    TextView tvTimestamp;

    public DetailActivity() {
        context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvBody = findViewById(R.id.tvBody);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvTimestamp = findViewById(R.id.tvTimestamp);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvBody.setText(tweet.body);
        tvScreenName.setText(tweet.user.screenName);
        Glide.with(context).load(tweet.user.imageURL).into(ivProfileImage);
        tvTimestamp.setText(tweet.getFormattedTimestamp());
    }
}