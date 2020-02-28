import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MegaSort{
    //merge sort method
	public static void sort(Integer arr[] , int start, int end) {
 	if (start>=end)
	return;
	 // find the middle point to divide the array into two halves
    int mid = (start + end) / 2;
    sort(arr, start, mid); //call sort on first half
    sort(arr, mid + 1, end); //call sort on second half
  
    // merge solved pieces to get solution
    int  first = mid, last = mid + 1;
    while ((start <= first) && (last <= end)) {
    	if((arr[start]<arr[last]))
    		start++;
    	else {
    		int temp=arr[last];
    		for(int k= last-1; k>=start; k--)
    		{
    			arr[k+1]=arr[k];
    		}
    		arr[start]=temp;
    		start++;
    		first++;
    		last++;
    	}
    }
  }
    //main method
	public static void main(String[] args)	{
	try
	{
		//to read file as an argument from terminal
	File file = new File(args[0]);
	BufferedReader br = new BufferedReader(new FileReader(file));
	List<Integer> arr =new ArrayList<Integer>(); //creating arraylist to hold integers
	String line;
	while ((line=br.readLine()) != null) 
	{   
		arr.add(Integer.parseInt(line));
	}
	br.close();
	Integer[] input = arr.toArray(new Integer[arr.size()]);
	sort(input,0,input.length-1);
	for (Integer a:input)
		System.out.println(a);
	 } catch (IOException e) {
			System.out.println(e.getMessage());
	  	}
	}

}
	
	

