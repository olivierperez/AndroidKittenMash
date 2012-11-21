package fr.expdev.kittenmash;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;

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

	@AfterViews
	void init() {
		kitten1.setImageResource(kittenExtra1);
		kitten2.setImageResource(kittenExtra2);
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
	}

}
