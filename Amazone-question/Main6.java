import java.util.*;
public class Main6 {  
    public static void main(String[] args) {
        /*
         * Amazon Delivery Centers dispatch parcels every day. There are n delivery centers each having parcels[i] parcels to be delivered. On each day, an equal number of parcels are to be dispatched from each delivery center that has at least one parcel remaning.

            Find the maximum number of days needed to deliver all the parcels.

            Example:
            parcels = [4,2,3,4]

            On the First day - [2,0,1,2]
            On the 2nd day - [1,0,0,1]
            On the 3rd day - [0,0,00]

            The Answer is 3 days.
         */
        int[] arr = {4,2,3,4};
        Set<Integer> set = new HashSet<>();
        for(int i : arr) set.add(i);
        System.out.print(set.size());

    }
    
}
