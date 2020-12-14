package com.dkit.GD2.KeithJoyce;

public class ComputerInformation
{
    private String manufacturer;
    private String processor;
    private String ramSize;
    private String diskSize;
    private String weight;
    private String assetTag;
    private String purchaseDate;

    public ComputerInformation(String manufacturer, String processor, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate)
    {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = purchaseDate;
    }

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

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public void setProcessor(String processor)
    {
        this.processor = processor;
    }

    public void setRamSize(String ramSize)
    {
        this.ramSize = ramSize;
    }

    public void setDiskSize(String diskSize)
    {
        this.diskSize = diskSize;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public void setAssetTag(String assetTag)
    {
        this.assetTag = assetTag;
    }

    public void setPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
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
