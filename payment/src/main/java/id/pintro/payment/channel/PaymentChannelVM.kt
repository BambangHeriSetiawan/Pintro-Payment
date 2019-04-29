package id.pintro.payment.channel

import android.annotation.SuppressLint
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import id.pintro.payment.data.ApiRequests
import id.pintro.payment.data.model.ApiConfig
import id.pintro.payment.data.model.channels.PaymentGroups
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by simx on 27,April,2019
 */
class PaymentChannelVM: BaseObservable() {
    private var disposable: CompositeDisposable? = null
    init {
        disposable = CompositeDisposable()
    }

    @Bindable var errorMsg = MutableLiveData<String>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.errorMsg)
    }
    @Bindable var isLoading = ObservableField<Boolean>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.isLoading)
        }
    @Bindable var isError = ObservableField<Boolean>()
        set(value) {
            field = value
            notifyPropertyChanged(BR.isError)
        }

    @Bindable var channels = MutableLiveData<List<PaymentGroups>>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.channels)
    }

    @SuppressLint("CheckResult")
    fun channels(config: ApiConfig){
        isLoading.set(true)
        isError.set(false)
        ApiRequests.channels(config.url!!, config.token!!, config.clientId!!, config.appId!!)?.subscribe(
            { it ->
                isLoading.set(false)
                it.let {
                    if (it.status == 200) channels.postValue(it.data)
                        else {
                        isError.set(true)
                        errorMsg.postValue(it.message)
                    }
                }
            },{
                isLoading.set(false)
                isError.set(true)
                errorMsg.postValue(it.message) }
        )
    }
}