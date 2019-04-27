package id.pintro.payment.channel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.pintro.payment.R
import id.pintro.payment.databinding.ItemPaymentChannelBinding

/**
 * Created by simx on 28,April,2019
 */
class AdapterPaymentChannel(var data: List<String>, var listener: OnAdapterPaymentChannelListener): RecyclerView.Adapter<AdapterPaymentChannel.Holder>() {
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

    fun update(data: List<String>){
        this.data = data
        notifyDataSetChanged()
    }

    interface OnAdapterPaymentChannelListener {
        fun onAdapterPaymentChannelClicked( data:String)
    }

    class Holder(var binding: ItemPaymentChannelBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            with(binding) {
                paymentChannelVm = ItemPaymentChannelVM(data)
                executePendingBindings()
            }
        }

    }
}