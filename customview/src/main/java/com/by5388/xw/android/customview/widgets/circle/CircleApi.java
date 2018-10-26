package com.by5388.xw.android.customview.widgets.circle;

import android.support.annotation.ColorInt;

/**
 * @author by5388  on 2018/10/26.
 */
public interface CircleApi {
    /**
     * 设置大小
     *
     * @param size 比例值，0.5~0.9
     * @return 自身
     */
    CircleApi setSize(double size);

    /**
     * 设置颜色
     *
     * @param color1 1
     * @param color2 2
     * @param color3 3
     * @return 自身
     */
    CircleApi setColor(@ColorInt int color1, @ColorInt int color2, @ColorInt int color3);

    /**
     * 重新画
     */
    void rePaint();
}
