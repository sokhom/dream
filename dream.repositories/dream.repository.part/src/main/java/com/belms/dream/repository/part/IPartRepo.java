package com.belms.dream.repository.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.blems.dream.api.model.part.Part;

import dream.repository.common.Repo;

public interface IPartRepo extends Repo<Part> {
	PartInitDataWrapperDto getInitData();

}
