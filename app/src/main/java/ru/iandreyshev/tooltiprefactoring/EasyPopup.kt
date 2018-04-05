package ru.iandreyshev.tooltiprefactoring

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.zyyoona7.lib.EasyPopup
import com.zyyoona7.lib.HorizontalGravity
import com.zyyoona7.lib.VerticalGravity

object EasyPopup : IEventPopup {
    override fun show(context: Context, target: View) {
        val popupFrame = LayoutInflater.from(context)
                .inflate(R.layout.popup_right, null)

        popupFrame.findViewById<HorizontalTooltip>(R.id.tooltip)?.let { tooltip ->
            tooltip.targetView = target
        }

        val popup = EasyPopup(context)
                .setContentView<EasyPopup>(popupFrame)
                .setOutsideTouchable<EasyPopup>(false)
                .setFocusAndOutsideEnable<EasyPopup>(false)
                .createPopup<EasyPopup>()

        popup.showAtAnchorView(target, VerticalGravity.CENTER, HorizontalGravity.LEFT)
        popup.popupWindow.setTouchInterceptor { _, _ -> false }
    }
}
