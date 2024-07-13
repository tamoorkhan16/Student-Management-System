package ACP.Client;

import javax.swing.JOptionPane;
import ACP.Employee.Employee;
import java.io.*;


public class Client
{
    public static void main(String[] args) {
        Employee[] A = new Employee[50]; 
        int n = -1;

        File empdb = new File("EmpDB.dat"); 
        if(empdb.exists())
        {
            try
            {
                FileInputStream fis = new FileInputStream(empdb);
                ObjectInputStream ois = new ObjectInputStream(fis);
                A = (Employee[]) ois.readObject(); 
                for (int i = 0; i < A.length; i++) 
                {
                    if(A[i] != null)
                    {
                        n++; 
                    }
                    else break;
                }
                ois.close(); 
                fis.close();
            }catch(Exception e)
            {
                e.printStackTrace();

            } 
        }

        do 
        {

            int choice = Integer.parseInt( JOptionPane.showInputDialog("MAIN MENU\n1 Add an Employee\n2 Update an Employee's Information\n3 Delete an Employee's Information\n4 Search and View Employees\n5 Quit"));
            switch(choice)
            {
                case 1: 
                {
                 
                    if(n+1 != A.length) 
                    {
                        n++; 
                        A[n] = new Employee(); 
                        A[n].setEmpInformation();
                    }
                   
                    else JOptionPane.showMessageDialog(null, "No space for new Employee  !");
                    break;
                } 

                case 2: 
                {
                    if(n != -1)
                    {
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of employee you want to Update : ")) ;
                        int index = Employee.search(A,n,id,null,-1,null);
                        if(index != -1) 
                        {
                            A[index].updateEmpInformation();
                        }
                        
                        else JOptionPane.showMessageDialog(null, "No Employee with such ID found !");
                    }
                    
                    else JOptionPane.showMessageDialog(null, "Add an Employee first !");

                    break;
                } 

                case 3: 
                {
                    if(n != -1) 
                    {
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of employee you want to Remove : ")) ;
                        int index = Employee.search(A,n,id,null,-1,null);
                        if(index != -1) 
                        {
                            n = Employee.deleteEmpInformation(A,n,index);
                        }
                        
                        else JOptionPane.showMessageDialog(null, "No Employee with such ID found !");
                    }
                    
                    else JOptionPane.showMessageDialog(null, "Add an Employee first !");

                    break;
                } 

                case 4: 
                {
                    if(n != -1) 
                    {
                        choice = Integer.parseInt( JOptionPane.showInputDialog("\n\t\tSearch Menu\n\t1 <- Search by Employee's ID\n\t2 <- Search by Employee's Name\n\t3 <- Search by Employee's Age\n\t4 <- Search by Employee's Job category\n\t5 <- Go back to Main menu"));
                        switch(choice)
                        {
                            case 1:
                            {
                                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of employee you want to Search : ")) ;
                                int index = Employee.search(A,n,id,null,-1,null);
                                if(index != -1)
                                {
                                    A[index].display(); 
                                }
                                else JOptionPane.showMessageDialog(null, "No Employee with such ID found !");
                                break;
                            }

                            case 2:
                            {
                                String name = JOptionPane.showInputDialog(null, "Enter the Name of employee you want to Search : ");
                                int index = Employee.search(A,n,-1,name,-1,null);
                                if(index != -1)
                                {
                                    A[index].display(); 
                                }
                                else JOptionPane.showMessageDialog(null, "No Employee with such Name found !");
                                break;
                            }

                            case 3:
                            {
                                int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Age of employee you want to Search : "));
                                int index = Employee.search(A,n,-1,null,age,null);
                                if (index != -1) 
                                {
                                    A[index].display();    
                                }
                                else JOptionPane.showMessageDialog(null, "No Employee with such Age found !");
                                break;
                            }

                            case 4:
                            {
                                String jobCategory = JOptionPane.showInputDialog(null, "Enter the Job Category of Employee you want to search : ");
                                int index = Employee.search(A, n, -1, null, -1, jobCategory);
                                if(index != -1)
                                {
                                    A[index].display();
                                }
                                else JOptionPane.showMessageDialog(null, "No Employee with such Job Category found !");
                                break;
                            }

                            case 5:
                            {
                                break;
                            }


                        }
                    }
                   
                    else JOptionPane.showMessageDialog(null, "Add an Employee first !");

                    break;

                }

                case 5:
                {
                    try
                    {
                        
                        FileOutputStream fos = new FileOutputStream(empdb);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(A);
                        oos.close();
                        fos.close();
                        return;
                    }catch(Exception e)
                    {
                        e.printStackTrace();

                    }
                    break;

                }

                default: 
                {
                    JOptionPane.showMessageDialog(null, "Please Choose a Valid Option !");
                    break;
                } 


            } 

        }while(true); 
        
    }
}