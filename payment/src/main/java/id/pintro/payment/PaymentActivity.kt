package id.pintro.payment

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import id.pintro.payment.channel.PaymentChannelFragment
import id.pintro.payment.data.model.ApiConfig
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
        supportActionBar?.title = resources.getString(R.string.payment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent.hasExtra(KEY_CONFIG).let {
            if (it) {
                var config = intent.extras.getParcelable<ApiConfig>(KEY_CONFIG)
                changeFragment(PaymentChannelFragment.instance(config),"channel")
            } else {
                showError("Need config")
            }
        }

    }

    private fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun changeFragment(fragment: Fragment, tag: String) {
        var ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_payment, fragment, tag)
        ft.addToBackStack(tag)
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
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) super.onBackPressed()
            else finish()
    }
    companion object {
        private const val KEY_CONFIG = "config"
        const val RC_PAYMENT = 111
        fun init(context: Context, config: ApiConfig): Intent {
            val intent = Intent(context, PaymentActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(KEY_CONFIG, config)
            return intent
        }
    }
}
