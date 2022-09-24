class Stream1
{
	public static void main(String[] args)
	{
		Pair<String,Integer> p = new Pair<>("tarun",9384);
		System.out.println(p.name);
		System.out.println(p.id);
	}
}

class Pair<T,V>
{
	T name;
	V id;
	Pair(T name, V id)
	{
		this.name = name;
		this.id = id;
	}
}