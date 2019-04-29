package id.pintro.payment.data

import id.pintro.payment.data.model.channels.ResponsePaymentChannels
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by simx on 29,April,2019
 */
object ApiRequests {
    fun channels( url:String, token:String,  clientId: Int, appId: Int): Observable<ResponsePaymentChannels>? {
        return APIs.Factory.create(url).channels(token,clientId, appId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}