package de.arkem.clean.arc.demo.app.parts.catalog.usecase.out;

import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.vehicle.EquipmentCode;

import java.util.List;

public record FetchPartCatalogViewQuery(CategoryNumber mainCategoryNumber, CategoryNumber subCategoryNumber, List<EquipmentCode> equipmentCodes) {
}