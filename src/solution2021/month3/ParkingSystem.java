package solution2021.month3;

public class ParkingSystem {
    int bigNum;
    int mediumNum;
    int smallNum;

    public ParkingSystem(int big, int medium, int small) {
        this.bigNum=big;
        this.mediumNum=medium;
        this.smallNum=small;

    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if(bigNum>=1){
                    bigNum--;
                    return true;
                }else return false;
            case 2:
                if(mediumNum>=1){
                    mediumNum--;
                    return true;
                }else return false;
            case 3:
                if(smallNum>=1){
                    smallNum--;
                    return true;
                }else return false;
        }
        return false;


    }

}
