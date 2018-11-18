package id.web.muhammadibrahim.khobar.utility

import android.app.Activity
import android.util.TypedValue
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.TextView

class ActivityHelper {

    companion object {

        @JvmStatic
        fun dpToPx(dp: Int, activity: Activity): Int {
            val r = activity.resources
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
        }

        @JvmStatic
        fun handleToolbarTitleVisibility(title: TextView, percentage: Float, isTitleVisible: Boolean): Boolean {
            var titleVisible = isTitleVisible
            if (percentage >= 0.9f) {
                if (!isTitleVisible) {
                    startAlphaAnimation(title, 200, View.VISIBLE)
                    titleVisible = true
                }

            } else {
                if (isTitleVisible) {
                    startAlphaAnimation(title, 200, View.INVISIBLE)
                    titleVisible = false
                }
            }
            return titleVisible
        }

        @JvmStatic
        fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
            val alphaAnimation = if (visibility == View.VISIBLE)
                AlphaAnimation(0f, 1f)
            else
                AlphaAnimation(1f, 0f)

            alphaAnimation.duration = duration
            alphaAnimation.fillAfter = true
            v.startAnimation(alphaAnimation)
        }

    }

}