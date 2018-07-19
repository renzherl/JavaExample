package enumExample;

/**
 * Created by mi on 2018/2/5.
 */
public class enumExampleMain {

    public static void main(String[] args){
        for(IDC idc : IDC.values()){
            if(idc.getGroup().equals(IDCGroup.OVERSEA)){
                System.out.println("IDC : " + idc);
            }
        }


    }
}
