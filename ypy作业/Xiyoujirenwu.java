public enum PersonName{��ɮ,���,�˽�,ɳɮ}
public class Xiyoujirenwu{
PersonName name;float height,weight;String head;
void speak(String s){
if(name==PersonName.�˽�){head="����ͷ";}
else if(name==PersonName.���){head="��Ůͷ";}
System.out.println(s);
}
}
public class Example4_1{
public static void main(String arg[]){
Xiyoujirenwu zhubajie,sunwukong;
zhubajie=new Xiyoujirenwu();
sunwukong=new Xiyoujirenwu();
zhubajie.name=PersonName.�˽�;
zhubajie.height=1.83f;
zhubajie.weight=86f;
zhubajie.head="��ͷ";
sunwukong.name=PersonName.���;
sunwukong.height=1.66f;
sunwukong.weight=1000f;
sunwukong.head="��ͷ";
System.out.println(zhubajie.name+"�����:"+zhubajie.height);
System.out.println(zhubajie.name+"������:"+zhubajie.weight);
System.out.println(zhubajie.name+"��ͷ:"+zhubajie.head);
System.out.println(sunwukong.name+"�����"+sunwukong.height);
System.out.println(sunwukong.name+"������"+sunwukong.weight);
System.out.println(sunwukong.name+"��ͷ"+sunwukong.head);
zhubajie.speak(zhubajie.name+"����Ȣϱ��");
System.out.println(zhubajie.name+"���ڵ�ͷ:"+zhubajie.head);
sunwukong.speak(sunwukong.name+"����"+sunwukong.weight+"�����ƭ�˽䱳��");
System.out.println(sunwukong.name+"���ڵ�ͷ:"+sunwukong.head);
}
}