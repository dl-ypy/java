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
           System.out.println("���Ƿ��Ѿ�¼���˸�ѧ�ڵĽ�ѧ�ƻ�����Y/N��"); 
           str=sc.next();
             switch(str)
               {
                   case "Y":flag = false;break;
                   case "N":{
                           System.out.println("����Ҫ�ֶ�¼�룬����Ҫ���ļ������ѧ�ƻ���0���ֶ�¼�룻1�����ļ����룡");
                           int x=sc.nextInt();
                           switch(x)
                           {
                              case 0:  curriculumschedule.input();break;     
                              case 1:  curriculumschedule.load();break;    
                              default:System.out.println("\t\t--------���������Ϣ����,���򽫻����--------");  
                           }
                           flag = false;break;
                        }

               default:System.out.println("\t\t--------���������Ϣ�������������룡--------");  
             }
           }
           System.out.println("�����¼��༶��Ϣ��..."); 
           System.out.println("�ð༶�������ǣ�");
           classname=sc.next();
           System.out.println("�ð༶�ж��ٸ�ѧ���������룺");
           classnumber=sc.nextInt();
           classstudent=new Student[classnumber];
           flag=true;
           while(flag)
           {
        	  
                System.out.println("���Ƿ��Ѿ�¼���˰���ѧ���Ļ�����Ϣ���������ɼ�������Y/N��"); 
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

                 default:System.out.println("\t\t--------���������Ϣ�������������룡--------");  
                 }
             }
            for(int i=0;i<classnumber;i++)
           {       
              
             classstudent[i].score=new float[curriculumschedule.currinumber];
             System.out.println("��¼���"+(i+1)+"λͬѧ�ĸ��ſγɼ���");
             for(int j=0;j<curriculumschedule.currinumber;j++)
             {
                System.out.println("��¼���"+(i+1)+"λͬѧ�ĵ�"+(j+1)+"�ſΣ�"+curriculumschedule.curriname[j]+"�εĳɼ���");
                classstudent[i].score[j]=sc.nextFloat();
             }
          }         


       }
       
    
   
   public void output()
   {
        for(int i=0;i<classnumber;i++)
           {       
             System.out.println("***********"+classname+"���"+(i+1)+"��ѧ������Ϣ���£�*********");  
             classstudent[i].output();
          }    
   }

   public void search()
   {
      //�˷�������ֱ�ӽ���ѧ����Ϣ���ң�����Ѿ�¼�벻����¼�롣
       ClassMana cm=ClassMana.load();
       Scanner sc=new Scanner(System.in);
       int k=0;
       System.out.println("��������Ҫ��ѯ��ѧ��������"); 
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
