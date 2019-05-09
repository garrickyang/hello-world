package karatechop;

import java.util.ArrayList;
import java.util.List;

public class KarateChop {
	public static int chopByIterate(int key, List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == key) {
				return i;
			}
		}
		return -1;

	}

	public static int chopByRecursive(int key, List<Integer> list) {

		if (key == list.get(list.size() - 1) || list.size() == 0) {
			return list.size() - 1;
		} else {

			ArrayList<Integer> arraylist = new ArrayList<Integer>(list);
			arraylist.remove(arraylist.size() - 1);
			return chopByRecursive(key, arraylist);
		}

	}

}
