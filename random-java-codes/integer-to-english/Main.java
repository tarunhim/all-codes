class Main{
    public static void main(String[] args) {
        System.out.print(new Solution().numberToWords(345));
    }
}

class Solution {
    boolean flag = false;
    public String numberToWords(int num) {
        
        if(flag == false && num == 0) return "Zero";
        flag = true;
        String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
    "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen",
                        "Nineteen"};
        String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty",
                        "Ninety"};
if(num >= 1000000000) return (numberToWords(num/1000000000)+" Billion "+numberToWords(num%1000000000)).trim();
if(num >= 1000000) return (numberToWords(num/1000000)+" Million "+numberToWords(num%1000000)).trim();
if(num >= 1000) return (numberToWords(num/1000)+" Thousand "+numberToWords(num%1000)).trim();
if(num >= 100) return (numberToWords(num/100)+" Hundred "+numberToWords(num%100)).trim();
if(num >= 20) return (tens[num/10]+" "+numberToWords(num%10)).trim();
return ones[num];
    }
}