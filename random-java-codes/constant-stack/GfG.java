
class GfG
{
    int minEle;
    Stack<Integer> s;
    GfG(){
        s = new Stack<Integer>();
    }

    /*returns min element from stack*/
    int getMin()
    {
	   
  if(s.empty()) return -1;
  else return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
	 int x;
   if(s.empty()) return -1;
   else{
       x=s.peek();
       s.pop();
       if(x<minEle){
           int k=minEle;
           minEle= 2*minEle - x;
           return k;
       }
       else return x;
   }
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here	
	if(s.isEmpty()) {
	    s.push(x);
	    minEle = x;
	} else {
	    if(x < minEle) {
	        s.push(2*x-minEle);
	        minEle = x;
	    } else {
	        s.push(x);
	    }
	}
	
    }	
}
