package problems.easy;

import java.util.HashMap;

public class LoggerRateLimiter {
    /***
     * 359. Logger Rate Limiter
     * https://leetcode.com/problems/logger-rate-limiter/
     */

    class Logger {

        HashMap<String, Integer> map;
        public Logger() {
            this.map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!this.map.containsKey(message)){
                map.put(message, timestamp);
                return true;
            }else{
                int lastUpdated = this.map.get(message);
                if(lastUpdated <= timestamp -10){
                    map.put(message, timestamp);
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
