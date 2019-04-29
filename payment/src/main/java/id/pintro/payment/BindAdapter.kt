package id.pintro.payment

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

import com.squareup.picasso.Picasso


/**
 * Created by simx on 29,April,2019
 */
class BindAdapter {
    companion object {
        @BindingAdapter("bind:visibility") @JvmStatic fun setVisibility(view: View, value: Boolean) {
            view.visibility = if (value) View.VISIBLE else View.GONE
        }
        @BindingAdapter("bind:image_url") @JvmStatic
        fun loadImage(imageView: ImageView, url:String?){
            /*GlideApp.with(imageView.context).load(url).centerCrop().error(R.drawable.placeholder).into(imageView)*/
            Picasso.get().load(url).error(R.drawable.placeholder).into(imageView)
        }
        /*@BindingAdapter("bind:image_url") @JvmStatic
        fun loadImage(imageView: ImageView, url:String?){
            if (!url.isNullOrEmpty()) Picasso.get().load(url).error(R.drawable.placeholder).into(imageView)
            else Picasso.get().load(R.drawable.placeholder).error(R.drawable.placeholder).into(imageView)
        }
        @BindingAdapter("bind:image_url_small") @JvmStatic
        fun loadImageSmall(imageView: ImageView, url:String){
            Picasso.get().load(url).fit().centerCrop(Gravity.CENTER).error(R.drawable.placeholder).into(imageView)

        }
        @BindingAdapter("bind:image_custom") @JvmStatic
        fun loadImageCustom(imageView: CircleImageView, url:String?){
            if (url != null){
                Picasso.get().load(url).fit().centerCrop().error(R.drawable.placeholder).into(imageView)
            } else {
                Picasso.get().load(R.drawable.placeholder).fit().centerCrop().error(R.drawable.placeholder).into(imageView)
            }

        }
        @BindingAdapter("bind:image_asset")
        @JvmStatic fun loadIntImage(imageView: ImageView, url:Int){
            GlideApp.with(imageView.context).load(url).centerCrop().error(R.drawable.placeholder).into(imageView)
        }*/

    }

}