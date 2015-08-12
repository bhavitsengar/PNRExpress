package com.bhavit.pnrexpress;

import com.bhavit.pnrexpress.model.PnrDetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PnrActionsActivity extends BaseActivity {

	String pnrNo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pnr_actions);

		pnrNo = getIntent().getExtras().getString("pnrNo");

		TextView heading = (TextView) findViewById(R.id.textView_heading);
		heading.setTypeface(tf);

		Button trainRoute = (Button) findViewById(R.id.btn_get_route);
		trainRoute.setTypeface(tf);
		trainRoute.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				try {

					Intent i = new Intent(PnrActionsActivity.this,
							LocationActivity.class);

					i.putExtra("pnr", pnrNo);
					startActivity(i);
				} catch (Exception e) {
					showAlertDialog(PnrActionsActivity.this, "ERROR",
							"A problem occured while getting route. Please try later.");
				}

			}
		});

		Button pnrStatus = (Button) findViewById(R.id.btn_pnr_status);
		pnrStatus.setTypeface(tf);
		pnrStatus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				new BaseActivity().getPnrStatus(pnrNo, PnrActionsActivity.this);

			}
		});

		Button liveRunningStatus = (Button) findViewById(R.id.btn_livestatus);
		liveRunningStatus.setTypeface(tf);
		liveRunningStatus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(PnrActionsActivity.this,
						LiveRunningStatusActivity.class);

				PnrDetail obj = BaseActivity.sqlHelper.getPnrDetail(pnrNo);
				i.putExtra("tnum", obj.getTrainNumber());

				i.putExtra(
						"date",
						obj.getDateOfJourney().split("\\-")[2]
								+ (Integer.parseInt(obj.getDateOfJourney()
										.split("\\-")[1]) < 10 ? ("0" + Integer
										.parseInt(obj.getDateOfJourney().split(
												"\\-")[1])) : Integer
										.parseInt(obj.getDateOfJourney().split(
												"\\-")[1]))
								+ (Integer.parseInt(obj.getDateOfJourney()
										.split("\\-")[0]) < 10 ? ("0" + Integer
										.parseInt(obj.getDateOfJourney().split(
												"\\-")[0])) : Integer
										.parseInt(obj.getDateOfJourney().split(
												"\\-")[0])));
				startActivity(i);

			}
		});

	}

}
