package view.pager.recycler.nestedviewpager.pager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class SquareViewPager : ViewPager {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // here we are creating square view pager where height = width
        // so instead of height we pass width as a parameter
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)

        setMeasuredDimension(measuredWidth, measuredWidth)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(ev)
    }
}