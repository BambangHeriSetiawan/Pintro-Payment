package id.pintro.payment.channel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.pintro.payment.R
import id.pintro.payment.data.model.channels.PaymentGroups
import id.pintro.payment.databinding.ItemPaymentGroupBinding

/**
 * Created by simx on 28,April,2019
 */
class AdapterPaymentGroup(private var data: List<PaymentGroups>, private var listener: AdapterPaymentChannel.OnAdapterPaymentChannelListener): RecyclerView.Adapter<AdapterPaymentGroup.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPaymentGroupBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_payment_group, parent, false)))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data[position])
        /*if (position == 0) {
            holder.binding.rcvPaymentChannel.visibility = View.VISIBLE
            holder.binding.tvTitlePaymentGroup.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down_primary,0)
        }
        holder.itemView.setOnClickListener {
            if (holder.binding.rcvPaymentChannel.isVisible){
                holder.binding.rcvPaymentChannel.visibility = View.GONE
                holder.binding.tvTitlePaymentGroup.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_right_primary,0)
            } else {
                holder.binding.rcvPaymentChannel.visibility = View.VISIBLE
                holder.binding.tvTitlePaymentGroup.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_down_primary,0)
            }
        }*/
        holder.binding.rcvPaymentChannel.apply {
            this.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            this.adapter = AdapterPaymentChannel(data[position].data!!, listener)
        }
    }
    fun update(data: List<PaymentGroups>) {
        this.data = data
        notifyDataSetChanged()
    }
    class Holder(var binding: ItemPaymentGroupBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PaymentGroups) {
            with(binding) {
                paymentGroupVm = ItemPaymentGroupVM(data)
                executePendingBindings()
            }
        }

    }
}