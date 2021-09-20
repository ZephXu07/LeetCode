package 每日一题;

/**
 * Title: 设计停车系统
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-19
 */
public class 设计停车系统 {

}
class ParkingSystem {
    private int[] parkingSpace;
    public ParkingSystem(int big, int medium, int small) {
        parkingSpace = new int[] {0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (parkingSpace[carType] >= 1) {
            parkingSpace[carType]--;
            return true;
        } else {
            return false;
        }
    }
}