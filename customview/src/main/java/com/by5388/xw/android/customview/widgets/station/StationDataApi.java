package com.by5388.xw.android.customview.widgets.station;

/**
 * @author by5388  on 2018/10/27.
 */
public interface StationDataApi {
    int ITEM_PLATFORM = StationViewApi.COLOR_PLATFORM;
    int ITEM_LINE = StationViewApi.COLOR_LINE;
    int ITEM_INDEPENDENT_LINE = StationViewApi.COLOR_INDEPENDENT_LINE;

    Station getStation(String stationName);

    Station getNextStation();
}
