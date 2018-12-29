/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.MaterialDto;
import dataclasses.ReportContentDto;
import dataclasses.UploadHelperDto;
import java.util.List;

public interface MaterialService {
    ReportContentDto getMaterialDetails( List<MaterialDto> materialDtos );
    String saveMaterial(MaterialDto materialDto);
    List<MaterialDto> getMaterials();
    boolean uploadExcel(List<UploadHelperDto> helperDtos);
}
