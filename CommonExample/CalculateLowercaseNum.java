package com.ypy.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * date:2017年7月7日11:45:32
 * target：统计字符串中小写字母的个数，并循环打印出。
 * @author ypy
 */
public class CalculateLowercaseNum {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("People always say to students that their main duty is to study and they should not spend time on other things except for study. However, most boys are born to love exercise, especially ball exercises. Thus, they are always blamed to spend time on playing balls, instead of spending all time on study. In my opinion, the idea is wrong. Proper exercise is good for study. Exercise can help students relax their mind and body. After a long time study, they need it very much. After relaxing, they can have a good state to study, which will improve their study efficiency. Besides, students always can sleep better after exercise. If they sleep well, they can have more energy on study. It promotes study. But spending too much time on exercise may have bad influence on study.");
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int j='a'; j<=122; j++) {
			for (int i=0; i<sb.length(); i++) {
				if (sb.charAt(i) == j) {
					count++;
				}
			}
			map.put((char)(j), count);
			count = 0;
		}
		Set<Entry<Character, Integer>> entry = map.entrySet();
		for (Entry<Character, Integer> e : entry) {
			System.out.println(e.getKey() + "\t" +e.getValue());
		}
	}	
}
/*
***************JDK1.8运行结果****************
a	36
b	8
c	18
d	31
e	86
f	10
g	10
h	23
i	37
j	0
k	0
l	27
m	16
n	39
o	39
p	15
q	0
r	30
s	48
t	57
u	20
v	7
w	8
x	9
y	30
z	0
*/
