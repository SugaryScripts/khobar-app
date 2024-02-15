package id.web.muhammadibrahim.khobar.utility.binding

import android.animation.Animator
import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.data.AppConstants
import id.web.muhammadibrahim.khobar.utility.glide.GlideApp

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
        fun loadBackgroundCategory(cardView: CardView, category: String) {
            when (category){
                "Artikel" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.artikel))
                "Berita-Umum" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.berita_umum))
                "Info-2" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.info_2))
                "Informasi-Lembaga-dan-Biro" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.informasi_lembaga_dan_biro))
                "Informasi-Program-Studi" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.informasi_program_studi))
                "Informasi-Universitas" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.informasi_universitas))
                "Journal" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.journal))
                "News-Ar" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.news_ar))
                "News-En" -> cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context, R.color.news_en))
            }
        }

        @JvmStatic
        @BindingAdapter("loadIconFacultyDepartment")
        fun loadIconFacultyDepartment(imageView: AppCompatImageView, category: String) {
            when (category){
                "education" -> imageView.setImageResource(R.drawable.in_education_blue)
                "ushuluddin" -> imageView.setImageResource(R.drawable.in_ushuluddin_blue)
                "shariah" -> imageView.setImageResource(R.drawable.ic_shariah_blue)
                "science" -> imageView.setImageResource(R.drawable.ic_science_blue)
                "humanities" -> imageView.setImageResource(R.drawable.ic_humanities_blue)
                "health" -> imageView.setImageResource(R.drawable.ic_health_blue)
                "economic" -> imageView.setImageResource(R.drawable.ic_economi_blue)
            }
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