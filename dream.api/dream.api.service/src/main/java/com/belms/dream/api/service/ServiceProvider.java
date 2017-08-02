/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import com.belms.dream.api.service.ServiceFactory;

public class ServiceProvider {

	private static ServiceProvider serviceProvider;

	public Map<String, ServiceFactory> serviceFactories = new HashMap<String, ServiceFactory>();

	private ServiceProvider() {
		ServiceLoader<ServiceFactory> loader = ServiceLoader.load(ServiceFactory.class);
		try {
			Iterator<ServiceFactory> serviceFactorys = loader.iterator();
			while (serviceFactorys.hasNext()) {
				ServiceFactory serviceFactory = (ServiceFactory) serviceFactorys.next();
				serviceFactories.put(serviceFactory.getId(), serviceFactory);
			}
		} catch (ServiceConfigurationError serviceError) {
			serviceError.printStackTrace();

		}
	}

	public static ServiceFactory get(String serviceId) {
		if (serviceProvider == null) {
			serviceProvider = new ServiceProvider();
		}
		
		if(!serviceProvider.serviceFactories.containsKey(serviceId)){
			throw new RuntimeException(String.format("%s not found ", serviceId));
		}
		
		return serviceProvider.serviceFactories.get(serviceId);
	}

}
