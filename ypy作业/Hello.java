public class Hello{
public static void main(String arg[]){
Student stu=new Student();
stu.speak("we are student");
}
}
class Student{
void speak(String s){
System.out.println(s);
}
}