package com.dkit.GD2.KeithJoyce;

public class Laptop extends Computer
{
    private String laptopScreenSize;
    private String laptopBatteryLife;

    public Laptop(String manufacturer, String processor, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate,
                  String laptopScreenSize, String laptopBatteryLife)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.laptopBatteryLife = laptopBatteryLife;
        this.laptopScreenSize = laptopScreenSize;

    }

    public String getLaptopScreenSize()
    {
        return laptopScreenSize;
    }

    public String getLaptopBatteryLife()
    {
        return laptopBatteryLife;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "manufacturer='" + super.getManufacturer()+ '\'' +
                ", processor='" + super.getProcessor() + '\'' +
                ", ramSize='" + super.getRamSize() + '\'' +
                ", diskSize='" + super.getDiskSize() + '\'' +
                ", weight='" + super.getWeight() + '\'' +
                ", assetTag='" + super.getAssetTag() + '\'' +
                ", purchaseDate='" + super.getPurchaseDate() + '\''+
                "laptopScreenSize='" + laptopScreenSize + '\'' +
                ", laptopBatteryLife='" + laptopBatteryLife + '\'' +
                '}';
    }
}
