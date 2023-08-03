package hellojpa;

public class ValueMain {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println("a == b     : " + (a==b));

        Address address1 = new Address("city", "street", "zipcode");
        Address address2 = new Address("city", "street", "zipcode");
        // == 인스턴스 '참조값' 비교 , equals 인스턴스 '값' 비교
        System.out.println("address1 == address2    : " + (address1 == address2));
        //equals 오버라이드 해야 true 나옴
        System.out.println("address1 equals address2    : " + (address1.equals(address2)));
    }
}
