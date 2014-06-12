package com.example.testftue;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	Activity activity;
	Dialog welcomeOverlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		activity = this;
		welcomeOverlay = new Dialog(this,
				android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
		welcomeOverlay.requestWindowFeature(Window.FEATURE_NO_TITLE);
		welcomeOverlay.setContentView(R.layout.dialog_layout);
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(welcomeOverlay.getWindow().getAttributes());
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.MATCH_PARENT;
		welcomeOverlay.getWindow().setBackgroundDrawable(
				new ColorDrawable(Color.TRANSPARENT));
		welcomeOverlay.getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		welcomeOverlay.getWindow().setAttributes(lp);
		welcomeOverlay.show();
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				activity.runOnUiThread(new Runnable() {

					@Override
					public void run() {
						welcomeOverlay.dismiss();
					}
				});
			}
		}, 5000);

	}
}
