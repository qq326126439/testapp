package com.example.gongshihao.testapp.Util;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;

/**
 * Created by gongshihao on 2018/4/20.
 */

public class RxthrottleFirst<T> {

    public static <T> ObservableTransformer<T, T> applyRxThrottle() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable.throttleFirst(1, TimeUnit.MICROSECONDS);
            }
        };
    }

}
