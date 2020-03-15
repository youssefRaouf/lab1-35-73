package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Sort<T> implements ISort {

	ArrayList list;
	@Override
	 public IHeap heapSort(ArrayList unordered) {
        // TODO Auto-generated method stub
		 IHeap heap=new Heap();
		if(unordered==null) {
			System.out.println("d5l");
			return heap;
		}
//		Collections.sort(unordered);
        heap.build(unordered);
//        IHeap heapclone=new Heap();
//        heapclone.build(unordered);
//        for(int i=0;i<unordered.size();i++)
//        {
//            unordered.set(i,heap.extract());
//        }
// 
        return heap;
    }

	@Override
	public void sortSlow(ArrayList unordered) {
		// TODO Auto-generated method stub
		if(unordered==null) {
			return ;
		}
		int n = unordered.size();
		boolean swapped = false;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				Object a = unordered.get(j);
				Comparable<T> x = (Comparable<T>) unordered.get(j);
				Comparable<T> y = (Comparable<T>) unordered.get(j + 1);

				if (x.compareTo((T) y) > 0) {
					// swap arr[j+1] and arr[i]
					Object temp = unordered.get(j);
					unordered.set(j, unordered.get(j + 1));
					unordered.set(j + 1, temp);
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
	}
	public void sortSlowIndex(ArrayList unordered,int low,int high) {
		// TODO Auto-generated method stub
		if(unordered==null) {
			return ;
		}
		int n = unordered.size();
		boolean swapped = false;
		for (int i = low; i < high; i++) {
			for (int j = low; j < high - i; j++) {
				Object a = unordered.get(j);
				Comparable<T> x = (Comparable<T>) unordered.get(j);
				Comparable<T> y = (Comparable<T>) unordered.get(j + 1);

				if (x.compareTo((T) y) > 0) {
					// swap arr[j+1] and arr[i]
					Object temp = unordered.get(j);
					unordered.set(j, unordered.get(j + 1));
					unordered.set(j + 1, temp);
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
	}
	 @Override
     public void sortFast(ArrayList unordered) {
         // TODO Auto-generated method stub
         if(unordered ==null)
             return;
    
         list = unordered;

        // div(0,unordered.size()-1);
    
        part(0,unordered.size()-1);
        
     }


      public void part(int l,int r) {
             if(l<r) {
                 part(l,(l+r)/2);
                 part((l+r)/2+1,r);
                 mergesort(l,r);
             }
            
            
         }
      public void mergesort(int l,int r)  {
            
             int mid=(l+r)/2+1,i=l,j=mid;
             Vector<Object> temp=new Vector();
             while(i<mid&&j<=r) {
                
                 Comparable<T> x=(Comparable<T>)list.get(i);
                 Comparable<T> y=(Comparable<T>)list.get(j);
                 if(x.compareTo((T)y)<0) {
                     temp.add(list.get(i++));
                 }
                 else {
                     temp.add(list.get(j++));
                 }
                
             }
             while(i<mid) {
                 temp.add(list.get(i++));
             }
             while(j<=r) {
                 temp.add(list.get(j++));
             }
             j=0;
             for(i=l;i<=r;i++) {
                 list.set(i, temp.get(j++));
             }
            
         }

}
