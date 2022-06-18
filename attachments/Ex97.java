class A
{
int x;

A(int xx)					//8
{
this.x = xx;					//9
}						//10

void display()					//20
{	
System.out.println("Data X is : " + x);		//21
}						//22
}

class B extends A
{
String y;

B(int xx, String yy)				//6				
{
super(xx);					//7
this.y = yy;					//11
}						//12

void display()					//18
{
super.display();				//19
System.out.println("Data Y is : " + y);		//23
}						//24
}

class C extends B
{
double z;

C(int xx, String yy, double zz)			//4
{
super(xx,yy);					//5
this.z = zz;					//13
}						//14

void display()					//16
{
super.display();				//17
System.out.println("Data Z is : " + z);		//25
}						//26
}

class Ex97
{
public static void main(String args[])		//1
{
C obj1;						//2
obj1 = new C(100, "Java", 10.55);		//3
obj1.display();					//15
}						//27
}						//28