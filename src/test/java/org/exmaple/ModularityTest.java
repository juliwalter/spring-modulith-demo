package org.exmaple;

import org.example.App;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

/**
 * @author julianwalter
 */
public class ModularityTest {
    @Test
    public void applicationModules() {
        ApplicationModules modules = ApplicationModules.of(App.class);
        modules.forEach(System.out::println);
        modules.verify();
    }

    @Test
    void createDocumentation(){
        ApplicationModules modules = ApplicationModules.of(App.class);
        new Documenter(modules).writeDocumentation();
    }
}
