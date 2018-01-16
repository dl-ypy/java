import java.io.*;
import java.util.*;
public class ClassMana implements Serializable{
    String classname;
    int  classnumber;
    Student classstudent[];
    CurriculumSchedule  curriculumschedule;
    public ClassMana()
    {
        curriculumschedule=new CurriculumSchedule(); 
        

    }

    public void input()
    {
        Scanner sc=new Scanner(System.in);    
        boolean flag=true;
        String  str;
        while(flag)
        {           
           System.out.println("您是否已经录入了该学期的教学计划？（Y/N）"); 
           str=sc.next();
             switch(str)
               {
                   case "Y":flag = false;break;
                   case "N":{
                           System.out.println("您是要手动录入，还是要从文件读入教学计划？0：手动录入；1：从文件读入！");
                           int x=sc.nextInt();
                           switch(x)
                           {
                              case 0:  curriculumschedule.input();break;     
                              case 1:  curriculumschedule.load();break;    
                              default:System.out.println("\t\t--------你输入的消息有误,程序将会出错！--------");  
                           }
                           flag = false;break;
                        }

               default:System.out.println("\t\t--------你输入的消息有误，请重新输入！--------");  
             }
           }
           System.out.println("请继续录入班级信息！..."); 
           System.out.println("该班级的名称是：");
           classname=sc.next();
           System.out.println("该班级有多少个学生？请输入：");
           classnumber=sc.nextInt();
           classstudent=new Student[classnumber];
           flag=true;
           while(flag)
           {
        	  
                System.out.println("您是否已经录入了班中学生的基本信息（不包含成绩）？（Y/N）"); 
                 str=sc.next();
                switch(str)
                {
                
                   case "Y":flag = false;break;
                   case "N":{
                                 for(int i=0;i<classnumber;i++)
                                 {
                                      classstudent[i]=new Student();
                                      classstudent[i].input();
                                  }
                           flag = false;break;
                        }

                 default:System.out.println("\t\t--------你输入的消息有误，请重新输入！--------");  
                 }
             }
            for(int i=0;i<classnumber;i++)
           {       
              
             classstudent[i].score=new float[curriculumschedule.currinumber];
             System.out.println("请录入第"+(i+1)+"位同学的各门课成绩：");
             for(int j=0;j<curriculumschedule.currinumber;j++)
             {
                System.out.println("请录入第"+(i+1)+"位同学的第"+(j+1)+"门课："+curriculumschedule.curriname[j]+"课的成绩：");
                classstudent[i].score[j]=sc.nextFloat();
             }
          }         


       }
       
    
   
   public void output()
   {
        for(int i=0;i<classnumber;i++)
           {       
             System.out.println("***********"+classname+"班第"+(i+1)+"个学生的信息如下：*********");  
             classstudent[i].output();
          }    
   }

   public void search()
   {
      //此方法可以直接进行学生信息查找，如果已经录入不用再录入。
       ClassMana cm=ClassMana.load();
       Scanner sc=new Scanner(System.in);
       int k=0;
       System.out.println("请输入您要查询的学生姓名："); 
       String name=sc.next();
       for(int i=0;i<cm.classnumber;i++)
       {
         
            if((cm.classstudent[i].namestr).equals(name))   
             {
                    k=i;  break;
             }
        }    
       cm.classstudent[k].output();
   }
  public void save()
  {
     try{
          FileOutputStream out=new FileOutputStream("classmana.txt");
          ObjectOutputStream ob=new ObjectOutputStream(out);          
          ob.writeObject(this);
          ob.close();
          out.close();
       }
      catch(Exception e){e.printStackTrace();}      
    
  }
  public static ClassMana load()
  {
       ClassMana cm=new ClassMana();
       try{
           
          FileInputStream in=new FileInputStream("classmana.txt");
          ObjectInputStream ob=new ObjectInputStream(in);
          cm=(ClassMana)ob.readObject();
          ob.close();
          in.close();
       }
      catch(Exception e){e.printStackTrace();}  
       return cm;

  }
}
