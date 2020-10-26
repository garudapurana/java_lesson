package ua.gg.lol;

public class aaa{

	public static void main(String[]args){

		System.out.println("Hello,world!");
		double l=5;
		System.out.println("Площадь квадрата со стороной "+l+" = "+area(l));
		double a = 3;
		double b = 6;
		System.out.println("Площадь прямоугольника со сторонами "+a +" и "+b+" = "+area(a,b));
		}


	public static double area(double value){
		return value*value;

	}
	public static double area(double a,double b){
		return a * b;
	}
}