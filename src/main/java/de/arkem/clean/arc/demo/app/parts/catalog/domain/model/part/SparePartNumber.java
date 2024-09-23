package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.part;

import de.arkem.clean.arc.demo.app.shared.types.StringValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class SparePartNumber extends StringValueObject {
    private static Consumer<Validation<String>> constraints = Constraints.isPattern("^[0-9]{2}-[A-Z]{3}[0-9]{8}$");

    public SparePartNumber(String value) {
        super(value);
    }
}
