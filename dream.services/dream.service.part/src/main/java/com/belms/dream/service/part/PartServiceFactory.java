package com.belms.dream.service.part;

import com.belms.dream.api.service.Service;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.part.Part;

public class PartServiceFactory implements ServiceFactory {

	Service<Part> service;
	
	public String getId() {
		return "PART_SERVICE";
	}

	public Service<Part> getService() {
		if(service == null){
			service = new PartServiceImpl();
			System.out.println("create part service");	
		}else{
			System.out.println("load part cache service");
		}		
		return service;
	}

}
