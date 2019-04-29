package id.pintro.payment.preview

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR

/**
 * Created by simx on 27,April,2019
 */
class PaymentPreviewVM: BaseObservable() {

    @Bindable var isDonations = ObservableField<Boolean>()
    set(value) {
        field = value
        notifyPropertyChanged(BR.isDonations)
    }
}