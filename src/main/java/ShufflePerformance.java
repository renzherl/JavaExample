import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by mi on 6/22/2017.
 */
public class ShufflePerformance {
    private static final int CHILDSUBJECTNUMBERTHRESHOLD = 10;
    private static final int CHILDSUBJECTNUM = 19;
    private static final int LENGTH = 20;
    private static final int LOOP = 1000;

    public static void main(String[] args) {

        System.out.println("Hello, World");
        String[] subSubjectIdArray = new String[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            subSubjectIdArray[i] = i + "0";
        }
        long startTime = System.nanoTime();
        for (int j = 0; j < LOOP; j++) {
            partition(subSubjectIdArray);
        }
        long endTime = System.nanoTime();
        long average = (endTime - startTime) / LOOP;
        System.out.println("Normal partition time: " + average);

        startTime = System.nanoTime();
        for (int j = 0; j < LOOP; j++) {
            partition_shuffle(subSubjectIdArray);
        }
        endTime = System.nanoTime();
        average = (endTime - startTime) / LOOP;
        System.out.println("Shuffle partition time: " + average);
    }

    public static List<Integer> partition(String[] subSubjectIdArray) {
        List<Integer> partSubIdList = new ArrayList<Integer>();
        if (subSubjectIdArray.length > CHILDSUBJECTNUMBERTHRESHOLD) {
            while (partSubIdList.size() != CHILDSUBJECTNUM) {
                int randomNumber = new Random().nextInt(subSubjectIdArray.length);
                int tempNumber = Integer.valueOf(subSubjectIdArray[randomNumber]);
                if (!partSubIdList.contains(tempNumber)) {
                    partSubIdList.add(tempNumber);
                }
            }
        } else {
            for (int i = 0; i < subSubjectIdArray.length; i++) {
                partSubIdList.add(Integer.valueOf(subSubjectIdArray[i]));
            }
        }
        return partSubIdList;
    }

    public static List<Integer> partition_shuffle(String[] subSubjectIdArray) {
        List<Integer> partSubIdList = new ArrayList<Integer>();
        for (int i = 0; i < subSubjectIdArray.length; i++) {
            partSubIdList.add(Integer.valueOf(subSubjectIdArray[i]));
        }
        if (subSubjectIdArray.length > CHILDSUBJECTNUMBERTHRESHOLD) {
            Collections.shuffle(partSubIdList);
            return partSubIdList.subList(0, CHILDSUBJECTNUM);
        }
        return partSubIdList;
    }
}
