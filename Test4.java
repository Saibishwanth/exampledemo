class A
{
    public int x= 10;
    public A(){ System.out.println("A");}
}
class B extends A{
    public int x= 20;
    public B(){ System.out.println("B");}
}
class C extends B{
 public int x= 30;
    public C(){ System.out.println("c");}
    public void show()
    {
        System.out.println(x+" "+x+" "+x);
    }
}
class Test4{
    public static void main(String[] args)
    { 
        C c1 = new C();
        c1.show();
    }
}

