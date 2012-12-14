package fr.expdev.kittenmash;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.OnActivityResult;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

@NoTitle
@EActivity(R.layout.activity_best_kitten)
public class BestKittenActivity extends Activity {

	private static final String BEST_KITTEN = "BEST_KITTEN";

	private static final int REQUEST_CODE = 1;

	public static String KITTEN = "KITTEN";

	@ViewById
	ImageView best_kitten;

	private int[] kittens;

	@AfterViews
	protected void init() {
		kittens = new int[] { //
		R.drawable.kitten_01, R.drawable.kitten_02,//
				R.drawable.kitten_03, R.drawable.kitten_04,//
				R.drawable.kitten_05, R.drawable.kitten_06,//
				R.drawable.kitten_07, R.drawable.kitten_08, //
				R.drawable.kitten_09, R.drawable.kitten_10 //
		};

		loadBestKitten();
	}

	@Click
	protected void fight_button() {
		Log.d("BestKittenActivity", "fight_button()");
		Random random = new Random();
		int random_kitten1 = kittens[random.nextInt(kittens.length)];
		int random_kitten2 = kittens[random.nextInt(kittens.length)];

		while (random_kitten1 == random_kitten2) {
			random_kitten2 = kittens[random.nextInt(kittens.length)];
		}

		FightActivity_.intent(this)//
				.kittenExtra1(random_kitten1)//
				.kittenExtra2(random_kitten2)//
				.startForResult(REQUEST_CODE);

		overridePendingTransition(R.anim.zoom_n_fade_in, R.anim.fade_out);
	}

	@OnActivityResult(REQUEST_CODE)
	protected void onResult(int resultCode, Intent data) {
		Log.d("BestKittenActivity", "onActivityResult(" + resultCode + ",...)");
		if (resultCode == RESULT_OK) {
			int kitten = data.getIntExtra(KITTEN, 0);
			setBestKitten(kitten);
			saveBestKitten(kitten);
		}
	}

	@UiThread
	protected void setBestKitten(int kitten) {
		best_kitten.setImageResource(kitten);
	}

	@Background
	protected void saveBestKitten(int kitten) {
		SharedPreferences prefs = getSharedPreferences("fight", MODE_PRIVATE);
		prefs.edit().putInt(BEST_KITTEN, kitten).commit();
	}

	@Background
	protected void loadBestKitten() {
		SharedPreferences prefs = getSharedPreferences("fight", MODE_PRIVATE);
		int kitten = prefs.getInt(BEST_KITTEN, 0);
		setBestKitten(kitten);
	}

}
