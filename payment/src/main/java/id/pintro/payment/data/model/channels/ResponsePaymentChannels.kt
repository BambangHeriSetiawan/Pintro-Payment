package id.pintro.payment.data.model.channels


import com.google.gson.annotations.SerializedName

data class ResponsePaymentChannels(

	@field:SerializedName("data")
	val data: List<PaymentGroups>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)