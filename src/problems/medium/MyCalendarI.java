package problems.medium;

import java.util.ArrayList;
import java.util.TreeMap;

public class MyCalendarI {
    /***
     * #729. My Calendar I
     * https://leetcode.com/problems/my-calendar-i/
     */

    /*
    Option 1: implementation with ArrayList
     */

    private ArrayList<int[]> bookings;
    public MyCalendarI() {
        this.bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(bookings.size()<2){
            if(bookings.size()==0){
                bookings.add(new int[]{start, end});
                return true;
            }else{//there is only 1 element in the List
                int[] b = bookings.get(0);
                if(b[1]<= start){
                    bookings.add(new int[]{start, end});
                    return true;
                }else if(start <= b[0] && end <= b[0]){
                    bookings.add(0, new int[]{start, end});
                    return true;
                }else{
                    //in all other cases intervals overlap.
                    return false;
                }
            }
        }

        int[] prev = bookings.get(0);
        for(int i = 1; i< bookings.size(); i++){
            int[] booking = bookings.get(i);
            if(i == 1 && end<=prev[0]){ // handle when added to the beginning
                bookings.add(0, new int[]{start, end});
                return true;

            }
            if(end<=booking[0] && start>=prev[1]){//we found the right spot! insert the booking
                bookings.add(i, new int[]{start, end});
                return true;
            }
            if(i == bookings.size()-1 && start >= booking[1]) {//handle when added to the end
                bookings.add(new int[]{start, end});
                return true;
            }
            if(end<=booking[0] && start<prev[1]){ //optimization to break faster
                return false;
            }
            prev = booking;
        }
        return false;
    }


    /*
    Option 2: implementation with TreeMap
     */
    TreeMap<Integer, Integer> map;
    public MyCalendarI(int i) { //<-- remove int i
        map = new TreeMap<>();
    }

    public boolean book1(int start, int end) {
        Integer prev = map.floorKey(start); //the greatest key less than or equal to the given key
        Integer next = map.ceilingKey(start);//the least key greater than or equal to the given key
        if((prev == null || map.get(prev)<=start) && //map.get(prev)<=start --->>> if prev ends before start
                (next== null || next >= end )){ //next >= end --->>> if next starts after end
            map.put(start, end);
            return true;
        }
        return false;
    }
}
