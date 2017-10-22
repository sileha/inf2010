public class HashMapTest 
{

   public static void main(String[] args) 
   {
      MyHashMap<Integer, String> mhmap = new MyHashMap<Integer, String>();
      mhmap.put(25, "patate");
      mhmap.put(15, "chou-rave");
      mhmap.put(10, "patate");
      mhmap.put(25, "chou-rave");
      mhmap.put(14, "sid");
      mhmap.put(26, "lahah");
      mhmap.put(3, "jeremy");
      
      System.out.println( mhmap.get(25) );
      System.out.println( mhmap.get(10) );
   }

}
