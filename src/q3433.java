import java.util.*;

public class q3433 {
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((o1, o2) -> {
            int time1 = Integer.parseInt(o1.get(1));
            int time2 = Integer.parseInt(o2.get(1));
            if (time1 != time2) {
                return time1 - time2; // 时间戳升序
            }
            // 仅这一行核心逻辑，覆盖所有同时间戳场景
            return o1.get(0).equals("MESSAGE") ? 1 : (o2.get(0).equals("MESSAGE") ? -1 : 0);
        });
        int[] res = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];
        int allCount = 0;
        for(List<String> event: events){
            if(event.get(0).equals("MESSAGE")) {
                if(event.get(2).equals("ALL")){
                    allCount++;
                } else if (event.get(2).equals("HERE")) {
                    for(int i = 0; i < offlineTime.length; i++){
                        int timeStamp = Integer.parseInt(event.get(1));
                        if(timeStamp >= offlineTime[i]) res[i] += 1;
                    }
                } else {
                    int[] mentionUsers = convertMentionToIndex(event.get(2));
                    for(int mention: mentionUsers){
                        res[mention]++;
                    }
                }
            } else {
                int offlineLast = Integer.parseInt(event.get(1)) + 60;
                offlineTime[Integer.parseInt(event.get(2))] = offlineLast;
            }
        }
        for(int i = 0; i < numberOfUsers; i++){
            res[i] += allCount;
        }
        return res;
    }

    public static int[] convertMentionToIndex(String mentions) {
        String[] split = mentions.split(" ");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.parseInt(split[i].substring(2));
        }
        return res;
    }

    public static void main(String[] args) {
        int numberOfUsers = 3;
        List<List<String>> events = new ArrayList<>();

        // 添加第一个事件：["MESSAGE","2","HERE"]
        List<String> event1 = new ArrayList<>();
        event1.add("MESSAGE");
        event1.add("2");
        event1.add("HERE");
        events.add(event1);

        // 添加第二个事件：["OFFLINE","2","1"]
        List<String> event2 = new ArrayList<>();
        event2.add("OFFLINE");
        event2.add("2");
        event2.add("1");
        events.add(event2);

        // 添加第三个事件：["OFFLINE","1","0"]
        List<String> event3 = new ArrayList<>();
        event3.add("OFFLINE");
        event3.add("1");
        event3.add("0");
        events.add(event3);

        // 添加第四个事件：["MESSAGE","61","HERE"]
        List<String> event4 = new ArrayList<>();
        event4.add("MESSAGE");
        event4.add("61");
        event4.add("HERE");
        events.add(event4);
        System.out.println(Arrays.toString(q3433.countMentions(numberOfUsers, events)));
    }
}
