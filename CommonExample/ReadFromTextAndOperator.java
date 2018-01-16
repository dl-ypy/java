import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * date:2017��6��30��11:04:25
 * target:���������µ��ı��ļ��ж�ȡ�����е�����������ӡ���ظ����������ظ��Ĵ�����
 * �����ظ��������� �����������ظ���������
 * 1,����,28
 * 2,����,35
 * 3,����,28
 * 4,����,35
 * 5,����,28
 * 6,����,35
 * 7,����,28
 * 8,����,35
 * @author ypy
 */
public class ReadFromTextAndOperator {
	public static void main(String[] args) {
		String[] arr = getFilesContent("test.txt", "\n");
		User[] users = getUserArray(arr, ",", 1);
		Map<String, Integer> map = getMap(users);
		traverse(map);
	}
	
	/**
	 * �õ��ļ��е����ݣ������䰴��һ���ķ��ŷָ����һ���ַ�������
	 * @param name �ļ���
	 * @param regex �ָ����
	 * @return �ַ�������
	 */
	public static String[] getFilesContent(String name, String regex) {
		String str = "";
		try {
			FileReader fr = new FileReader(name);
			StringBuffer sb = new StringBuffer();
			int ch;
			
			try {
				ch = fr.read();
				while (ch != -1) {
					sb.append((char)ch);
					ch = fr.read();
				}
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			str = sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("���ļ������ڣ�");
		}
		String[] arr = str.split(regex);
		return arr;
	}
	
	/**
	 * ����һ���Ĺ���ÿ���ַ��������ٷָ���µ����飬����Ҫ�����ݸ���һ����������
	 * @param arr Ҫ�ָ���ַ�������
	 * @param regex �ָ����
	 * @param n ��Ҫ�������������е�����
	 * @return ��������
	 */
	public static User[] getUserArray(String[] arr, String regex, int n) {
		User[] users = new User[arr.length];
		for (int i=0; i<arr.length; i++) {
			String[] arr1 = arr[i].split(regex);
			users[i] = new User(arr1[n]);
		}
		return users;
	}
	
	/**
	 * �������������ظ������ֺ��ظ���������Map��
	 * @param users
	 * @return Map����
	 */
	public static Map<String, Integer> getMap(User[] users) {
		int count = 1;
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<users.length; i++) {
			for (int j=i+1; j<users.length; j++) {
				if (users[i].compareTo(users[j]) == 1) {
					count++;
				}
			}
			if (map.get(users[i].getName()) == null) {
				map.put(users[i].getName(), count);
			}
			count = 1;
		}
		
		return map;
	}
	
	/**
	 * ����map����ӡ�ظ������ֺ��ظ�����
	 * @param map
	 */
	public static void traverse(Map<String, Integer> map) {
		Map<String, Integer> map1 = new HashMap<>();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<String, Integer> es = it.next();
			Integer i = es.getValue();
			if (i>1) {
				map1.put(es.getKey(), i);
			}
		}
		Map<String, Integer> map2 = (Map<String, Integer>) sortMapByValue(map1);
		System.out.println(map2);
	}
	
	/**
	 * ��Map���Ͻ��а�ֵ����
	 * @param oriMap
	 * @return ����������Map����
	 */
	public static Map<?, ?> sortMapByValue(Map<String, Integer> oriMap) {  
	    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
	    
	    if (oriMap!=null && !oriMap.isEmpty()) {  
	        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(oriMap.entrySet());  
	        Collections.sort(entryList,  
	                new Comparator<Map.Entry<String, Integer>>() {  
	                    public int compare(Entry<String, Integer> entry1,  
	                            Entry<String, Integer> entry2) {  
	                        int value1 = entry1.getValue(), value2 = entry2.getValue();  
	                        return value2 - value1;//��Ϊ���������෴��Ϊ��������  
	                    }  
	                });  
	        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();  
	        Map.Entry<String, Integer> tmpEntry = null;  
	        //��ԭ���ϵļ�ֵ�Է����µļ�����
	        while (iter.hasNext()) {  
	            tmpEntry = iter.next();  
	            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());  
	        }  
	    }  
	    return sortedMap;  
	}  
}

class User {
	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(User user) {
		if (this.name.equals(user.name)) {
			return 1;
		}
		return -1;
	}
}

/*
***************JDK1.8���н��****************
{����=3, ����=2}
*/
