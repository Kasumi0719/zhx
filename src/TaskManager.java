import java.util.*;

class TaskManager {
    //taskId不会重复，用来作为中心实体
    public HashMap<Integer, Integer> tasksUsers = new HashMap<>();//任务-用户
    public HashMap<Integer, Integer> tasksPriority = new HashMap<>();//存储任务-优先级
    public PriorityQueue<Integer> maxPriority = new PriorityQueue<>(Comparator.reverseOrder());//存储优先级
    public HashMap<Integer, PriorityQueue<Integer>> priorityTasks = new HashMap<>();//存储任务优先级-任务列表

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> info : tasks) {
            tasksUsers.put(info.get(1), info.get(0));
            tasksPriority.put(info.get(1), info.get(2));
            maxPriority.add(info.get(2));
            priorityTasks.computeIfAbsent(info.get(2), k -> new PriorityQueue<>(Comparator.reverseOrder())).add(info.get(1));
        }
    }

    public void add(int userId, int taskId, int priority) {
        tasksUsers.put(taskId, userId);
        tasksPriority.put(taskId, priority);
        maxPriority.add(priority);
        priorityTasks.computeIfAbsent(priority, k -> new PriorityQueue<>(Comparator.reverseOrder())).add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        maxPriority.remove(tasksPriority.get(taskId));
        maxPriority.add(newPriority);
        tasksPriority.put(taskId, newPriority);//priorityTasks不管，使用懒删除策略
        priorityTasks.computeIfAbsent(newPriority, k -> new PriorityQueue<>(Comparator.reverseOrder())).add(taskId);
    }

    public void rmv(int taskId) {
        tasksUsers.remove(taskId);
        tasksPriority.remove(taskId);//maxPriority和priorityTasks不管，使用懒删除策略
    }

    public int execTop() {
        if (maxPriority.size() == 0) return -1;
        while (true) {
            Integer topPriority = maxPriority.peek();
            while (priorityTasks.get(topPriority).size() > 0) {
                if (!tasksUsers.containsKey(priorityTasks.get(topPriority).peek())) {//检查taskID是否存在
                    priorityTasks.get(topPriority).poll();
                } else if (!Objects.equals(tasksPriority.get(priorityTasks.get(topPriority).peek()), topPriority)) {//优先级是否匹配
                    priorityTasks.get(topPriority).poll();
                } else {//当前检查taskID存在且优先级匹配
                    Integer taskID = priorityTasks.get(topPriority).poll();
                    Integer userID = tasksUsers.get(taskID);
                    rmv(taskID);
                    return userID;
                }
            }
            while (Objects.equals(maxPriority.peek(), topPriority)) {
                maxPriority.poll();
                if (maxPriority.size() == 0) return -1;
            }
        }
    }
}