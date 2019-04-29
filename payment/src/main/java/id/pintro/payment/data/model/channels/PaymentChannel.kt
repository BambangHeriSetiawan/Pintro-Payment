package id.pintro.payment.data.model.channels


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PaymentChannel(

	@field:SerializedName("group_name")
	val groupName: String? = null,

	@field:SerializedName("group")
	val group: Int? = null,

	@field:SerializedName("mdr_bank")
	val mdrBank: String? = null,

	@field:SerializedName("parent")
	val parent: Int? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("mdr_client")
	val mdrClient: String? = null,

	@field:SerializedName("preffix_local")
	val preffixLocal: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("share_ps")
	val sharePs: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("fee_type")
	val feeType: Int? = null,

	@field:SerializedName("client_id")
	val clientId: Int? = null,

	@field:SerializedName("share_jo")
	val shareJo: String? = null,

	@field:SerializedName("tenor")
	val tenor: String? = null,

	@field:SerializedName("mdr_total")
	val mdrTotal: String? = null,

	@field:SerializedName("mdr_gateway")
	val mdrGateway: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("ng_payment_gateway_id")
	val ngPaymentGatewayId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("app_id")
	val appId: Int? = null,

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("chain")
	val chain: String? = null,

	@field:SerializedName("cost")
	val cost: String? = null,

	@field:SerializedName("share_iglobal")
	val shareIglobal: String? = null,

	@field:SerializedName("preffix_production")
	val preffixProduction: String? = null,

	@field:SerializedName("share_ypi")
	val shareYpi: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: String? = null,

	@field:SerializedName("sequence")
	val sequence: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mdr_iglobal")
	val mdrIglobal: String? = null,

	@field:SerializedName("short")
	val jsonMemberShort: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
) : Parcelable {
	fun getImageIcon(): String? {
		return "https://api.pintro.id/" + this.iconUrl
	}
}