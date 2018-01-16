/*
ʱ�䣺2016��11��9��10:32:10
Ŀ�ģ���ȡ��ҳ�е�email
*/
import java.io.*;
import java.util.regex.*;

public class RegularExpression_09{
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new FileReader("email.html"));
			String line = "";
			while((line=br.readLine()) != null){
				parse(line);
			}
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	private static void parse(String line){
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		while (m.find()){
			System.out.println(m.group());	
		}
	}
}
/*
***************JDK1.8���н��***************
gsw888@163.com
jshsjx@jshs.com.cn
chinawutong@126.com
cdsongli@126.com
zbshenchang@163.com
zzjianxing@126.com
tjzf@tjzf.com
4151447@126.com
xuxia928@163.com
wangqianjuan@163.com
qsyj@jjqsyj.cn
sanjiangjx@alibaba.com.cn
mr.zhang.yao@163.com
......
*/