package ncs.test6;

import java.util.Comparator;

public class Descending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {

		int result = 0;

		Integer inum = (Integer) o1;
		Integer inum2 = (Integer) o2;

		return inum2 - inum;
	}

}
