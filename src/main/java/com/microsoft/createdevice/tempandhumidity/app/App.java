package com.microsoft.createdevice.tempandhumidity.app;

import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.RegistryManager;

/**
 * Create Device App
 * @author ranga
 *
 */
public class App 
{
	private static final String connectionString = "{yourhubconnectionstring}";
	
	private static final String deviceId = "mySecondDevice";
    
	public static void main( String[] args )
    {
		RegistryManager registryManager;
		try {
			registryManager = RegistryManager.createFromConnectionString(connectionString);
			 Device device = Device.createFromId(deviceId, null, null);
			 try {
			   device = registryManager.addDevice(device);
			 } catch (IotHubException iote) {
			   try {
			     device = registryManager.getDevice(deviceId);
			   } catch (IotHubException iotf) {
			     iotf.printStackTrace();
			   }
			 }
			 System.out.println("Device ID: " + device.getDeviceId());
			 System.out.println("Device key: " + device.getPrimaryKey());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
