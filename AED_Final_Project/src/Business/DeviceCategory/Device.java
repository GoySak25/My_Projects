/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeviceCategory;

import Business.Enterprise.Enterprise;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author divinity
 */
public class Device {

    private String deviceId;
    private String deviceName;
    private Enterprise enterprise;

    public Device( String name) {

        this.deviceId = deviceIdGenerator();
       
        this.deviceName = name;
    }

    private String deviceIdGenerator() {

        int rand_int1 = ThreadLocalRandom.current().nextInt();
        String deviceRefId = "DEVICE_" + rand_int1;
        return deviceRefId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    
     @Override
        public String toString(){
        return getDeviceName();
        }
}
