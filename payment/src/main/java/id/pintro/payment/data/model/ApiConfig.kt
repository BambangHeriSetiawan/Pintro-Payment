package id.pintro.payment.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by simx on 29,April,2019
 */
@Parcelize
data class ApiConfig(
    var token:String? = null,
    var url:String? = null,
    var appId:Int? = null,
    var clientId:Int? = null
) : Parcelable