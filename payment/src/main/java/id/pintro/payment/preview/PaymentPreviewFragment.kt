package id.pintro.payment.preview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import id.pintro.payment.PaymentActivity

import id.pintro.payment.R
import id.pintro.payment.data.model.ApiConfig
import id.pintro.payment.databinding.PaymentPreviewFragmentBinding
import id.pintro.payment.invoice.PaymentInvoiceFragment
import kotlinx.android.synthetic.main.payment_preview_fragment.*

class PaymentPreviewFragment : Fragment() {
    private lateinit var binding:PaymentPreviewFragmentBinding
    private lateinit var vm:PaymentPreviewVM

    private var config: ApiConfig? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.payment_preview_fragment, container,false)
        vm = PaymentPreviewVM()
        binding.lifecycleOwner = this
        binding.paymentPreviewVm = vm
        arguments!!.isEmpty.let {
            if (!it){
             config = arguments!!.getParcelable(KEY_DATA)
                vm.isDonations.set(config!!.isDonations)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_nex_payment_preview.setOnClickListener {
            (activity as PaymentActivity).changeFragment(PaymentInvoiceFragment.instance(),"invoice")
        }
    }

    companion object {
        const val KEY_DATA = "key"
        fun instance(config: ApiConfig) : PaymentPreviewFragment{
            var bundle =  Bundle()
            bundle.putParcelable(KEY_DATA, config)
            var fragment = PaymentPreviewFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
