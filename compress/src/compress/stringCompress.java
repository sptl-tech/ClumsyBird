package compress;


public class stringCompress {
	public static String compress(String s) {
	    if (s.length() <= 1) {
	      return s;
	    }
	    StringBuilder output = new StringBuilder();
	    char last = s.charAt(0);
	    int sum = 1;
	    
	    for (int i = 1; i<s.length(); i++) {
	    	if(s.charAt(i) == last) {
	    		sum++;
	    	}
	    	else {
	    		output.append(""+last + sum);
	    		sum = 1;
	    		last = s.charAt(i);
	    	}
	    }
	    output.append("" + last + sum);
	    
	    
	    return output.toString();
	}
	  public static void main(String[] args) {
	    System.out.println(compress("aabcccccaaa"));
	  }
	}

