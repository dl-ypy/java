interface �շ�{
   public void ��ȡ����();
}
interface �����¶�{
   public void controlTemperature();
}
class �������� implements �շ�{
   public void ��ȡ����(){
      System.out.println("��������:1Ԫ/�ţ������㹫����");
    }
}
class ���⳵ implements �շ�,�����¶�{
   public void ��ȡ����(){
      System.out.println("���⳵:3.20Ԫ/������3����");
    }
   public void controlTemperature(){
      System.out.println("��װ��Hair�յ�");
    }
}
public class Example5_15{
   public static void main(String args[]){
       �������� ��·=new ��������();//����Ϊ��7��·��
       ���⳵ ����=new ���⳵();
       ��·.��ȡ����();
       ����.��ȡ����();
       ����.controlTemperature();
    }
}