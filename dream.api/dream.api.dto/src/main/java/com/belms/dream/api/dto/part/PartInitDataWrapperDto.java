package com.belms.dream.api.dto.part;

import java.util.List;

import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.part.PartType;
import com.blems.dream.api.model.product.ProductTree;
import com.blems.dream.api.model.uom.Uom;

public class PartInitDataWrapperDto {
	
	private List<ChartAccount> coaList;
	private List<Customer> defaultCustomers;
	private List<PartType> partTypes;
	private List<Location> location;
	private List<Uom> uom;
	private List<ProductTree> productTree;
	

}
