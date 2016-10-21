
import java.util.Scanner;
/**
 * This is a class to define the necessary attributes and methods to conceptualize a "Student"
 * The spepcific tasks are:
 * 1. Instiate 
 * 
 * @author Arpan Bhowmik
 * @version 1
 */
public class Student
{
    //Declare the important attributes of a student. For example:
    
    static Scanner sc = new Scanner(System.in);
    
    public static Student[] ara = new Student[100];
    
    int Id;
    
    String StudentName;
    
    String Department;
    
    String University;
    
    public static double NofSubjects;
    
    public static double NofStudents;
    
    public static double NofTerms;
    
    double [] GPA=new double[100];
    
    //double [] CGPA=new double[100];
    
    String [][] Subjects= new String [100][20];
    
    double [][] Credits=new double[100][20];
    
    double [][] Grades=new double[100][20];
    
    double cg;
   
    

    /**
     * Define a constructor that initilize the default properties of the Student
     */
    public Student(int id, String name, String dept, String university)
    {
        Id=id;
        
        StudentName=name;
        
        Department=dept;
        
        University=university;
        
        
    }
    /**
     * Define a method to print the students details.
     */
    
    public void studentDetailsById(int iD)
    {
        System.out.println("Name          :" + ara[iD].StudentName + "\n"); 
        
        System.out.println("Id            :" + ara[iD].Id + "\n");
        
        System.out.println("University    :" + ara[iD].University + "\n");
        
        System.out.println("Department    :" + ara[iD].Department + "\n");
        
        int y=1,t=1;
        
        for(int i=1; i<=NofTerms; i++)
        {
            System.out.println("Gpa of term " + i +  ": " + ara[iD].GPA[i]+ "\n"); 
            
            
        }
        
        System.out.println("Cgpa         :" + ara[iD].cg + "\n");
            
            
            
    }
    
    /**
     * Define a method to update information of students by ID
     * Use as many arguments as required.
     */
    public void updateStudentById(int id)
    {
        System.out.println("Do you want to update any information(1 for yes/0 for no)?");
        
        int ch=sc.nextInt();
        
        if(ch==1)
        {
            System.out.println("Please enter the Upadated information:");
            
            System.out.println("######################################################" + "\n");
            
            System.out.println("Please enter the name: ");
            
            String n=sc.next();
            
            System.out.println("Please enter the id: ");
            
            int ID=sc.nextInt();
            
            System.out.println("Please enter the university: ");
            
            String u=sc.next();
            
            System.out.println("Please enter the department: ");
            
            String d=sc.next();
            
            ara[id].StudentName=n;
            
            ara[id].Id=ID;
            
            ara[id].University=u;
            
            ara[id].Department=d;
        
            int i,j;
            
            for(i=1; i<=NofTerms; i++)
           {
               
                System.out.println("Please enter the number of Subjects in term: " + i + "\n");
                
                int NofSubjects=sc.nextInt();
                
                for(j=1; j<=NofSubjects; j++)
                {
                    System.out.println("Please enter the Subject name, credit and acquired gpa in that subject respectively:\n");
                    
                    String s=sc.next();
                
                    double c=sc.nextDouble();
                    
                    double g=sc.nextDouble();
                
                    ara[id].Credits[i][j]=c;
                    
                    ara[id].Grades[i][j]=g;
                    
                    ara[id].Subjects[i][j]=s;
               
                }
            
           }
        
          
          
           ara[id].computeGPAById(id);
        
           ara[id].computeCGPAByID(id);
        
           ara[id].studentDetailsById(id);
        }
        
        else
        
        {
            return ;
        }
            
            
        
        
    }
   
    
    /**
     * Define a method to compute the GPA from the given Credits and Grades of all the subjects
     */
    public void computeGPAById(int id)
    {
        int i,cnt=1,j;
        
        double temp=0.0,tot=0.0,gpa;
        
        for(j=1; j<=NofTerms; j++)
        {
            temp=0.0;
            
            tot=0.0;
            
            for(i=1; i<=NofSubjects; i++)
            {
                temp+=Credits[j][i]*Grades[j][i];
            
                tot+=Credits[j][i];
            }
            
            gpa=temp/tot;
        
            GPA[cnt]=gpa;
        
            cnt++;
        }
        
 
    }
    
    public double computeCGPAByID(int id)
    {
        int i,j;
        
        double tot=0.0,cgpa;
        
        for(i=1; i<=NofTerms; i++)
        {
            tot+=GPA[i];
        }
        
        cgpa=tot/NofTerms;
        
        cg=cgpa;
        
        return cgpa;
            
    }
    
    /**
     * After performing required operations on each student, save the information to a file. Use File and PrintWriter Class. 
     * use as many arguments as required.
     * 
     */
   
    public static void main(String[] args)
    {
        
        int k;
        
        System.out.println("Please enter the number of Students you want to save:\n");
        
        NofStudents=sc.nextDouble();
       
        for(k=1; k<=NofStudents; k++){
            
            System.out.println("Please enter the Student no " + k + " information\n");
            
            System.out.println("#####################################################" + "\n");
        
            System.out.println("Please enter the student name:" );
        
            String st=sc.next();
        
            System.out.println("Please enter the student id:" );
        
            int id=sc.nextInt();
        
            System.out.println("Please enter the university:" );
        
            String u=sc.next();
        
            System.out.println("Please enter Department name:" );
        
            String d=sc.next();
        
            ara[k]=new Student(id,st,d,u);
        
            int i,j;
            
            System.out.println("Please enter the number of terms:\n");
            
            NofTerms=sc.nextDouble();
        
            for(i=1; i<=NofTerms; i++)
           {
                System.out.println("Please enter the number of Subjects in term: " + i + "\n");
                
                NofSubjects=sc.nextDouble();
                
                for(j=1; j<=NofSubjects; j++)
                {
                    System.out.println("Please enter the Subject name, credit and acquired gpa in that subject respectively:\n");
                    
                    String s=sc.next();
                    
                    double c=sc.nextDouble();
                    
                    double g=sc.nextDouble();
                    
                    ara[k].Credits[i][j]=c;
                    
                    ara[k].Grades[i][j]=g;
                    
                    ara[k].Subjects[i][j]=s;
               
                }
            
           }
        
           ara[k].computeGPAById(k);
        
           ara[k].computeCGPAByID(k);
        
           ara[k].studentDetailsById(k);
        
           ara[k].updateStudentById(k);
        }
        
        for(k=1; k<=NofStudents; k++)
        {
            System.out.println("After update operation(yes/no) the information of student "+ k + ":\n");
            System.out.println("*************************************************"+"\n");
            ara[k].studentDetailsById(k);
        }
        
        
                
                
        
        
        
    }
}
