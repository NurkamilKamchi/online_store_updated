public class MyGenerateId {
    private static int counter=1;
    public static long generateId(){
        return counter++;
    }
}
