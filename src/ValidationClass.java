public class ValidationClass {
	
public static boolean numcheck(String tocheck)
{
	if(tocheck.matches("[0-9]+"))
	{
		if(tocheck.length()>10)
		{
			return false;
		}
		else
		{
			return true;	
		}
	}
	else
	{
		return false;
	}
}

public static boolean decimalnumcheck(String tocheck)
{
	if(tocheck.matches("[0-9.]+"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
	
public static boolean charactercheck(String tocheck)
{
	if(tocheck.matches("[A-Za-z.\\s]+"))
	{
		return true;
	}
	else
	{
		return false;
	}
}

public static boolean charactercheckadd(String tocheck)
{
	if(tocheck.matches("[0-9A-Za-z.,\\s]+"))
	{
		return true;
	}
	else
	{
		return false;
	}
}



}
