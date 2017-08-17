/**
 * @author haysokhom
 */

package com.belms.dream.service.part;

import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.service.part.IPartService;
import com.belms.dream.repository.part.PartRepo;
import com.blems.dream.api.model.part.Part;

public class PartServiceImpl implements IPartService {

	private PartRepo partRepo = new PartRepo();
	public Part add(Part t) {
		
		return partRepo.add(t);
	}

	public void remove(Part t) {
		partRepo.remove(t);
		
	}

	public void edit(Part t) {
		partRepo.edit(t);
		
	}

	public Part getById(int id) {
		return partRepo.getById(id);
	}

	public List<Part> getAll() {
		return partRepo.getAll();
	}

	public PartInitDataWrapperDto getInitData() {
		return partRepo.getInitData();
	}

	

}
