public class  Cft{
double width;
double eight;
double length;
double getVolume(){
return width*eight*length;
}
}
class Example{
public static void main(String args[]){
Cft tiji=new Cft();
tiji.width=1.1;
tiji.eight=1.2;
tiji.length=1.0;
double volume=tiji.getVolume();
System.out.println("矩形的体积:"+volume);
}
}
