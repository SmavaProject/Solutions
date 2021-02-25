package problems.medium;

import java.util.Arrays;

/***
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/ MEDIUM, SORTING
 * Does not pass test cases because of "Time limit exceeded"
 */
public class FraudulentActivityNotifications
{
    public static int activityNotifications(int[] expenditure, int d) {
        if(expenditure.length< d){
            return 0;
        }
        int numberOfNotifications = 0;
        int median = 0;

        //calculate the number of notifications
        for (int i = d; i< expenditure.length; i++){
            median = calculateMedian(expenditure, d, i-d,i-1);
            int currDay = expenditure[i];
            if(currDay >=median*2){
                numberOfNotifications++;
            }
        }

        return numberOfNotifications;
    }

    public static int calculateMedian(int[] expenditure, int d, int start, int end) {
        if(end-start != d-1){
            return -1;
        }
        int[] medianArray = new int[d];
        int index = 0;
        for (int i = start; i<= end; i++){
            medianArray[index] = expenditure[i];
            index++;
        }
        int median = 0;
        Arrays.sort(medianArray);
        if (d%2 == 1){
            median = medianArray[d/2];
        }else{
            median = (medianArray[d/2] + medianArray[d/2+1])/2;
        }
        return median;
    }
}
