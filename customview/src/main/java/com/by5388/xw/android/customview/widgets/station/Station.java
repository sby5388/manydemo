package com.by5388.xw.android.customview.widgets.station;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author by5388  on 2018/10/26.
 */
public class Station {
    public static final int ITEM_PLATFORM = StationViewApi.COLOR_PLATFORM;
    public static final int ITEM_LINE = StationViewApi.COLOR_LINE;
    public static final int ITEM_INDEPENDENT_LINE = StationViewApi.COLOR_INDEPENDENT_LINE;
    private List<BaseStationItem> stationItems;
    private String name;


    public Station setStationItem(@NonNull Integer... items) {
        for (Integer item : items) {
            switch (item) {
                case ITEM_PLATFORM:
                    stationItems.add(new StationPlatform());
                    break;
                case ITEM_LINE:
                    stationItems.add(new StationLine());
                    break;
                case ITEM_INDEPENDENT_LINE:
                    stationItems.add(new StationIndependentLine());
                    break;
                default:
                    break;
            }
        }
        return this;
    }

    public Station setStationItem(List<Integer> items) {
        if (items == null || items.isEmpty()) {
            return this;
        }
        for (Integer item : items) {
            switch (item) {
                case ITEM_PLATFORM:
                    stationItems.add(new StationPlatform());
                    break;
                case ITEM_LINE:
                    stationItems.add(new StationLine());
                    break;
                case ITEM_INDEPENDENT_LINE:
                    stationItems.add(new StationIndependentLine());
                    break;
                default:
                    break;
            }
        }
        return this;
    }

    public static Station createStation(String name, @NonNull List<BaseStationItem> stationItems) {
        return new Station(name, stationItems);
    }

    public Station addStationItem(BaseStationItem item) {
        this.stationItems.add(item);
        return this;
    }

    private Station(String name, @NonNull List<BaseStationItem> stationItems) {
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
