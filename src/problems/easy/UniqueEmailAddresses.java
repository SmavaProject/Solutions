package problems.easy;

import java.util.HashSet;

public class UniqueEmailAddresses {
    /***
     * #929. Unique Email Addresses
     * https://leetcode.com/problems/unique-email-addresses/
     */
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email: emails){
            String[] splitedEmail = email.split("@");
            String[] localName = splitedEmail[0].split("\\+");
            String clearLocalName = localName[0].replace(".", "");

            String finalStr = clearLocalName + "@" + splitedEmail[1];
            set.add(finalStr);
        }

        return set.size();
    }
}
