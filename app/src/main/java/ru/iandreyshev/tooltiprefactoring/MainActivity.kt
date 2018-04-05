package ru.iandreyshev.tooltiprefactoring

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            EasyPopup.show(this, button)
            /*
            ViewTooltip.on(button)
                    .corner(15)
                    .withShadow(true)
                    .position(ViewTooltip.Position.LEFT)
                    .clickToHide(true)
                    .align(ViewTooltip.ALIGN.CENTER)
                    .customView(customView)
                    .autoHide(false, 0)
                    .color(Color.parseColor("#FFFFFF"))
                    .show()*/
        }
    }
}
