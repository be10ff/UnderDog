package ru.abelov.underdog.presentation.view.fragment

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

open class RxBaseFragment : Fragment() {
    protected var subscriptions = CompositeDisposable()


    override fun onPause() {
        super.onPause()
        if(!subscriptions.isDisposed) {
            subscriptions.dispose()
        }
        subscriptions.clear()
    }

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }
}