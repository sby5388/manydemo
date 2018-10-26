package com.by5388.xw.android.customview.widgets.circle;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author by5388  on 2018/10/26.
 */
public class CircleView extends View implements CircleApi {

    public static final String TAG = CircleView.class.getSimpleName();

    private int colorOne = Color.RED;
    private int colorTwo = Color.GREEN;
    private int colorThree = Color.BLUE;
    private static Canvas sCanvas;

    /**
     * 默认站占父控件的比例
     */
    private double size = 0.85;

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;

    RectF rectF = new RectF();

    private void initView(Context context, AttributeSet attrs) {
        // TODO: 2018/10/19 ??
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(80);

        //画笔paint2 的属性与画笔1一致，除了颜色
        paint2 = new Paint(paint1);
        //画笔3同上
        paint3 = new Paint(paint1);
        paint3.setStyle(Paint.Style.FILL);

        setPaintColor();

    }

    private void setPaintColor() {
        paint1.setColor(colorOne);
        paint2.setColor(colorTwo);
        paint3.setColor(colorThree);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sCanvas = canvas;
        startDraw(canvas);
    }

    private void startDraw(Canvas canvas) {
        final float width = getWidth() - getPaddingLeft() - getPaddingRight();
        final float height = getHeight() - getPaddingTop() - getPaddingBottom();
        // TODO: 2018/10/19 ??
        canvas.translate(width / 2, height / 2);


        //半径
        final float radius = (float) (Math.min(width, height) / 2 * getSize());

        //四个边与上边、左边的距离(坐标)
        //具体是（float left, float top, float right, float bottom
        rectF.set(-radius, -radius, radius, radius);

        canvas.drawArc(rectF, 0, 120, false, paint1);
        canvas.drawArc(rectF, 120, 120, false, paint2);
        canvas.drawArc(rectF, 240, 120, false, paint3);

        paint1.setColor(Color.GRAY);
        canvas.drawCircle(100, 100, 30, paint1);
    }


    public double getSize() {
        return size;
    }

    @Override
    public CircleApi setSize(double size) {
        this.size = size;
        return this;
    }

    @Override
    public CircleApi setColor(int color1, int color2, int color3) {
        this.colorOne = color1;
        this.colorTwo = color2;
        this.colorThree = color3;
        return this;
    }

    @Override
    public void rePaint() {
        if (sCanvas == null) {
            // FIXME: 2018/10/25 空指针异常
            // TODO: 2018/10/25  将所在布局的画布清空，重新绘制
            return;
        }
        startDraw(sCanvas);
    }


    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);

    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        initView(context, null);
    }

    private void nothing(Paint paint,Canvas canvas) {
        Path path = new Path();
        canvas.drawPath(path,paint);

    }

}
