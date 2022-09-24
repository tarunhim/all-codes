import java.util.*;
import java.io.*;
class Stream1
{
	public static void main(String[] args)
	{
		List<Pair<String,Integer>> list = new ArrayList<>();
		list.add(new Pair<>("tarun",8898));
		list.add(new Pair<>("varun",3848));
		list.add(new Pair<>("akash",8420));
		list.add(new Pair<>("rohan",8348));
		list.stream().forEach((item) -> System.out.println(item.name+" "+item.id));
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