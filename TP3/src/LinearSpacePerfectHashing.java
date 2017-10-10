import java.util.ArrayList;
import java.util.Random;

public class LinearSpacePerfectHashing<AnyType>
{
   static int p = 46337;

   QuadraticSpacePerfectHashing<AnyType>[] data;
   int a, b, m;

   LinearSpacePerfectHashing()
   {
      a=b=0; data = null;
   }

   LinearSpacePerfectHashing(ArrayList<AnyType> array)
   {
      AllocateMemory(array);
   }

   public void SetArray(ArrayList<AnyType> array)
   {
      AllocateMemory(array);
   }

   @SuppressWarnings("unchecked")
   private void AllocateMemory(ArrayList<AnyType> array)
   {
      Random generator = new Random( System.nanoTime() );

      m = array.size();
      if(array == null || array.size() == 0)
      {
         // A completer
         return;
      }
      if(array.size() == 1)
      {
         a = b = 0;

         data = new QuadraticSpacePerfectHashing[m];
         int index = ( ( a*array.get(0).hashCode() + b ) % p ) % m;
         data[index].items = (AnyType[]) new Object[(int) Math.pow(m, 2)];
         int index2 = ((a*array.get(0).hashCode() + b) % p) % (int) Math.pow(m, 2);
         data[index].items[index2] = array.get(0);
         return;
      }
      if(array.size() > 1) {
          a = generator.nextInt(p);
          b = generator.nextInt(p);
          data = new QuadraticSpacePerfectHashing[m];
        for(int i = 0; i < data.length -1; i++) {
            data[i] = new QuadraticSpacePerfectHashing();
            data[i].items = (AnyType[]) new Object[(int) Math.pow(m , 2)];
            for(int j = 0; j < array.size() -1; j++) {
                int index = ((a*array.get(j).hashCode() + b) % p) % m;
                data[i].items[index] = array.get(j);
            }
        }
      }
   }

      // A completer


   public int Size()
   {
      if( data == null ) return 0;

      int size = 0;
      for(int i=0; i<data.length; ++i)
      {
         size += (data[i] == null ? 1 : data[i].Size());
      }
      return size;
   }

   public boolean containsKey(int key)
   {
      // A completer
     for(int i = 0; i < data.length -1; i++) {
         if(data[i].items[key] == null)
             return false;
     }
     return true;
   }

   public int getKey (AnyType x) {
      // A completer
       return ( ( a*x.hashCode() + b ) % p ) % m;
   }

   public boolean containsValue (AnyType x) {
      // A completer
       int index = getKey(x);
       for(int i = 0; i < data.length - 1; i++) {
           if(data[i].items[index].equals(x))
               return true;
       }
       return false;
   }

   public void remove (AnyType x) {
      // A completer
       int index = getKey(x);
       for(int i = 0; i < data.length -1; i++) {
           if(data[i].items[index] == x)
               data[i].items[index] = null;
       }
   }

   public String toString () {
      String result = "";

      // A completer
       for(int i = 0; i < data.length - 1; i++) {
           for(int j = 0; j < data[i].items.length -1; j++) {
               if(data[i].items[j] != null)
                   result = result.concat("( " + getKey(data[i].items[j]) + " , " + data[i].items[j] + " )");
           }
       }
           // A completer

      return result;
   }

   public void makeEmpty () {
       // A completer
       for (int i = 0; i < data.length - 1; i++) {
           for (int j = 0; j < data[i].items.length - 1; j++)
               data[i].items[j] = null;
           data[i] = null;
       }
   }

}
