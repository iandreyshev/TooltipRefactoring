package ru.iandreyshev.tooltiprefactoring

import android.content.Context
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class HorizontalTooltip @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {
    companion object {
        enum class Side {
            LEFT,
            RIGHT
        }
    }

    private lateinit var mArrow: FrameLayout

    var targetView: View? = null
        set(value) {
            field = value
            requestLayout()
        }

    var arrowSide: Side = Side.RIGHT
        set(value) {
            field = value
            requestLayout()
        }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mArrow = findViewById(R.id.arrow)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        targetView?.let { updateArrowPosition(it) }
    }

    private fun updateArrowPosition(target: View) {
        val targetY = target.getLocationOnScreen.centerY()
        val arrowY = mArrow.getLocationOnScreen.centerY()
        mArrow.translationY = targetY - arrowY
    }

    private val View.getLocationOnScreen: RectF
        get() {
            val location = IntArray(2)
            getLocationOnScreen(location)
            return RectF(location[0].toFloat(), location[1].toFloat(), (location[0] + measuredWidth).toFloat(), (location[1] + measuredHeight).toFloat())
        }
}
