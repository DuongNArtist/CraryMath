package com.tadungit.crarymath;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	public static final String TAG = MainActivity.class.getSimpleName();

	private Button mbtPlay;
	private Button mbtMore;
	private TextView mtvCrazyMath;
	private TextView mtvGame;
	private TextView mtvBestScore;
	private Typeface mTypeface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "On Create");

		mTypeface = Typeface
				.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");

		mtvCrazyMath = (TextView) findViewById(R.id.tv_crazy_math);
		mtvGame = (TextView) findViewById(R.id.tv_game);
		mtvBestScore = (TextView) findViewById(R.id.tv_best_score);

		mtvCrazyMath.setTypeface(mTypeface);
		mtvGame.setTypeface(mTypeface);
		mtvBestScore.setTypeface(mTypeface);

		mbtPlay = (Button) findViewById(R.id.bt_play);
		mbtMore = (Button) findViewById(R.id.bt_more);

		mbtPlay.setTypeface(mTypeface);
		mbtMore.setTypeface(mTypeface);
		mbtPlay.setOnClickListener(this);
		mbtMore.setOnClickListener(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "On Start");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "On Resume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "On Pause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "On Stop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "On Destroy");
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.bt_play:
			Log.i(TAG, "Click Play");
			Intent intent = new Intent(this, PlayActivity.class);
			startActivity(intent);
			break;

		case R.id.bt_more:
			Log.i(TAG, "Click More");
			break;

		default:
			break;
		}
	}

}
