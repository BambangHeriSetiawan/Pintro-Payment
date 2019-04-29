package id.pintro.payment.channel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.pintro.payment.R
import id.pintro.payment.data.model.channels.PaymentChannel
import id.pintro.payment.databinding.ItemPaymentChannelBinding

/**
 * Created by simx on 28,April,2019
 */
class AdapterPaymentChannel(var data: List<PaymentChannel>, var listener: OnAdapterPaymentChannelListener): RecyclerView.Adapter<AdapterPaymentChannel.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPaymentChannelBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_payment_channel, parent, false)))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener { listener.onAdapterPaymentChannelClicked(data[position]) }
    }

    fun update(data: List<PaymentChannel>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OnAdapterPaymentChannelListener {
        fun onAdapterPaymentChannelClicked( data:PaymentChannel)
    }

    class Holder(var binding: ItemPaymentChannelBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PaymentChannel) {
            with(binding) {
                paymentChannelVm = ItemPaymentChannelVM(data)
                executePendingBindings()
            }
        }

    }
}