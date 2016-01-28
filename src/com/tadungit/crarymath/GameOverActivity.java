package com.tadungit.crarymath;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends Activity implements OnClickListener {

	private TextView mtvGameOver;
	private TextView mtvYourScore;
	private TextView mtvScore;
	private Typeface mTypeface;

	private Button mbtTryAgain;
	private Button mbtHome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameover);

		mTypeface = Typeface
				.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");

		mtvGameOver = (TextView) findViewById(R.id.tv_game_over);
		mtvYourScore = (TextView) findViewById(R.id.tv_your_score);
		mtvScore = (TextView) findViewById(R.id.tv_score);
		int score = getIntent().getExtras().getInt(PlayActivity.SCORE);
		mtvScore.setText("" + score);

		mtvGameOver.setTypeface(mTypeface);
		mtvYourScore.setTypeface(mTypeface);
		mtvScore.setTypeface(mTypeface);

		mbtTryAgain = (Button) findViewById(R.id.bt_try_again);
		mbtHome = (Button) findViewById(R.id.bt_home);
		mbtTryAgain.setOnClickListener(this);
		mbtHome.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.bt_try_again:
			Intent intent = new Intent(GameOverActivity.this,
					PlayActivity.class);
			startActivity(intent);
			finish();
			break;

		case R.id.bt_home:
			finish();
			break;

		default:
			break;
		}
	}
}
