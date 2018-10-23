package id.web.muhammadibrahim.myindago.utility.binding

import android.animation.Animator
import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.data.AppConstants
import id.web.muhammadibrahim.myindago.utility.glide.GlideApp

class Converters {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: AppCompatImageView, imageUrl: String) {
            GlideApp.with(imageView.context.applicationContext)
                .load(imageUrl)
                .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
                .into(imageView)
        }
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String) {
            GlideApp.with(imageView.context.applicationContext)
                .load(imageUrl)
                .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("loadBackgroundCategory")
        fun loadBackgroundCategory(textView: AppCompatTextView, category: String) {
            var background: Int = R.drawable.bg_category_politic_tv
            when (category){
                "Politic" -> background =  R.drawable.bg_category_politic_tv
                "Education" -> background =  R.drawable.bg_category_education_tv
                "Economic" -> background = R.drawable.bg_category_economic_tv
            }
            textView.background = textView.context.resources.getDrawable(background)
        }

        @JvmStatic
        @BindingAdapter("showView")
        fun showView(view: View, hide: Boolean){
            if(hide) {
                view.alpha = 0f
                view.animate().alpha(1f).duration = AppConstants.GLOBAL_ANIM_DURATION
            }
        }

        @JvmStatic
        @BindingAdapter("hideView")
        fun hideView(view: View, hide: Boolean){
            if (hide) {
                view.visibility = View.VISIBLE
                view.alpha = 1f
            } else {
                view.animate().alpha(0f).setDuration(AppConstants.GLOBAL_ANIM_DURATION).setListener(object : Animator.AnimatorListener {

                    override fun onAnimationRepeat(p0: Animator?) {

                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        view.visibility = View.INVISIBLE
                    }

                    override fun onAnimationStart(p0: Animator?) {

                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                })
            }
        }

    }

}