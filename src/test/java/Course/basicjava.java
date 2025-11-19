package Course;

public class basicjava {

    public static void main (String[] args) {

        int[] numbers = {1,2,3,4,5};

        System.out.println(numbers[0]);
        System.out.println(numbers[4]);
        System.out.println("number is " + numbers.length);

        for (int a=0;a<=numbers.length;a++ )
        {
            System.out.print(numbers[a]);
        }


    }
}
