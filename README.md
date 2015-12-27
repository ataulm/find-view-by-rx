# FindViewByRx

Worried `findViewById(int)` is a super long expensive operation? Kick it off to a non-main thread scheduler! 

```java
new RxViewFinder(this).findViewByRx(R.id.my_view)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Observer<View>() {
                            @Override
                            public void onCompleted() {
                                // lol no-op yolo
                            }

                            @Override
                            public void onError(Throwable e) {
                                // I dun goofed
                            }

                            @Override
                            public void onNext(View view) {
                                // aw yiss, got my view
                            }
                        }
                );
```
