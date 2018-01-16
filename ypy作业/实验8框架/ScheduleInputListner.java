import java.awt.event.*;
public class ScheduleInputListner implements ActionListener
{
       public void actionPerformed(ActionEvent arg0) 
       {
         CurriculumSchedule cursche=new CurriculumSchedule();
         cursche.input();
         cursche.output();
       }
}