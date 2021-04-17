package com.qrcode.web.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;



public class QRCodeArgs {
    @JsonProperty(value = "Data")
    private String Data;

    @JsonProperty(value = "RSLevel")
    private Integer RSLevel;

    @JsonProperty(value = "QRVersion")
    private Integer QRVersion;

    @JsonProperty(value = "FinderColor")
    private String FinderColor;

    @JsonProperty(value = "DataColor")
    private String DataColor;

    @JsonProperty(value = "pixelSize")
    private Integer pixelSize;

    @JsonProperty(value = "borderSize")
    private Integer borderSize;


    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public Integer getRSLevel() {
        return RSLevel;
    }

    public void setRSLevel(Integer RSLevel) {
        this.RSLevel = RSLevel;
    }

    public Integer getQRVersion() {
        return QRVersion;
    }

    public void setQRVersion(Integer QRVersion) {
        this.QRVersion = QRVersion;
    }

    public String getFinderColor() {
        return FinderColor;
    }

    public void setFinderColor(String finderColor) {
        FinderColor = finderColor;
    }

    public String getDataColor() {
        return DataColor;
    }

    public void setDataColor(String dataColor) {
        DataColor = dataColor;
    }

    public Integer getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(Integer pixelSize) {
        this.pixelSize = pixelSize;
    }

    public Integer getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(Integer borderSize) {
        this.borderSize = borderSize;
    }

    public static Integer convertColor(String color){
        if (color == null || color.equals(""))
            return 0;
        Long tmp = Long.parseLong(color.substring(1), 16);
        return tmp.intValue();
    }

    @Override
    public String toString() {
        return "QRCodeArgs{" +
                "Data='" + Data + '\'' +
                ", RSLevel=" + RSLevel +
                ", QRVersion=" + QRVersion +
                ", FinderColor='" + FinderColor + '\'' +
                ", DataColor='" + DataColor + '\'' +
                ", pixelSize=" + pixelSize +
                ", borderSize=" + borderSize +
                '}';
    }
}
