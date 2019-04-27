package id.pintro.payment.preview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.pintro.payment.PaymentActivity

import id.pintro.payment.R
import kotlinx.android.synthetic.main.payment_preview_fragment.*

class PaymentPreviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.payment_preview_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_nex_payment_preview.setOnClickListener {
            (activity as PaymentActivity).back()
        }
    }

companion object {
    const val KEY_DATA = "key"
    fun instance() : PaymentPreviewFragment{
        var bundle =  Bundle()
        var fragment = PaymentPreviewFragment()
        fragment.arguments = bundle
        return fragment
    }
}
}
