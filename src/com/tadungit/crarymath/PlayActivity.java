package com.tadungit.crarymath;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity implements OnClickListener, Runnable {

	public static final String SCORE = "SCORE";

	private TextView mtvScore;
	private TextView mtvBest;
	private TextView mtvTimer;
	private TextView mtvQuestion;
	private Typeface mTypeface;

	private Button[] mbtOptions;

	private Random mRandom;

	private int mNumber0;
	private int mNumber1;
	private int mResult;
	private int[] mOptions;
	private int mTimer;
	private int mScore;
	private int mRight;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		mRandom = new Random();
		mHandler = new Handler();
		mTypeface = Typeface
				.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");

		mtvScore = (TextView) findViewById(R.id.tv_score);
		mtvBest = (TextView) findViewById(R.id.tv_best);
		mtvTimer = (TextView) findViewById(R.id.tv_timer);
		mtvQuestion = (TextView) findViewById(R.id.tv_question);

		mtvScore.setTypeface(mTypeface);
		mtvBest.setTypeface(mTypeface);
		mtvTimer.setTypeface(mTypeface);
		mtvQuestion.setTypeface(mTypeface);

		mbtOptions = new Button[3];
		for (int i = 0; i < mbtOptions.length; i++) {
			mbtOptions[i] = (Button) findViewById(R.id.bt_option_0 + i);
			mbtOptions[i].setTypeface(mTypeface);
			mbtOptions[i].setOnClickListener(this);
		}
		mScore = 0;
		generateQuestion();
	}

	private void generateQuestion() {
		mTimer = 3;
		mNumber0 = mRandom.nextInt(10);
		mNumber1 = mRandom.nextInt(10);
		mResult = mNumber0 + mNumber1;
		mOptions = new int[3];
		mRight = mRandom.nextInt(3);
		for (int i = 0; i < 3; i++) {
			if (i == mRight) {
				mOptions[i] = mResult;
			} else {
				int other = 1 + mRandom.nextInt(9);
				if (mRandom.nextBoolean()) {
					if (i % 2 == 0) {
						mOptions[i] = mResult + other;
					} else {
						mOptions[i] = mResult - other;
					}
				} else {
					if (i % 2 == 1) {
						mOptions[i] = mResult + other;
					} else {
						mOptions[i] = mResult - other;
					}
				}
			}
		}
		mtvQuestion.setText(mNumber0 + " + " + mNumber1 + " = ?");
		for (int i = 0; i < 3; i++) {
			mbtOptions[i].setText(mOptions[i] + "");
		}
		for (int i = 0; i < 4; i++) {
			mHandler.postDelayed(this, i * 1000);
		}
	}

	@Override
	public void onClick(View view) {
		int index = view.getId() - R.id.bt_option_0;
		mHandler.removeCallbacksAndMessages(null);
		if (index == mRight) {
			mScore++;
			mtvScore.setText("SCORE: " + mScore);
			generateQuestion();
		} else {
			gameOver();
		}
	}

	private void gameOver() {
		Intent intent = new Intent(PlayActivity.this, GameOverActivity.class);
		intent.putExtra(SCORE, mScore);
		startActivity(intent);
		finish();
	}

	@Override
	public void run() {
		mtvTimer.setText(mTimer + "");
		mTimer--;
		if (mTimer == -1) {
			gameOver();
		}
	}
}
