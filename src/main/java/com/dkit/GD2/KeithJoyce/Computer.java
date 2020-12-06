package com.dkit.GD2.KeithJoyce;

public class Computer
{
    private String manufacturer;
    private String processor;
    private String ramSize;
    private String diskSize;
    private String weight;
    private String assetTag;
    private String purchaseDate;

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getProcessor()
    {
        return processor;
    }

    public String getRamSize()
    {
        return ramSize;
    }

    public String getDiskSize()
    {
        return diskSize;
    }

    public String getWeight()
    {
        return weight;
    }

    public String getAssetTag()
    {
        return assetTag;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    @Override
    public String toString()
    {
        return "Computer{" +
                "manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", diskSize='" + diskSize + '\'' +
                ", weight='" + weight + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }
}
