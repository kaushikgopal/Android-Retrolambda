package com.morihacky.android.retrolambda;

import android.app.Activity;
import android.os.Bundle;

import java.util.Arrays;

import rx.Observable;
import timber.log.Timber;


public class MainActivity
    extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());

        _doThatLambdaGoodness();
    }

    private void _doThatLambdaGoodness() {

        Observable.from(Arrays.asList("Hello", "World"))
                  .reduce((seed, value) -> seed + " " + value)
                  .subscribe((s) -> Timber.d("--------" + s));
    }
}
