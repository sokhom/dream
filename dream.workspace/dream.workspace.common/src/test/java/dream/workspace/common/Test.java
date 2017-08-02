package dream.workspace.common;

import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.customer.CustomerService;

public class Test {
	public static void main(String[] args) {
		ServiceProvider.get(CustomerService.ID);
	}

}
