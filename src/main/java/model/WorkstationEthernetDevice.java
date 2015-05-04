package model;

import java.beans.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ethernet")
public class WorkstationEthernetDevice {
    /**
     * Конструирует выключенное eth-устройство. Бит включения up у экземпляра
     * VMWorkstationEthernetDevice может быть выставлен методами
     * getEthernetDevices(), connectEthToVM(), disconnectEthFromVM() класса
     * VMWorkstation
     * 
     * @param ethNumber
     *            номер ethernet-девайса, например 0 - соответствует устройству
     *            ethernet0 в .vmx
     * @param vnetName
     *            например "VMnet3"
     * @param connectionType
     *            - "custom"
     * @param virtualDev
     *            - виртуальное устройство, "e1000" для Win 7
     */
    public WorkstationEthernetDevice(int ethNumber, String vnetName,
            String connectionType, String virtualDev) {
        this.ethNumber = ethNumber;
        this.vnetName = vnetName;
        this.connectionType = connectionType;
        this.virtualDev = virtualDev;
    }
    
    private transient boolean up;
    private int ethNumber;
    private String vnetName;
    private String connectionType;
    private String virtualDev;

    public boolean getUp() {
        return up;
    }

    /**
     * Сознательно сделан package-private, т. к. бит up может выставляться
     * только из VMWorkstation.getEthernetDevices()
     * 
     * @param up
     *            true когда устройство включено
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    public int getEthNumber() {
        return ethNumber;
    }

    public String getVnetName() {
        return vnetName;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public String getVirtualDev() {
        return virtualDev;
    }

    @Override
    public String toString() {
        return "ethernet" + ethNumber + " [up=" + up + ", vnetNumber="
                + vnetName + ", connectionType=" + connectionType
                + ", virtualDev=" + virtualDev + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((connectionType == null) ? 0 : connectionType.hashCode());
        result = prime * result + ethNumber;
        result = prime * result + (up ? 1231 : 1237);
        result = prime * result
                + ((virtualDev == null) ? 0 : virtualDev.hashCode());
        result = prime * result
                + ((vnetName == null) ? 0 : vnetName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WorkstationEthernetDevice other = (WorkstationEthernetDevice) obj;
        if (connectionType == null) {
            if (other.connectionType != null)
                return false;
        } else if (!connectionType.equals(other.connectionType))
            return false;
        if (ethNumber != other.ethNumber)
            return false;
        if (up != other.up)
            return false;
        if (virtualDev == null) {
            if (other.virtualDev != null)
                return false;
        } else if (!virtualDev.equals(other.virtualDev))
            return false;
        if (vnetName == null) {
            if (other.vnetName != null)
                return false;
        } else if (!vnetName.equals(other.vnetName))
            return false;
        return true;
    }
}
