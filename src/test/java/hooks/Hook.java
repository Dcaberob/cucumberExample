package hooks;

import io.cucumber.java.Before;

public class Hook {

    @Before(value = "@createUser")
    public void createUSer(){
        System.out.println("this hook is well");
    }
}
