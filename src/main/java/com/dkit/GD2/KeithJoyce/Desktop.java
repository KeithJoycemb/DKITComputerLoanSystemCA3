package com.dkit.GD2.KeithJoyce;

public class Desktop extends Computer
{
    private int monitor;

    public Desktop(String manufacturer, String processor, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate, int monitor)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag,purchaseDate);
        this.monitor = monitor;

    }

    public int getMonitor()
    {
        return monitor;
    }

    @Override
    public String toString() {
        return "Desktop{" +
                "manufacturer='" + super.getManufacturer()+ '\'' +
                ", processor='" + super.getProcessor() + '\'' +
                ", ramSize='" + super.getRamSize() + '\'' +
                ", diskSize='" + super.getDiskSize() + '\'' +
                ", weight='" + super.getWeight() + '\'' +
                ", assetTag='" + super.getAssetTag() + '\'' +
                ", purchaseDate='" + super.getPurchaseDate() + '\''+
                "monitor=" + monitor +
                '}';
    }
}
