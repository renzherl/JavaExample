package JsonToMap;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by mi on 2018/3/14.
 */
public class JsonToMap {
    private static Map<Integer, String> parseToMap(String basicProfile) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        Type type = new TypeToken<Map<Integer, String>>(){}.getType();
        try {
            Gson gson = new Gson();
            return gson.fromJson(basicProfile,type);
        } catch (Exception e) {
            return map;
        }

    }

    private static Map<Integer, Set<Byte>> parseToMap2(String appCategoryUsage) {
        Map<Integer, Set<Byte>> map = new HashMap<Integer, Set<Byte>>();
        Type type = new TypeToken<Map<Integer, Set<Byte>>>(){}.getType();
        try {
            Gson gson = new Gson();
            return (Map<Integer, Set<Byte>>) gson.fromJson(appCategoryUsage, type);
        } catch (Exception e) {
            return map;
        }

    }

    public static void main(String[] args){
        String basicProfile = "{\"1\":31,\"3\":\"1\",\"4\":\"5\",\"5\":102,\"6\":102,\"7\":31,\"11\":\"88:2;3:0;4:1;8:0;9:0;\",\"12\":\"3:2;4:3;6:0;7:0;8:2;9:1;\"}";
        Map<Integer, String> map = parseToMap(basicProfile);
        Integer key = 11;
        String value;
        if(map.containsKey(key)){
            value = map.get(key);
            System.out.println(value);
        }

        String appCategoryUsage ="{\"100\":[58,59,65,70,84]}";
        Map<Integer, Set<Byte>> map2 = parseToMap2(appCategoryUsage);
        System.out.println(map2.toString());
        Set<Byte> setValue = map2.get(100);
        for(Byte b: setValue){
            System.out.println(b);
        }
    }
}
