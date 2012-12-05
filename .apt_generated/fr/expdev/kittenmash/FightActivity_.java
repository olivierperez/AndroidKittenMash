//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package fr.expdev.kittenmash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.googlecode.androidannotations.api.SdkVersionHelper;
import fr.expdev.kittenmash.R.id;
import fr.expdev.kittenmash.R.layout;

public final class FightActivity_
    extends FightActivity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_fight);
    }

    private void init_(Bundle savedInstanceState) {
        injectExtras_();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    private void afterSetContentView_() {
        kitten2 = ((ImageView) findViewById(id.kitten2));
        kitten1 = ((ImageView) findViewById(id.kitten1));
        vs_text = ((TextView) findViewById(id.vs_text));
        {
            View view = findViewById(id.kitten2);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        FightActivity_.this.kitten2();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(id.kitten1);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        FightActivity_.this.kitten1();
                    }

                }
                );
            }
        }
        init();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView_();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (((SdkVersionHelper.getSdkInt()< 5)&&(keyCode == KeyEvent.KEYCODE_BACK))&&(event.getRepeatCount() == 0)) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    public static FightActivity_.IntentBuilder_ intent(Context context) {
        return new FightActivity_.IntentBuilder_(context);
    }

    private void injectExtras_() {
        Intent intent_ = getIntent();
        Bundle extras_ = intent_.getExtras();
        if (extras_!= null) {
            if (extras_.containsKey("kittenExtra2")) {
                try {
                    kittenExtra2 = ((Integer) extras_.get("kittenExtra2"));
                } catch (ClassCastException e) {
                    Log.e("FightActivity_", "Could not cast extra to expected type, the field is left to its default value", e);
                }
            }
            if (extras_.containsKey("kittenExtra1")) {
                try {
                    kittenExtra1 = ((Integer) extras_.get("kittenExtra1"));
                } catch (ClassCastException e) {
                    Log.e("FightActivity_", "Could not cast extra to expected type, the field is left to its default value", e);
                }
            }
        }
    }

    @Override
    public void setIntent(Intent newIntent) {
        super.setIntent(newIntent);
        injectExtras_();
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, FightActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public FightActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (context_ instanceof Activity) {
                ((Activity) context_).startActivityForResult(intent_, requestCode);
            } else {
                context_.startActivity(intent_);
            }
        }

        public FightActivity_.IntentBuilder_ kittenExtra2(int kittenExtra2) {
            intent_.putExtra("kittenExtra2", kittenExtra2);
            return this;
        }

        public FightActivity_.IntentBuilder_ kittenExtra1(int kittenExtra1) {
            intent_.putExtra("kittenExtra1", kittenExtra1);
            return this;
        }

    }

}
