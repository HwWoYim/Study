package class07;

import java.util.HashMap;

public class Test07 {
   public static void main(String[] args) {
      // Map 맵
      HashMap map=new HashMap();
      map.put(101,"콜라");
      map.put(102,"사이다");
      map.put(107,"웰치스");
      System.out.println(map);
      
      // AL : [10,20,30]
      // AL[0] == 10
      // AL[1] == 20
      
      // Map : {101=콜라, 102=사이다}
      // Map[101] == 콜라
      // Map[102] == 사이다      
      
      System.out.println(map.get(101));
      
      // Map2 : {apple=사과, banana=바나나}
      // Map2[apple] == 사과
      HashMap map2=new HashMap();
      map2.put("apple", "사과");
      map2.put("banana", "바나나");
      map2.put("kiwi", "키위");
      System.out.println(map2);
      System.out.println(map2.get("apple"));
      
      map2.remove("banana");
      System.out.println(map2);
      
      System.out.println(map2.size());
   }
}