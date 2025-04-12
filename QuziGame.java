import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Quzi 
{
	private String Question;
	private String[] Option;
	private String CorrectAns;
	public void SetQuestion(String question ,String[] option, String correctAns)
	{
		Question=question;
		Option=option;
		CorrectAns=correctAns;
	}
	public String getquestion()
	{
		return Question;
	}
	public String[] getOption()
	{
		return Option;
	}
	public String getCorrectAns()
	{
		return CorrectAns;
	}
}
public class QuziGame {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		List<Quzi>question=new ArrayList<Quzi>();
		int Score=0;
		int Timelimit=15;
		String reset = "\u001B[0m";
		System.out.println("\u001B[31m"+"                           .......START QUZI.........\n"+reset);
		//Question1
		Quzi q1=new Quzi();
		String []option1=new String[] {"a.India","b.Italy","c.Japana","d.France"};
		q1.SetQuestion("Which is Country is Known as 'the Land of Festivals'?",option1,"a");
		question.add(q1);
		//Question2
		Quzi q2=new Quzi();
		String []option2=new String[] {"a.Darjeeling","b.Sikim","c.Jalpaiguri ","d.Purulia"};
		q2.SetQuestion("Where is Himalayan Mountaineering Institute Located ?",option2,"a");
		question.add(q2);
		//Question3
		Quzi q3=new Quzi();
		String []option3=new String[] {"a.8","b.10","c.12","d.14"};
		q3.SetQuestion("How manay teams currently participate in the IPL ?",option3,"b");
		question.add(q3);
		//Question4
		Quzi q4=new Quzi();
		String []option4=new String[] {"a.Bear","b.Gorilla","c.Tiger","d.Elephent"};
		q4.SetQuestion("What is the National Animal of Indian ?",option4,"c");
		question.add(q4);
		//Question5
				Quzi q5=new Quzi();
				String []option5=new String[] {"a.Kangaroo","b.Cila monster","c.Armadillo","d.Camel"};
				q5.SetQuestion("Which Animal can survive for up to two weeks without water ?",option5,"d");
				question.add(q5);
		int size=question.size();
		List<String>Ans=new ArrayList<String>();
		List<String>Question1=new ArrayList<String>();
		long Starttime=System.currentTimeMillis();
		for(int i=0;i<size;i++)
		{
			Quzi q=question.get(i);
			System.out.println("\u001B[38;5;208m"+"           "+(i+1)+"."+q.getquestion()+reset);
			Question1.add(q.getquestion());
			String []op=q.getOption();
			for(int j=0;j<op.length;j++)
			{
				System.out.println("\u001B[32m"+"              "+op[j]+reset);
			}
				String UserAns=getAnstimer(sc,Timelimit,Starttime);
				//UserAns=sc.nextLine();
				if(UserAns!=null &&UserAns.equals(q.getCorrectAns()))
				{
					Score++;
					Ans.add("Correct");
				}
				else
				{
					Ans.add("InCorrect");
				}
		}
			Show(Question1,Score,Ans,size);
		}
	public static String getAnstimer(Scanner sc, int timelimit,long starttime)
	{
		System.out.println("\u001B[31m"+"				You Have "+timelimit+" Second to Answer"+"\u001B[0m");
		String UserAns=null;
		while(System.currentTimeMillis()-starttime<timelimit*1500)
		{
			System.out.print("\u001B[34m"+"	    	    →"+"\u001B[0m");
			if(sc.hasNextLine())
			{
				UserAns=sc.nextLine();
				break;
			}
		
		}
		char ch=UserAns.charAt(0);
		if((ch>='a' && ch<='z'))
		{
				if(UserAns==null)
				{
					System.out.println("\u001B[31m"+"\n					Times Up!!\n"+"\u001B[0m");
					return null;
				}
				else
				{
					return UserAns;
				}
		}
		else if(ch>='A' && ch<='Z')
		{
			System.out.println("\u001B[31m"+"				Canot input capital alphbet"+"\u001B[0m");
			return null;
		}
		else if(ch>='0' && ch<='9')
		{
			System.out.println("\u001B[31m"+"				Canot input Number"+"\u001B[0m");
			return null;
		}
		else
		{
			System.out.println("\u001B[31m"+"				Canot input Spacial Character"+"\u001B[0m");
			return null;
		}
	}
	public static void Show(List<String>Question1,int Score, List<String>Ans,int Size)
	{
		System.out.println("\u001B[32m"+"                     ..................................................................."+"\u001B[0m");
		System.out.println("\u001B[31m"+"\n					    ..............Result.................\n"+"\u001B[0m");
		for(int i=0;i<Size;i++)
		{
			System.out.println("\u001B[38;5;208m"+"                            "+(i+1)+"."+Question1.get(i)+"\u001B[0m");
			System.out.println("				"+Ans.get(i));		
		}
		System.out.println("\u001B[32m"+"					    	  	 Your Total Score is:"+Score);
		System.out.println("		     ......................................................................");
	}
	

}

