package de.arkem.clean.arc.demo.app.parts.catalog.usecase.out;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.part.SparePart;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.part.SparePartNumber;

import java.util.List;

public interface LoadSpareParts {
    List<SparePart> load(List<SparePartNumber> sparePartNumbers);
}
