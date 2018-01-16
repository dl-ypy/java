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
 * date:2017年6月30日11:04:25
 * target:从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，
 * 并按重复次数排序： 次数，并按重复次数排序：
 * 1,张三,28
 * 2,李四,35
 * 3,张三,28
 * 4,王五,35
 * 5,张三,28
 * 6,李四,35
 * 7,赵六,28
 * 8,田七,35
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
	 * 得到文件中的内容，并将其按照一定的符号分割，返回一个字符串数组
	 * @param name 文件名
	 * @param regex 分割规则
	 * @return 字符串数组
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
			System.out.println("该文件不存在！");
		}
		String[] arr = str.split(regex);
		return arr;
	}
	
	/**
	 * 按照一定的规则将每个字符串数组再分割成新的数组，将想要的内容赋给一个对象数组
	 * @param arr 要分割的字符串数组
	 * @param regex 分割规则
	 * @param n 所要内容在新数组中的索引
	 * @return 对象数组
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
	 * 将对象数组中重复的名字和重复次数放入Map中
	 * @param users
	 * @return Map集合
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
	 * 遍历map，打印重复的名字和重复次数
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
	 * 对Map集合进行按值排序
	 * @param oriMap
	 * @return 返回排序后的Map集合
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
	                        return value2 - value1;//此为降序排序，相反则为升序排序  
	                    }  
	                });  
	        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();  
	        Map.Entry<String, Integer> tmpEntry = null;  
	        //将原集合的键值对放入新的集合中
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
***************JDK1.8运行结果****************
{张三=3, 李四=2}
*/
