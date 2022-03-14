package stepdefinitions.dbsteps;

public class Main {
    public static void main(String[] args) {
        String line = "235-34-444, Mustafa, Gecer";
        String  [] array = line.split(",");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(line.split(",")[0]);

    }

    // split() explanation
    public static String [] split(String str, String value){
        String [] data = value.split(value);

        return data;
// ozen
    }
}
