package com.uspehgp.geoquiz;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.util.*;

public class MainActivity extends Activity 
	{
		private static final String TAG = "MainActivity";
		private Button trueButton;
		private Button falseButton;
		private Button prevButton;
		private Button nextButton;
		private TextView questionTextView;
		private Question[] questionBank = new Question[] {
				new Question(R.string.question_oceans, true),
				new Question(R.string.question_mideast, false),
				new Question(R.string.question_africa, false),
				new Question(R.string.question_americas, true),
				new Question(R.string.question_asia, true),  };
		private int currentIndex = 0;

		private void updateQuestion() {
				int question = questionBank[currentIndex].getTextResId();
				questionTextView.setText(question);
			}

		private void checkAnswer(boolean userPressedTrue)
			{
				boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();
				int messageResId = 0;
				if (userPressedTrue == answerIsTrue) 
					{messageResId = R.string.correct_toast;}
				else {messageResId = R.string.incorrect_toast;}
				Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show(); 
			}

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				Log.d(TAG, "onCreate(Bundle) called");
				setContentView(R.layout.main);

				questionTextView = (TextView)findViewById
				(R.id.question_text_view);
				questionTextView.setOnClickListener(new View.OnClickListener()
						{
							@Override     public void onClick(View v) {
									currentIndex = (currentIndex+1) % questionBank.length;
									updateQuestion();
								}
						});

				trueButton = (Button)findViewById(R.id.true_button);
				trueButton.setOnClickListener(new View.OnClickListener()
						{
							@Override
							public void onClick(View v) {
									checkAnswer(true);
								}
						});

				falseButton = (Button) findViewById(R.id.false_button);
				falseButton.setOnClickListener(new View.OnClickListener()
						{
							@Override
							public void onClick(View v) {
									checkAnswer(false);
								}
						});

				nextButton = (Button)findViewById(R.id.next_button);
				nextButton.setOnClickListener(new View.OnClickListener()
						{
							@Override     public void onClick(View v) {
									currentIndex = (currentIndex+1) % questionBank.length;
									updateQuestion();
								}
						});
				
				prevButton = (Button)findViewById(R.id.prev_button);
				prevButton.setOnClickListener(new View.OnClickListener()
						{

							@Override     public void onClick(View v) {
									if (currentIndex > 0)
										{
											currentIndex = (currentIndex - 1) % questionBank.length;
									updateQuestion();}
									else Toast.makeText(MainActivity.this, R.string.messageone, Toast.LENGTH_SHORT).show();
								}
						});
				updateQuestion();
				}
		@Override   public void onStart() {
				super.onStart();
				Log.d(TAG, "onStart() called");  }
		@Override   public void onPause() {
				super.onPause();
				Log.d(TAG, "onPause() called");  }
		@Override   public void onResume() {
				super.onResume();
				Log.d(TAG, "onResume() called");  }
		@Override   public void onStop() {
				super.onStop();
				Log.d(TAG, "onStop() called");  }
		@Override   public void onDestroy() {
				super.onDestroy();
				Log.d(TAG, "onDestroy() called");  }
			
	}
	
