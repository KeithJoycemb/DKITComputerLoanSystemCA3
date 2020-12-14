package com.dkit.GD2.KeithJoyce;

public class RaspberryPi extends ComputerInformation
{
    private String raspBerryPiSDCard;
    private int raspBerryPiGPIOPins;

    public RaspberryPi(String manufacturer, String processor, String ramSize, String weight, String assetTag, String purchaseDate, String raspBerryPiSDCard, int raspBerryPiGPIOPins)
    {
        super(manufacturer, processor, ramSize,"No Onboard Disk Drive",  weight, assetTag, purchaseDate);
        this.raspBerryPiGPIOPins = raspBerryPiGPIOPins;
        this.raspBerryPiSDCard = raspBerryPiSDCard;

    }

    public String getRaspBerryPiSDCard()
    {
        return raspBerryPiSDCard;
    }

    public int getRaspBerryPiGPIOPins()
    {
        return raspBerryPiGPIOPins;
    }

    @Override
    public String toString() {
        return "RaspberryPi{" +
                "manufacturer='" + super.getManufacturer()+ '\'' +
                ", processor='" + super.getProcessor() + '\'' +
                ", ramSize='" + super.getRamSize() + '\'' +
                ", diskSize='" + super.getDiskSize() + '\'' +
                ", weight='" + super.getWeight() + '\'' +
                ", assetTag='" + super.getAssetTag() + '\'' +
                ", purchaseDate='" + super.getPurchaseDate() + '\''+
                "raspBerryPiSDCard='" + raspBerryPiSDCard + '\'' +
                ", raspBerryPiGPIOPins=" + raspBerryPiGPIOPins +
                '}';
    }
}
