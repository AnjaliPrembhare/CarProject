package org.CarGarage.Service;

import java.util.List;

import org.CarGarage.Model.PartModel;

public interface PartService {
public boolean isAddNewParts(PartModel model);
public List<PartModel> getAllParts();
}
