package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class DesignUndergroundSystem {
    /***
     * 1396. Design Underground System
     * https://leetcode.com/problems/design-underground-system/
     * For some reason, Leetcode does not accept solution where a HashMap key is String[] or some private object.
     * Therefore, in the map "travelTimes" key is ->> String stations = info.startStation + "-" + stationName;
     */

    class UndergroundSystem {
        //<start station - end station , travel times>
        HashMap<String, ArrayList<Integer>> travelTimes;
        //<id, startStation>
        HashMap<Integer, TravelInfo> isCurrentlyTravelling;

        public UndergroundSystem() {
            this.travelTimes = new HashMap<>();
            this.isCurrentlyTravelling = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            if(this.isCurrentlyTravelling.containsKey(id))return;
            TravelInfo info = new TravelInfo(stationName, t);
            this.isCurrentlyTravelling.put(id, info);
        }

        public void checkOut(int id, String stationName, int t) {
            TravelInfo info = isCurrentlyTravelling.get(id);
            if(info == null)return;
            String stations = info.startStation + "-" + stationName;
            ArrayList<Integer> travelTime = this.travelTimes.getOrDefault(stations, new ArrayList<>());

            travelTime.add(t - info.startTime);
            this.travelTimes.put(stations, travelTime);
            this.isCurrentlyTravelling.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            String stations = startStation + "-" + endStation;
            ArrayList<Integer> times = this.travelTimes.get(stations);
            if(times==null){
                return 0.0;
            }
            return times.stream().mapToDouble(d -> d).average().orElse(0.0);
        }

        private class TravelInfo{
            public String startStation;
            public int startTime;

            public TravelInfo(String startStation,int startTime){
                this.startStation = startStation;
                this.startTime = startTime;
            }
        }
    }
}
