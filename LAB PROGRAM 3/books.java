import java.util.Scanner;
class books{
	String name;
	String author;
	int price,numPages;
	books(String name,String author,int price,int numPages)
{
	this.name=name;
	this.author=author;
	this.price=price;
	this.numPages=numPages;
}

public String toString()
{
	String name,author,price,numPages;
	name="Book name:"+ this.name +"\n";
	author="Author name:"+ this.author +"\n";
	price="Price:"+ this.price +"\n";
	numPages="Number of pages:"+ this.numPages +"\n";
	return name+author+price+numPages;
}
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	int n;
	String name;
	String author;
	int price;
	int numPages;
	System.out.println("Enter the number of books;");
	n=s.nextInt();
	books b[];
	b=new books[n];
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter the book "+(i+1)+"name:");
		name=s.next();
		System.out.println("Enter the book "+(i+1)+" author:");
		author=s.next();
		System.out.println("Enter the book "+(i+1)+" price:");
		price=s.nextInt();
		System.out.println("Enter the book "+(i+1)+" number of pages:");
		numPages=s.nextInt();
		b[i]=new books(name,author,price,numPages);
	}
	for(int i=0;i<n;i++)
	{
		b[i].toString();
		System.out.println(b[i]);
	}
	System.out.println("Lakshith P");
	System.out.println("1BM23CS164");
}}
		
		