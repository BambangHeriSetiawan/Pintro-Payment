package id.pintro.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import id.pintro.payment.channel.PaymentChannelFragment
import id.pintro.payment.databinding.PaymentActivityBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding:PaymentActivityBinding
    private lateinit var vm:PaymentVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.payment_activity)
        vm = PaymentVM()
        binding.lifecycleOwner = this
        binding.paymentVm = vm
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Payment Channel"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        changeFragment(PaymentChannelFragment.instance(),"channel")
    }

    fun changeFragment(fragment: Fragment, tag: String) {
        var ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_payment, fragment, tag)
        ft.isAddToBackStackAllowed
        ft.commit()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun back() {
        onBackPressed()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) super.onBackPressed()
            else finish()
    }
}
