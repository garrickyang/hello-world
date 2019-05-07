package yanggui.kata.karatechop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KarateChopTest {
	@Test
	public void ChopArrayTest(){
		
        assertEquals(-1, chop(3, Arrays.asList()));
        assertEquals(-1, chop(3, Arrays.asList(1)));
        assertEquals(2, chop(3, Arrays.asList(1,2,3)));
        assertEquals(1, chop(3, Arrays.asList(2,3)));
		
	}

	public int chop(int key, List<Integer> list) {
//		for (int i = 0;i<list.size();i++) {
//			if(list.get(i)==key){
//				return i;
//			}
//		}
//		return -1;
		
		if(key==list.get(list.size()-1)||list.size()==0){
			return list.size()-1;
		}else{
			
			ArrayList<Integer> arraylist=new ArrayList<Integer>(list);			
			arraylist.remove(arraylist.size()-1);
			return chop(key, arraylist);
		}
		
	}

}
