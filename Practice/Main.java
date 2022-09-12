class Main
{
	public static void main(String[] args)
	{
		One one = new One();
		one.isEmail();
		One two = new Two();
		two.isEmail();
		Two three = new Two();
		three.isEmail();
	}
}

class One
{	
	void isEmail()
	{
		System.out.println("this is email from class One");
	}
}

class Two extends One
{
	void isEmail()
	{
		System.out.println("this email from class two");
	}
}