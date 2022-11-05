package pl.com.bard.petclinic.model;

import java.util.Set;

/**/
public class Owner extends Person {
    private Set<Pet> pets;



    public Set<Pet> getPet() {
        return pets;
    }

    public void setPet(Set<Pet> pets) {
        this.pets = pets;
    }
}
