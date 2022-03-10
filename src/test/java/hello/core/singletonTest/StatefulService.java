package hello.core.singletonTest;

public class StatefulService {
    //아래 주석 부분과 같이 구현하면 상태 유지가 됨 조심!
/*    private int price; //상태를 유지하는 필드
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!
    }
        public int getPrice() {
        return price;
    }

    */
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }




}
