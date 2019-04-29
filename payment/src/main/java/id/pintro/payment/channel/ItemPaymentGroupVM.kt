package id.pintro.payment.channel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import id.pintro.payment.data.model.channels.PaymentGroups

/**
 * Created by simx on 28,April,2019
 */
class ItemPaymentGroupVM(data: PaymentGroups) : BaseObservable() {
    @Bindable var title = ObservableField<String>(data.groupName)
    @Bindable var image = ObservableField<String>(data.group)
}