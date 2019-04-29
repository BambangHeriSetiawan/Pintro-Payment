package id.pintro.payment.data.model.channels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by simx on 29,April,2019
 */
@Parcelize
data class PaymentGroups(
    @field:SerializedName("data")
    val data: List<PaymentChannel>? = null,

    @field:SerializedName("group")
    val group: String? = null,

    @field:SerializedName("group_name")
    val groupName: String? = null
) : Parcelable