class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        if(Integer.parseInt(event1[0].split(":")[0]) > 
Integer.parseInt(event2[0].split(":")[0])) {
            String[] temp = event1;
            event1 = event2;
            event2 = temp;
        }
        if(Integer.parseInt(event1[1].split(":")[0]) > 
Integer.parseInt(event2[0].split(":")[0])) {
            return true;
        } else if(Integer.parseInt(event1[1].split(":")[0]) == 
Integer.parseInt(event2[0].split(":")[0])) {
            if(Integer.parseInt(event1[1].split(":")[1]) >= 
Integer.parseInt(event2[0].split(":")[1])) return true;
        }
        return false;
    }
}
