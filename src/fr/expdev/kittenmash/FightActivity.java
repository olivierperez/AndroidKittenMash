package fr.expdev.kittenmash;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.AnimationRes;

@NoTitle
@EActivity(R.layout.activity_fight)
public class FightActivity extends Activity {

	@Extra
	protected int kittenExtra1;

	@Extra
	protected int kittenExtra2;

	@ViewById
	protected ImageView kitten1;

	@ViewById
	protected ImageView kitten2;

	@ViewById
	protected TextView vs_text;

	@AnimationRes
	protected Animation translate_from_top;

	@AnimationRes
	protected Animation translate_from_bottom;

	@AnimationRes
	protected Animation translate_from_left;

	@AnimationRes
	protected Animation translate_from_right;

	@AnimationRes
	protected Animation rotate_and_zoom;

	@AfterViews
	void init() {
		kitten1.setImageResource(kittenExtra1);
		kitten2.setImageResource(kittenExtra2);

		Animation kitten1Animation;
		Animation kitten2Animation;

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			kitten1Animation = translate_from_top;
			kitten2Animation = translate_from_bottom;
		} else {
			kitten1Animation = translate_from_left;
			kitten2Animation = translate_from_right;
		}

		kitten1.startAnimation(kitten1Animation);
		kitten2.startAnimation(kitten2Animation);

		vs_text.startAnimation(rotate_and_zoom);
	}

	@Click
	protected void kitten1() {
		returnVoteForKitten(kittenExtra1);
	}

	@Click
	protected void kitten2() {
		returnVoteForKitten(kittenExtra2);
	}

	private void returnVoteForKitten(int kitten) {
		Intent data = new Intent();
		data.putExtra(BestKittenActivity.KITTEN, kitten);
		setResult(RESULT_OK, data);

		finish();
		transitaionOut();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		transitaionOut();
	}

	private void transitaionOut() {
		overridePendingTransition(0, R.anim.zoom_n_fade_out);
	}

}
