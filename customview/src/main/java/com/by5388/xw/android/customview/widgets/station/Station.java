package com.by5388.xw.android.customview.widgets.station;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author by5388  on 2018/10/26.
 */
public class Station {
    private List<BaseStationItem> stationItems;
    private String name;

    public Station addStationItem(BaseStationItem item) {
        this.stationItems.add(item);
        return this;
    }

    public Station(String name, @NonNull List<BaseStationItem> stationItems) {
        this.stationItems = stationItems;
        this.name = name;
    }

    public Station setStationItems(List<BaseStationItem> stationItems) {
        this.stationItems = stationItems;
        return this;
    }

    public Station setName(String name) {
        this.name = name;
        return this;
    }

    public List<BaseStationItem> getStationItems() {
        return stationItems;
    }

    public String getName() {
        return name;
    }
}
