package ACP.Employee;


import javax.swing.*;
import java.io.Serializable; 

public class Employee implements Serializable 
{
    public static int id = 9000; 
    private String empName;
    private String empFname;
    private int empId = id; 
    private String jobCategory; 
    private String doB;
    private String education;
    private int payScale;
    private String NIC;
    private int age;


    public Employee(){
        id++;
        empId = id; 
    }

    
    public boolean checkInformation(String checkWhat)
    {
        //if checking education
        if(checkWhat.equals("education"))
        {
            if(jobCategory.equals("Teacher") || jobCategory.equals("teacher"))
            {
                if(!education.equals("MS") && !education.equals("PHD"))
                {
                    JOptionPane.showMessageDialog(null,"Teacher Cannot have education lower than MS !");
                    return false;
                }
            }
    
            else if(jobCategory.equals("Officer") || jobCategory.equals("officer"))
            {
                if(education.equals("Matric") || education.equals("FSC"))
                {
                    JOptionPane.showMessageDialog(null, "Officer cannot have education less than BS !");
                    return false;

                }
            }
    
            else if(jobCategory.equals("Staff") || jobCategory.equals("staff"))
            {
                if(education.equals("Matric"))
                {
                    JOptionPane.showMessageDialog(null, "Staff cannot have education less than FSc !");
                    return false;

                }
            }
    
            else if(jobCategory.equals("Labour") || jobCategory.equals("labour"))
            {
                if(!education.equals("Matric"))
                {
                    JOptionPane.showMessageDialog(null, "Labour Must be Matric Pass !");
                    return false;

                }
            }

        }

        //if checking payscale
        else if(checkWhat.equals("payscale"))
        {  
            if(jobCategory.equals("Teacher") || jobCategory.equals("teacher"))
            {
                if(payScale < 18)
                {
                    JOptionPane.showMessageDialog(null,"Teacher Cannot have payscale lower than 18 !");
                    return false;

                }
            }
    
            else if(jobCategory.equals("Officer") || jobCategory.equals("officer"))
            {
                if(payScale < 17)
                {
                    JOptionPane.showMessageDialog(null, "Officer cannot have payscale less than 17 !");
                    return false;

                }
            }
    
            else if(jobCategory.equals("Staff") || jobCategory.equals("staff"))
            {
                if(payScale < 11 || payScale > 16)
                {
                    JOptionPane.showMessageDialog(null, "Staff cannot have payscale less than 11 or greater than 16 !");
                    return false;

                }
            }
    
            else if(jobCategory.equals("Labour") || jobCategory.equals("labour"))
            {
                if(payScale < 1 || payScale > 10)
                {
                    JOptionPane.showMessageDialog(null, "Labour Must have payscale less than 11 and greater then 0 !");
                    return false;

                }
            }

        }

        return true; //if correct education or payscale  

    }

    
    public void setEmpInformation()
    {

         boolean checkexception = false; 
        do
        {
            
            try
            {
                empName = JOptionPane.showInputDialog(null, "Enter Employee Name : ");
                empFname = JOptionPane.showInputDialog(null, "Enter Employee Father Name : ");
                jobCategory = JOptionPane.showInputDialog(null, "Enter Job Category (teacher,officer,staff,labour) : ");
                boolean check ; 
                do
                {
                    education = JOptionPane.showInputDialog(null, "Enter "+jobCategory+"'s Education (PHD,MS,BS,FSC,Matric) : ");
                    check = checkInformation("education"); 

                }while(!check);

                do
                {
                    payScale = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter "+jobCategory+"'s Payscale : "));
                    check = checkInformation("payscale"); 

                }while(!check); 

                doB = JOptionPane.showInputDialog(null, "Enter Employee Date of Birth (DD-MM-YYYY) : ");
                age = Integer.parseInt(doB.substring(6));
                age = 2021 - age;
                NIC = JOptionPane.showInputDialog(null, "Enter Employee's NIC : ");
            }catch(Exception e)
            {
                checkexception = true;
                JOptionPane.showMessageDialog(null,"invalid value entered Enter Values again !");
            }
            checkexception = false;
        }while(checkexception == true); 
    }

    
    public void updateEmpInformation()
    {
        try
        {
            jobCategory = JOptionPane.showInputDialog(null, "Enter new Job Category : ");
            boolean check ; 
            do
            {
                education = JOptionPane.showInputDialog(null, "Enter "+jobCategory+"'s new Education : ");
                check = checkInformation("education");

            }while(!check);

            do
            {
                payScale = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter "+jobCategory+"'s new Payscale : "));
                check = checkInformation("payscale"); 

            }while(!check); 
        }catch(Exception e)
        {
                JOptionPane.showMessageDialog(null,"Enter a Valid Value !");
        }

    }

    
    public static int deleteEmpInformation(Employee [] A,int n,int index)
    {

        for (int j = index; j < A.length-1; j++)
        {
            A[j] = A[j+1];
        }
        n--; 
        return n; 

    }


    public static int search(Employee[] A, int n, int id, String name, int age, String jobcat)
    {
        for (int i = 0; i <= n; i++) 
        {
            if(id != -1) 
            {
                if(id == A[i].empId)
                {
                    return i;      
                }

            }

            else if(name != null) 
            {
                if(name.equals(A[i].empName))
                {
                    return i;
                }
            }

            else if(age != -1) 
            {
                if(A[i].age == age)   
                {
                    return i;
                } 
            }

            else if(jobcat != null) 
            {
                if (jobcat.equals(A[i].jobCategory)) 
                {
                    return i;   
                }
            }
        }
        
        return -1; 
    }

    
    public void display()
    {
        JOptionPane.showMessageDialog(null, "Employee Information : \n Name : "+empName+"\n Father Name : "+empFname+"\n ID : "+empId+"\n Job Category : "+jobCategory+"\n Education : "+education+"\n Payscale : "+payScale+"\n CNIC : "+NIC);
    }




}