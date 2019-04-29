package id.pintro.payment.channel


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.pintro.payment.PaymentActivity

import id.pintro.payment.R
import id.pintro.payment.data.model.ApiConfig
import id.pintro.payment.data.model.channels.PaymentChannel
import id.pintro.payment.preview.PaymentPreviewFragment
import id.pintro.payment.databinding.PaymentChannelFragmentBinding


class PaymentChannelFragment : Fragment() {
    private lateinit var binding:PaymentChannelFragmentBinding
    private lateinit var vm:PaymentChannelVM

    private var config: ApiConfig? = null

    private lateinit var adapterPaymentGroup: AdapterPaymentGroup
    private val adapterListener: AdapterPaymentChannel.OnAdapterPaymentChannelListener = object : AdapterPaymentChannel.OnAdapterPaymentChannelListener {
        override fun onAdapterPaymentChannelClicked(data: PaymentChannel) {
            (activity as PaymentActivity).changeFragment(PaymentPreviewFragment.instance(config!!),"preview")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.payment_channel_fragment, container,false)
        vm = PaymentChannelVM()
        binding.lifecycleOwner = this
        binding.channelVM = vm
        adapterPaymentGroup = AdapterPaymentGroup(listOf(), adapterListener)
        arguments!!.isEmpty.let {
            if (!it) {
                config = arguments!!.getParcelable(KEY_DATA)!!
                vm.channels(config!!)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.channels.observe(this, Observer {
            adapterPaymentGroup.update(it)
        })
        vm.errorMsg.observe(this, Observer {
            binding.tvError.text = it
        })
        binding.rcvPaymentGroup.let {
            it.hasFixedSize()
            it.itemAnimator = DefaultItemAnimator()
            it.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            it.adapter = adapterPaymentGroup
        }
        binding.tvTrayAgainEmpty.setOnClickListener {
            Log.v("PaymentChannelFragment","tvTrayAgainEmpty -> ")
            vm.channels(config!!)
            toas()
        }
        binding.tvTrayAgain.setOnClickListener {
            Log.v("PaymentChannelFragment","tvTrayAgain -> ")
            vm.channels(config!!)
            toas()
        }

    }
    fun toas(){
        Toast.makeText(this.context!!, "Sample", Toast.LENGTH_LONG).show()
    }
    companion object {
        const val KEY_DATA = "ke"
        fun instance(config: ApiConfig) : PaymentChannelFragment{
            var bundle =  Bundle()
            bundle.putParcelable(KEY_DATA, config)
            var fragment = PaymentChannelFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
