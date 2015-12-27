package com.ataulm.findviewbyrx;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

import rx.Observable;
import rx.Subscriber;

public class RxViewFinder {

    private final Activity activity;

    public RxViewFinder(Activity activity) {
        this.activity = activity;
    }

    public Observable<View> findViewByRx(@IdRes final int id) {
        return Observable.create(
                new Observable.OnSubscribe<View>() {

                    @Override
                    public void call(Subscriber<? super View> subscriber) {
                        View view = activity.findViewById(id);
                        if (view == null) {
                            subscriber.onError(new CouldNotFindViewException(id));
                        } else {
                            subscriber.onNext(view);
                            subscriber.onCompleted();
                        }
                    }

                }
        );
    }

}
