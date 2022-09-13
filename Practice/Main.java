class Main
{
	public static void main(String[] args)
	{
		Circle circle = new Circle(2.1);
		if(circle.getRadius() == 2.1)
		System.out.println("Correct");
		else
		System.out.println("Wrong");
	}
}
/* 
     your code goes here
    example:
          class Circle{
          
         }
*/
class Circle
{
      double radius;
      Circle(double radius)
      {
            this.radius = radius < 0 ? 0 : radius;
      }
      public double getRadius()
      {
            return this.radius;
      }
      public double getArea()
      {
            return this.radius*this.radius*3.14159265358979323846;
      }
}
class Cylinder extends Circle
{
      double height;
      Cylinder(double height, double radius)
      {
            super(radius);
            System.out.println("Cylinder constructer :"+height+" "+radius);
            this.height = height < 0 ? 0 : height;
      }
      public double getHeight()
      {
            return this.height;
      }
      public double getVolume()
      {     
            System.out.println("volumn: "+getArea()*this.height);
            return getArea()*this.height;
      }
}