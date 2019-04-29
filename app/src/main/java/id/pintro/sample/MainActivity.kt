package id.pintro.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.pintro.payment.PaymentActivity
import id.pintro.payment.data.model.ApiConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setOnClickListener {
            var config = ApiConfig(
                "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImM3YTNiZTE2OWRlNjY3MzdmNjAwODNjNTBiMDYzNGMzZDRlOTNkNTdmMjk0ZThiZTUwMWI0MzBlMjQ1NTAzN2RiYjBjZmJjYzJjOTY1NmY1In0.eyJhdWQiOiIxIiwianRpIjoiYzdhM2JlMTY5ZGU2NjczN2Y2MDA4M2M1MGIwNjM0YzNkNGU5M2Q1N2YyOTRlOGJlNTAxYjQzMGUyNDU1MDM3ZGJiMGNmYmNjMmM5NjU2ZjUiLCJpYXQiOjE1NTAwMjQ1MjEsIm5iZiI6MTU1MDAyNDUyMSwiZXhwIjoxNTgxNTYwNTIxLCJzdWIiOiIyMjMzNiIsInNjb3BlcyI6W119.Ednhd8P927C7nSVDfQVvv1cCl_YfLsb-TxJ9Cg5YThvuc9YRP0X0MdqcL_oHHzV1tdKtANW0ryKGmNXaly65WmyBhY4NIVohWus0JIJQGyUMdGjdusoBDI8BJtOrYcYX78ia3wOOLwWMD4CSYx-o4mcvXiXwSSH8DG6pmKyH0JgDA2Q1OSP1rlIgcVzYwUvf2Lg6nEOcbOFdgL5l3cFNKwgJal4ooAWcmIPEo6ciz1TJP-PRQUB1hIzbXElL6W_AxfTa5P6lTOY5FwS1cR1VnaisVqK_SbqAxt24xXJIOUlGGD09jkewamDHPuMbuSi-vawc7PK3c3L4QoiYYIwWVadlhKOQTiWPpn0tykjRDesPJNw1dQLXo7x4ybVr00sb8MJg9WkyVfkOaOyE0oKGZ-rjXBeC-79nismhY_xHhcyEf7YwY8tlM296p-KtjXbuBUhHF00u0_UeTNVfRt-Be14D6pEH58obyy-nvNAOeDMDfBJ-nRtOm-XGvRF6iDJqXPCdx2haMHLHq-Khw6p5gvvgjxvUKiDKTJigi8UU5P3fma2Dx9zCl3bI6yUG3OKThvJ_p1YuFfSvQ0rLeb7TIz-pFsAX5wYvgxWw0rRbZ35ciGy8xGo72R8p14Q6wHbtoSMCpjAvK1hJ_wGj4VzLH-6X3vBwUAWNhSUNDGyByNg",
                "https://api.pintro.id/",
                2,2, false
            )
            startActivityForResult(PaymentActivity.init(this, config), PaymentActivity.RC_PAYMENT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.v("MainActivity","onActivityResult -> $requestCode")
        Log.v("MainActivity","onActivityResult -> $resultCode")
    }
}
