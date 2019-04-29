package id.pintro.payment.channel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import id.pintro.payment.data.model.channels.PaymentChannel

/**
 * Created by simx on 28,April,2019
 */
class ItemPaymentChannelVM(data: PaymentChannel) : BaseObservable() {

    @Bindable
    var title = ObservableField<String>(data.name)
    @Bindable
    var image = ObservableField<String>(data.getImageIcon())
}