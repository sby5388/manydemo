package com.by5388.xw.android.customview.widgets.station;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.by5388.xw.android.customview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by5388  on 2018/10/26.
 */
public class StationView extends View implements StationViewApi {

    private static final String TAG = "StationView";
    private Station station;
    private List<Integer> colors;

    private Paint paintText, paintPlatform, paintLine, paintIndependentLine;


    private void initView(Context context, AttributeSet attrs) {
        // TODO: 2018/10/26
        initStationData();
        initPaintData();


    }

    private void initPaintData() {
        paintPlatform = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paintPlatform.setStyle(Paint.Style.FILL);
        paintPlatform.setColor(colors.get(COLOR_PLATFORM));


        paintLine = new Paint(paintPlatform);
        paintLine.setColor(colors.get(COLOR_LINE));
        paintLine.setStrokeWidth(4);


        paintIndependentLine = new Paint(paintPlatform);
        paintIndependentLine.setColor(colors.get(COLOR_INDEPENDENT_LINE));
        paintIndependentLine.setStrokeWidth(4);

        paintText = new Paint(paintPlatform);
        paintText.setColor(Color.RED);
        paintText.setTextSize(26);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final float width = getWidth() - getPaddingLeft() - getPaddingRight();
        final float height = getHeight() - getPaddingTop() - getPaddingBottom();
        // TODO: 2018/10/19 ?? 设置画笔起点？
        canvas.translate(width / 2, height / 5);

        canvas.drawText(station.getName(), 10, 30, paintText);
        List<BaseStationItem> items = station.getStationItems();

        int top = 60;
        Rect rect = new Rect(50, top, 150, top + 20);

        for (int i = 0; i < items.size(); i++) {
            BaseStationItem item = items.get(i);
            if (!item.isLine) {
                updateRect(rect);
                canvas.drawRect(rect, paintPlatform);
            } else {
                updateRect(rect);
                if (item.isIndependentLine) {
                    canvas.drawLine(0, rect.top + 10, 200, rect.top + 10, paintIndependentLine);
                } else {
                    canvas.drawLine(0, rect.top + 10, 200, rect.top + 10, paintLine);
                }
            }
        }
    }

    void updateRect(Rect rect) {
        rect.bottom += 30;
        rect.top += 30;
    }

    private void initStationData() {
        StationDataApi api = new StationData();
        station = api.getStation("ChaoShan");

        colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimary));
        colors.add(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // TODO: 2018/10/27
        Log.d(TAG, "onMeasure: " + widthMeasureSpec + " " + heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // TODO: 2018/10/27
        Log.d(TAG, "onLayout: " + changed + " " + left + " " + right + " " + bottom);
    }


    public StationView(Context context) {
        this(context, null);
    }

    public StationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public StationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);

    }

    @Override
    public StationViewApi setStation(Station station) {
        this.station = station;
        return this;
    }

    @Override
    public StationViewApi setColor(List<Integer> colors) {
        if (colors.isEmpty() || colors.size() > 2) {
            this.colors = colors;
        }
        return this;
    }


    @Override
    public void rePaint() {
        // TODO: 2018/10/26 清除画布内容重新画
    }


}
