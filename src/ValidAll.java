
public class ValidAll {
	
	public static String validation(
			String name,String address,String phone,String blood,String age,
			String gender,String height,String weight,
			String occupation,String donate,String selpak,String amountp)
	{
		int check = 0; 
		
		String msg = "please Give";
		
		if(name.length()==0)
		{
			msg = msg + " ,Name ";
			

		}
		else
		{
			check++;
		}

		
		
		if(address.length()==0)
		{
			msg = msg + " ,Address ";	

		}
		else
		{
		
			check++;
		}
		
		
		
		
		if(phone.length()==0)
		{
			msg = msg + " ,Valid Phone no";
		}
		else if(phone.length()>10 || phone.length()<10)
		{
			msg = msg + " ,Valid Phone no";
		}
		else
		{
			check++;
		}
		
		
		
		if(blood.length()==0)
		{
			msg = msg + " ,Blood ";

		}
		else
		{
			check++;
			
		}

		
		
		if(age.length()==0)
		{
			msg = msg + " ,Age ";
		}
		else
		{
			check++;
			
		}
		
		
		
		if(gender.length()==0)
		{
			msg = msg + ",Gender ";
		}
		else
		{
			check++;
			
		}
		
		
		
		if(height.length()==0)
		{
			msg = msg + ",height ";
		}
		else
		{
			check++;
	
		}
		
		
		
		if(weight.length()==0)
		{
			msg = msg + ",weight ";
		}
		else
		{
			check++;
			
		}
		
		
		
		if(occupation.length()==0)
		{
			msg = msg + ",occupation ";
		}
		else
		{
			check++;


		}
		
		
		
		if(donate.length()==0)
		{

			msg = msg + ",Want to donate ";
			
		}
		else
		{
			check++;
		}
		
		
		
		if(selpak.length()==0)
		{
			msg = msg + ",Select package ";
			
		}
		else
		{
			check++;
		}
		
		
		
		if(amountp.length()==0)
		{
			msg = msg + ",Amount to pay ";
			
		}
		else
		{			
			check++;
		}
		
		
		if(check == 12)
		{
			return "pass";	
		}
		else
		{
			return msg;
		}
		
	}

public static String validation1(String amo, String name)
{
	int check = 0; 
	String msg = null;
	if(amo.length()==0)
	{
		msg = "Please Enter Amount to pay ";
		
	}
	else
	{			
		check++;
	}
	
	
	if(check == 1)
	{
		return "pass";	
	}
	else
	{
		return msg;
	}
}


}
