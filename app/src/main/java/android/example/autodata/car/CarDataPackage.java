package android.example.autodata.car;

public class CarDataPackage {
    private String paramName;
    private String numberOfParam;
    private int packageImg;


    public CarDataPackage(String paramName, String numberOfParam, int packageImg) {
        this.paramName = paramName;
        this.numberOfParam = numberOfParam;
        this.packageImg = packageImg;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getNumberOfParam() {
        return numberOfParam;
    }

    public void setNumberOfParam(String numberOfParam) {
        this.numberOfParam = numberOfParam;
    }

    public int getPackageImg() {
        return packageImg;
    }

    public void setPackageImg(int packageImg) {
        this.packageImg = packageImg;
    }
}
