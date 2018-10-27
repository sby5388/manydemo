package com.by5388.xw.android.customview.widgets.station;

import java.util.ArrayList;
import java.util.List;

/**
 * 内置一些默认的数据来作为测试
 *
 * @author by5388  on 2018/10/27.
 */
public class StationData implements StationDataApi {


    private List<Station> stations;
    private static int currentPosition = 0;

    public StationData() {
        stations = new ArrayList<>();
        initData(stations);
    }


    @Override
    public Station getStation(String stationName) {
        for (Station station : stations) {
            if (stationName.equals(station.getName())) {
                currentPosition = stations.indexOf(station);
                return station;
            }
        }
        return stations.get(0);
    }

    @Override
    public Station getNextStation() {
        if (currentPosition + 1 >= stations.size()) {
            currentPosition = 0;
        } else {
            currentPosition += 1;
        }
        return stations.get(currentPosition);
    }


    private static void initData(List<Station> stations) {
        if (null == stations) {
            stations = new ArrayList<>();
        }

        stations.add(Station.createStation("RaoPing", new ArrayList<BaseStationItem>())
                .setStationItem(ITEM_LINE, ITEM_PLATFORM, ITEM_LINE, ITEM_INDEPENDENT_LINE, ITEM_INDEPENDENT_LINE, ITEM_LINE, ITEM_PLATFORM));
        stations.add(Station.createStation("ChaoShan", new ArrayList<BaseStationItem>())
                .setStationItem(2, 0, 1, 1, 0, 1, 2, 2, 2, 2, 1, 0, 1, 1, 0, 2));
    }
}
