package practice;

/**
 * @Author: jackila
 * @Date: 6:33 PM 2018/8/18
 */
public class FabricAlgShow {

    public static int fabricTotal(int index){

        if(index == 0 || index == 1){
            return 1;
        }else{
            return fabricTotal(index-1) + fabricTotal(index -2);
        }

    }

    public static void main(String[] args) {

        int index = 2;
        System.out.println(fabricTotal(index));
    }
}
