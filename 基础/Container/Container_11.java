import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * date:2017年4月22日17:54:53
 * target:ListIterator。
 * @author ypy
 * conclusion:
 *     ListIterator比Iterator多出一些方法。
 *     ListIterator只适用于List及其子类。
 */
public class Container_11 {
	public static void main(String[] args) {
		List<Object> arraylist = new ArrayList<>();
		for (int i=0; i<5; i++) {
			arraylist.add(i);
		}
		print2(arraylist);
	}
	
	public static void print2(List<Object> o) {
		System.out.println("-------------------");
		ListIterator<Object> it = o.listIterator();
		it.add("新增元素");   //ListIterator可以添加元素，但是在当前游标的前面添加，所以第一次顺序遍历时不会显示
						    //如果第一次遍历为逆序遍历，就可以显示出来
		while (it.hasNext()) {
			System.out.println("返回后索引：" + it.nextIndex());
			System.out.println(it.next());
		}
		System.out.println("-------------------");
		while (it.hasPrevious()) {  //ListIterator可以逆序遍历，但必须在顺序遍历之后，因为第一次遍历时，
			                        //游标位于第一个元素的前面，如果逆序遍历，则前面没有元素
			System.out.println(it.previous());
		}
		System.out.println("-------------------");
		while (it.hasNext()) {
			System.out.println("返回前索引：" + it.previousIndex());
			System.out.println(it.next());
		}
		System.out.println("-------------------");
		it.set("修改");   //ListIterator可以修改元素
						 //用指定元素替换 next 或 previous 返回的最后一个元素（可选操作）。
					     //只有在最后一次调用 next 或 previous 后既没有调用 ListIterator.remove 也没有调用 ListIterator.add 时才可以进行该调用。
		                 //本实验中在调用该方法前最后一次调用的next是在上个顺序遍历的最后一个，
		                 //所以在下面逆序遍历时，输出的修改后的元素是第一个
		while (it.hasPrevious()){
			System.out.println(it.previous());
		}
		System.out.println("-------------------");
		it.remove();  //删除元素，与set方法的使用相似
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
/*
 * *************** jdk1.8运行结果*************** 
-------------------
返回后索引：1
0
返回后索引：2
1
返回后索引：3
2
返回后索引：4
3
返回后索引：5
4
-------------------
4
3
2
1
0
新增元素
-------------------
返回前索引：-1
新增元素
返回前索引：0
0
返回前索引：1
1
返回前索引：2
2
返回前索引：3
3
返回前索引：4
4
-------------------
修改
3
2
1
0
新增元素
-------------------
0
1
2
3
修改
 */
