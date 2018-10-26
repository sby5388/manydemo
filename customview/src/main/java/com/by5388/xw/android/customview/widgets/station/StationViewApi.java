package com.by5388.xw.android.customview.widgets.station;

import java.util.List;

/**
 * @author by5388  on 2018/10/26.
 */
public interface StationViewApi {
    int COLOR_PLATFORM = 0;
    int COLOR_LINE = 1;
    int COLOR_INDEPENDENT_LINE = 2;

    StationViewApi setStation(Station station);

    StationViewApi setColor(List<Integer> colors);

    void rePaint();
}
