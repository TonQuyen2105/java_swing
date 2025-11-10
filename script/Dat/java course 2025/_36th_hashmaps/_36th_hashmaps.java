import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class _36th_hashmaps {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap();
        map.put("name", new String[]{"An", "Binh", "Cao"});
        map.put("ages", new int[]{19, 20, 21});
        map.put("age", 19);
        System.out.println("--- ------- ---");
        // System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println("--- ------- ---");
        // System.out.println(map);
        System.out.println(Arrays.toString((String[]) map.get("name")));
        System.out.println("--- ------- ---");
        System.out.println(Arrays.toString((int[]) map.get("ages")));
        System.out.println("--- ------- ---");
        System.out.println(((int[]) map.get("ages"))[0]);
        System.out.println("--- ------- ---");
        System.out.println(map.containsKey("age"));
        System.out.println("--- ------- ---");
        System.out.println(map.containsValue(19));
        System.out.println("--- ------- ---");
        System.out.println(map.containsValue(new int[]{19, 20, 21}));
        System.out.println("--- ------- ---");
        System.out.println(map.size());

        System.out.println("--- Iterate ---");

        for (String key : map.keySet()) {
            if (key.equals("ages")) {
                
                for (int age : (int[]) map.get(key)) {
                    System.out.println(key + " -> " + age);
                    // System.out.println(age);
                }
                // System.out.println(Arrays.toString((int[]) map.get(key)));
                continue;
            }
            else if (key.equals("name")) {
                for (String name : (String[]) map.get(key)) {
                    System.out.println(key + " -> " + name);
                }
                // System.out.println(Arrays.toString((String[]) map.get(key)));
                continue;
            }
            else if (key.equals("age")) {
                System.out.println(key + " -> " + map.get(key));
                continue;
            }
            System.out.println(key + " -> " + map.get(key));
        }

    }
}
