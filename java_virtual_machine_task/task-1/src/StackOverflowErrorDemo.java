public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        new StackOverflowErrorDemo().doStackOverflow();
    }

    private void doStackOverflow(){
        doStackOverflow();
    }
}
