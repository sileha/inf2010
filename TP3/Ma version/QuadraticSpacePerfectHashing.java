import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType>
{
   static int p = 46337;

   int a, b, m;
   AnyType[] items;

   QuadraticSpacePerfectHashing()
   {
      a=b=0; items = null;
   }

   QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
   {
      AllocateMemory(array);
   }

   public void SetArray(ArrayList<AnyType> array)
   {
      AllocateMemory(array);
   }

   public int Size()
   {
      if( items == null ) return 0;

      return items.length;
   }

   public boolean containsKey(int key)
   {
      // A completer
      if(items[key] != null)
         return false;
      return true;
   }

   public boolean containsValue(AnyType x ) {

      /** Allowed to change method? */
      if (Size() == 0) return false;

      int index = getKey(x);
      if (items[index] != null)
         return true;

      return false;
   }

   public void remove (AnyType x) {
      // A completer
      int temp = getKey(x);
      items[temp] = null;
   }

   public int getKey (AnyType x) {
      // A completer
      return ( ( a*x.hashCode() + b ) % p ) % m;
   }

   @SuppressWarnings("unchecked")
   private void AllocateMemory(ArrayList<AnyType> array)
   {
      Random generator = new Random( System.nanoTime() );


      m = (int) (Math.pow(array.size(), 2));
      if(array == null || array.size() == 0)
      {
         // A completer
         return;
      }
      if(array.size() == 1)
      {
         a = b = 0;
         items = (AnyType[]) new Object[(int) (Math.pow(array.size(), 2))];
         int index = ( ( a*array.get(0).hashCode() + b ) % p ) % m;
         items[index] = array.get(0);
         return;
      }
      // A completer
      if(array.size() > 1) {
         items = (AnyType[]) new Object[(int) (Math.pow(array.size(), 2))];
         a = generator.nextInt(p);
         b = generator.nextInt(p);
         for(AnyType item: array) {
            int index = ( ( a*item.hashCode() + b ) % p ) % m;
            items[index] = item;
         }
      }

   }



   public String toString () {
      String result = "";

      // A completer
      for(int i = 0; i < items.length -1; i++) {
          if (items[i] != null)
              result = result.concat("( " + getKey(items[i]) + " , " + items[i] + " ) ");
          // A completer
      }
      return result;
   }

   public void makeEmpty () {
      // A completer
      if (this.Size() != 0)
         items = null;
   }
}
