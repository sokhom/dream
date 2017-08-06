package com.belms.dream.api.service.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.service.CrudService;
import com.blems.dream.api.model.part.Part;

public interface IPartService extends CrudService<Part> {
	public static final String ID="PART_SERVICE";
	
	PartInitDataWrapperDto getInitData();
}
