package com.android.rxjava2_samples.RxBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2016/12/13.
 */


public class RxDisposable {
    private static volatile RxDisposable mIntance;
    private CompositeDisposable mDisposable;

    public RxDisposable() {
        mDisposable = new CompositeDisposable();
    }

    public static RxDisposable getIntance() {
        if (mIntance == null) {
            synchronized (RxDisposable.class){
                if (mIntance == null) {
                    mIntance = new RxDisposable();
                }
            }
        }
        return mIntance;
    }

    public boolean isDispose() {
        return mDisposable.isDisposed();
    }

    public void add(Disposable disposable) {
        if (disposable != null) {
            mDisposable.add(disposable);
        }
    }

    public void remove(Disposable disposable) {
        if (disposable != null) {
            mDisposable.remove(disposable);
        }
    }

    public void disposed() {
        mDisposable.dispose();
    }

    public void clear() {
        mDisposable.clear();
    }

    public void delete(Disposable disposable) {
        if (disposable != null) {
            mDisposable.delete(disposable);
        }
    }

    public int size() {
        return mDisposable.size();
    }

}
