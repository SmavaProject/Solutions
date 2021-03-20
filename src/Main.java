import problems.Comp;
import problems.medium.FraudulentActivityNotifications;
import problems.medium.MinimumTimeRequired;
import problems.medium.SherlockAndTheValidString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main (String[] args)
    {
        //System.out.println(SherlockAndTheValidString.isValid("aaaabbcc"));
        //System.out.println(MinimumTimeRequired.minTime(new long[]{4, 5, 6}, 12));

        List<String> abc = new ArrayList<>();
        abc.add("435");
        abc.add("");
        abc.add("gbd");
        abc.add("GBD");
        Collections.sort(abc);
        System.out.println(abc);
        //System.out.println("ATL".compareTo("SFO"));

        System.out.println(FraudulentActivityNotifications.activityNotifications(new int[]{10, 20, 30, 40, 50}, 3));

        int[][] arr = new int[][]{{1, 3}, {4, 6,},{1, 6}};
        System.out.println(Comp.toTry(arr));
    }
}
