package id.pintro.payment.channel


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.pintro.payment.PaymentActivity

import id.pintro.payment.R
import id.pintro.payment.preview.PaymentPreviewFragment
import id.pintro.payment.databinding.PaymentChannelFragmentBinding


class PaymentChannelFragment : Fragment() {
    private lateinit var binding:PaymentChannelFragmentBinding
    private lateinit var vm:PaymentChannelVM

    private lateinit var adapterPaymentGroup: AdapterPaymentGroup
    private val adapterListener: AdapterPaymentChannel.OnAdapterPaymentChannelListener = object : AdapterPaymentChannel.OnAdapterPaymentChannelListener {
        override fun onAdapterPaymentChannelClicked(data: String) {
            (activity as PaymentActivity).changeFragment(PaymentPreviewFragment.instance(),"preview")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.payment_channel_fragment, container,false)
        vm = PaymentChannelVM()
        binding.lifecycleOwner = this
        binding.channelVM = vm
        adapterPaymentGroup = AdapterPaymentGroup(listOf(), adapterListener)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterPaymentGroup.update(listOf("",""))
        binding.rcvPaymentGroup.let {
            it.hasFixedSize()
            it.itemAnimator = DefaultItemAnimator()
            it.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            it.adapter = adapterPaymentGroup
        }
    }
    companion object {
        const val KEY_DATA = "ke"
        fun instance() : PaymentChannelFragment{
            var bundle =  Bundle()
            var fragment = PaymentChannelFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
