package class01;
import java.util.ArrayList;

class Person{
   String name;
   int point;
   void use() {
      this.point--;
      System.out.println(this.name+"님 출력중...");
   }
   Person(String name,int point){
      this.name=name;
      this.point=point;
   }
   @Override
   public String toString() {
      return "Person [name=" + name + ", point=" + point + "]";
   }
}

public class Test03 {
   public static void main(String[] args) {

      ArrayList<Person> data=new ArrayList<Person>();
      data.add(new Person("홍길동",1000));
      data.add(new Person("아무무",2000));
      
      for(int i=0;i<data.size();i++) {
         // data.get(i) == Person 객체
         data.get(i).use();
      }
      
      System.out.println(data);
            
   }
}