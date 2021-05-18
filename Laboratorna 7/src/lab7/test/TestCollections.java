package lab7.test;

import lab7.model.*;

import java.util.*;

public class TestCollections {
    public static void main() {
        System.out.println("\nCollTreeSet");
        CollTreeSet();
        System.out.println("\nRemoveRetainAll");
        RemoveRetainAll();
        System.out.println("\ncontainsAll");
        containAll();
        System.out.println("\nSort");
        Sort();
        System.out.println("\nCollections");
        Collections();
        System.out.println("\nList");
        List();
        Set();

    }
    public static void CollTreeSet(){
        Random rnd=new Random();
        Collection<Integer> c1=new Vector<>();
        for (int i = 0; i < 15; i++) {
            c1.add(rnd.nextInt(10));
        }
        System.out.println("Collection vector");
        for (Integer x:c1){
            System.out.printf("%d ",x);
        }
        Collection<Integer> c2=new TreeSet<>();
        c2.addAll(c1);
        System.out.println("\nCollection TreeSet");
        c2.forEach((x)->System.out.printf("%d ",x));
    }
    public static void RemoveRetainAll(){
        Random rnd=new Random();
        Collection<Integer> c1=new ArrayList<>();
        Collection<Integer> c2=new LinkedHashSet<>();
        Collection<Integer> c3=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            c1.add(rnd.nextInt(10));
            c2.add(rnd.nextInt(10));
        }
        c3.addAll(c1); c3.removeAll(c2);
        System.out.println(c1+" removeAll "+c2+" = "+c3);

        c3.clear(); c3.addAll(c2);c3.removeAll(c1);
        System.out.println(c2+" removeAll "+c1+" = "+c3);

        c3.clear();c3.addAll(c1);c3.retainAll(c2);
        System.out.println(c1+" retainAll "+c2+" = "+c3);

        c3.clear();c3.addAll(c2);c3.retainAll(c1);
        System.out.println(c2+" retainAll "+c1+" = "+c3);
    }
    public static void containAll(){
        Random rnd= new Random();
        Collection<Integer> c1=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c1.add(rnd.nextInt(10));
        }
        Collection<Integer> c2=new LinkedHashSet<>();
        c2.addAll(c1);
        boolean b1=c1.containsAll(c1);
        System.out.println(c1+" containsAll "+c2+" = "+b1);

        Collection<Integer> c3=new TreeSet<>();
        c3.addAll(c1);
        boolean b2=c1.containsAll(c3);
        System.out.println(c1+" containsAll "+c3+" = "+b2);
    }
    public static void Sort(){
        Random rnd=new Random();
        List<Integer> c1=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c1.add(rnd.nextInt(10));
        }
        System.out.println(c1);
       /* c1.sort((a,b)->a-b);*/
        c1.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        System.out.println(c1);
    }
    public static void Collections(){
        Collection<Integer> coll=new ArrayList<>();
        //methods for Collections
        Collections.addAll(coll,1,3,5,3,4,2,14);
        Collections.addAll(coll,new Integer[]{3,7,12});
        System.out.println(coll);
        System.out.println(Collections.frequency(coll,3));
        System.out.println(Collections.max(coll));
        System.out.println(Collections.min(coll));
    }
    public static void List(){
        Collection<Integer> coll=new ArrayList<>();
        //methods for Collections
        Collections.addAll(coll,1,3,5,3,4,2,14);
        Collections.addAll(coll,new Integer[]{3,7,12});
        List<Integer> list=new ArrayList<>(coll);
        System.out.println(list);
        System.out.println();
        System.out.println("Після заміни елементів");
        Collections.swap(list,2,6);
        System.out.println(list);
        System.out.println("Після сортування");
        Collections.sort(list);
        System.out.println(list);
        System.out.println("Бінарний пошук");
        System.out.println(Collections.binarySearch(list,3));
        System.out.println("Після сортування (реверс)");
        Collections.sort(list,(a,b)->b-a);
        System.out.println(list);
        System.out.println("Бінарний пошук після реверсивного сортування");
        System.out.println(Collections.binarySearch(list,3,(a,b)->b-a));
        System.out.println("реверсивне сортування 2");
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("Після перестановки останніх двох елементів в початок");
        Collections.rotate(list,2);
        System.out.println(list);
        System.out.println("Після тасування елементів");
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("Після заміни чисел 3 на 8");
        Collections.replaceAll(list,3,8);
        System.out.println(list);
        System.out.println("Після заміни всіх значень на 0");
        Collections.fill(list,0);
        System.out.println(list);
    }
    public static void Set(){
        System.out.print("\n\n");
        Set<Wood> set = new HashSet<>();
        set.add(new Wood(1, "Lypa", 1f));
        set.add(new Wood(1, "Lypa", 1f));
        set.add(new Wood(1, "Lypa", 1f));

        Wood a = new Wood(1, "Lypa", 1f);
        Wood b = new Wood(1, "Lypa", 1f);
        System.out.println(b.equals(a));
        System.out.println(a.hashCode() + " " + b.hashCode());
        set.forEach(System.out::println);
    }
}

