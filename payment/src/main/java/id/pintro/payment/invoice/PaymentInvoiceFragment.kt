package id.pintro.payment.invoice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import id.pintro.payment.PaymentActivity

import id.pintro.payment.R
import id.pintro.payment.databinding.PaymentInvoceFragmentBinding

class PaymentInvoiceFragment : Fragment() {
    private lateinit var binding:PaymentInvoceFragmentBinding
    private lateinit var vm:PaymentInvoiceVM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.payment_invoce_fragment, container,false)
        vm = PaymentInvoiceVM()
        binding.lifecycleOwner = this
        binding.paymentInvoice = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            (activity as PaymentActivity).back()
        }


    }
    companion object {
        const val KEY_DATA = "key_data"
        fun instance() : PaymentInvoiceFragment{
            var bundle =  Bundle()
            var fragment = PaymentInvoiceFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


}
