package ru.iandreyshev.tooltiprefactoring

import android.content.Context
import android.view.View

interface IEventPopup {
    fun show(context: Context, target: View)
}
