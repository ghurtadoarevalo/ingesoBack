package mingeso.mingeso;

import com.github.javafaker.Faker;

public class FakerSingleton {

    private static Faker faker;

    public static Faker getFaker(){
        if(faker == null) {
            return new Faker();
        }
        else {
            return faker;
        }
    }

}
