package pl.com.bard.petclinic.formatters;


import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import pl.com.bard.petclinic.model.PetType;
import pl.com.bard.petclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();

        Optional<PetType> petType = petTypes.stream().filter(e -> e.getName().equals(text)).findFirst();
        if (petType.isPresent()) {
            return petType.get();
        }
        throw new ParseException("type not found: " + text, 0);
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
