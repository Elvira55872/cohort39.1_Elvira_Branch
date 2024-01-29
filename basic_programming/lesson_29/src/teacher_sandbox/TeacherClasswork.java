package teacher_sandbox;

import practice.House;

import java.util.Arrays;
import java.util.HashSet;

public class TeacherClasswork {
    public static void main(String[] args) {
        Integer a = 20;
        Integer b = 20;

        System.out.println("a.hashCode() = " + a.hashCode());
        System.out.println("b.hashCode() = " + b.hashCode());
        System.out.println("a.equals(b) = " + a.equals(b));

        String str1 = "hello";
        String str2 = new String("hello");

        System.out.println("str1.hashCode() = " + str1.hashCode());
        System.out.println("str2.hashCode() = " + str2.hashCode());
        str1.equals(str2);

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        System.out.println("nums1 == nums2 = " + (nums1 == nums2));
        System.out.println("nums1.equals(nums2) = " + nums1.equals(nums2));
        System.out.println("Arrays.equals(nums1, nums2) = " + Arrays.equals(nums1, nums2));
        System.out.println("nums1.hashCode() = " + nums1.hashCode());
        System.out.println("nums2.hashCode() = " + nums2.hashCode());
        nums2[1] = 111;
        System.out.println("nums2.hashCode() = " + nums2.hashCode());


    }
}
