import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task11 {
    //        private static final String FILE_NAME = "C:\\Temp\\flud\\task11-dataset.txt";
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119223773.txt";
    private static final int NUM_OF_PROCESSORS = 11;
    private static final List<Action> graph = new ArrayList<>();
    private static final List<Action> tasks = new ArrayList<>();
    private static final List<Action> lastNodes = new ArrayList<>();
    private static final List<Processor> processors = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            List<String> forlastNodes = new ArrayList<>();
            while (reader.ready()) {
                String[] line = reader.readLine().split(",");
                if (line.length < 3) {
                    continue;
                }
                List<Action> dependencies = new ArrayList<>();
                if (!"none".equals(line[2])) {
                    String[] ids = line[2].split(":");
                    for (String id : ids) {
                        dependencies.add(findAction(graph, id));
                        forlastNodes.remove(id);
                    }
                }
                forlastNodes.add(line[0]);
                graph.add(new Action(line[0], Integer.parseInt(line[1]), dependencies));
            }
            for (String lastNode : forlastNodes) {
                lastNodes.add(findAction(graph, lastNode));
            }
            System.out.println("graph: " + graph);
            System.out.println("graph.size: " + graph.size());
            System.out.println("lastNodes: " + lastNodes);
            System.out.println("lastNodes.size = " + lastNodes.size());

            while (!allActionsSorted(graph)) {
                Route maxCriticalPath = findMaxCriticalPath(lastNodes);
                System.out.printf("maxCriticalPath task is: %s, it's criticalPath is %d%n", maxCriticalPath.getAction(), maxCriticalPath.getCriticalPath());
                tasks.add(maxCriticalPath.getAction());
                maxCriticalPath.getAction().setSorted();
            }
            System.out.println("Tasks: " + tasks);
            System.out.println("tasks.size: " + tasks.size());
            System.out.println("Durations sum: " + graph.stream()
                    .mapToInt(Action::getDuration)
                    .sum());

            for (int i = 0; i < NUM_OF_PROCESSORS; i++) {
                processors.add(new Processor(i));
            }

            System.out.println();
            System.out.println("Starting processing...");
            int currentTime = 0;
            while (!allTasksDone(tasks)) {
                Action readyTask = findReadyTask(tasks);
                Processor readyProcessor = findReadyProcessor(processors);
                if (readyTask != null && readyProcessor != null) {
                    startTask(readyTask, readyProcessor, currentTime);
                } else {
                    Action firstEndingTask = findFirstEndingTask(tasks);
                    currentTime = firstEndingTask.getEndTime();
                    endTask(firstEndingTask);
                }
            }
            System.out.printf("Minimum time in minutes to complete all actions with %d workers working in parallel is: %d%n", NUM_OF_PROCESSORS,
                    lastNodes.stream()
                            .max(Comparator.comparingInt(Action::getEndTime))
                            .orElse(null)
                            .getEndTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Action findAction(List<Action> actions, String id) {
        for (Action action : actions) {
            if (action.getId().equals(id)) {
                return action;
            }
        }
        return null;
    }

    private static Route findMaxCriticalPath(List<Action> lastNodes) {
        List<Route> result = new ArrayList<>();
        for (Action lastNode : lastNodes) {
            if (lastNode.isSorted()) {
                continue;
            }
            Queue<Route> routes = new ArrayDeque<>();
            routes.add(new Route(new ArrayList<>(List.of(lastNode)), lastNode.getDuration()));
            while (!routes.isEmpty()) {
                Route route = routes.remove();
                Action current = route.getRoute().get(route.getRoute().size() - 1);
                List<Action> dependencies = current.findNotSortedDependencies();
                if (dependencies.isEmpty()) {
                    result.add(route);
                } else {
                    for (Action dependency : dependencies) {
                        List<Action> action = new ArrayList<>(route.getRoute());
                        action.add(dependency);
                        routes.add(new Route(action, route.getCriticalPath() + dependency.getDuration()));
                    }
                }
            }
        }
        return result.stream()
                .max(Comparator.comparingInt(Route::getCriticalPath))
                .orElse(new Route(new ArrayList<>(), 0));
    }

    private static boolean allActionsSorted(List<Action> actions) {
        for (Action action : actions) {
            if (!action.isSorted()) {
                return false;
            }
        }
        return true;
    }

    private static boolean allTasksDone(List<Action> tasks) {
        for (Action task : tasks) {
            if (!task.isDone()) {
                return false;
            }
        }
        return true;
    }

    private static Action findReadyTask(List<Action> tasks) {
        for (Action task : tasks) {
            if (task.isReady()) {
                return task;
            }
        }
        return null;
    }

    private static Processor findReadyProcessor(List<Processor> processors) {
        for (Processor processor : processors) {
            if (!processor.isBusy()) {
                return processor;
            }
        }
        return null;
    }

    private static Action findFirstEndingTask(List<Action> tasks) {
        return tasks.stream()
                .filter(Action::isProcessing)
                .min(Comparator.comparingInt(Action::getEndTime))
                .orElse(null);
    }

    private static void startTask(Action task, Processor processor, int startTime) {
        processor.setBusy(true);
        task.setProcessor(processor);
        task.setStartTime(startTime);
        task.setEndTime(startTime + task.getDuration());
        task.setProcessing();
        System.out.printf("Task %s started at %d by processor %d, endTime is %d%n", task.getId(), task.getStartTime(), processor.getId(), task.getEndTime());
    }

    private static void endTask(Action task) {
        task.getProcessor().setBusy(false);
        task.setDone();
        System.out.printf("Task %s ended at %d by processor %d%n", task.getId(), task.getEndTime(), task.getProcessor().getId());
    }

    enum State {
        NEW, SORTED, PROCESSING, DONE
    }

    static class Action {
        private String id;
        private int duration;
        private List<Action> dependencies;
        private State state;
        private int startTime;
        private int endTime;
        private Processor processor;

        public Action(String id, int duration, List<Action> dependencies) {
            this.id = id;
            this.duration = duration;
            this.dependencies = dependencies;
            this.state = State.NEW;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public List<Action> getDependencies() {
            return dependencies;
        }

        public void setDependencies(List<Action> dependencies) {
            this.dependencies = dependencies;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public Processor getProcessor() {
            return processor;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public void setProcessor(Processor processor) {
            this.processor = processor;
        }

        public boolean isSorted() {
            return state == State.SORTED;
        }

        public void setSorted() {
            this.state = State.SORTED;
        }

        public boolean isProcessing() {
            return state == State.PROCESSING;
        }

        public void setProcessing() {
            this.state = State.PROCESSING;
        }

        public boolean isDone() {
            return state == State.DONE;
        }

        public void setDone() {
            this.state = State.DONE;
        }

        public List<Action> findNotSortedDependencies() {
            List<Action> actions = new ArrayList<>();
            for (Action dependency : dependencies) {
                if (!dependency.isSorted()) {
                    actions.add(dependency);
                }
            }
            return actions;
        }

        public boolean isReady() {
            if (state != State.SORTED) {
                return false;
            }
            if (dependencies.isEmpty()) {
                return true;
            }
            for (Action dependency : dependencies) {
                if (!dependency.isDone()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return "Action{" +
                    "id='" + id + '\'' +
                    ", duration=" + duration +
                    /*", dependencies=" + dependencies +*/
                    ", state=" + state +
                    '}';
        }
    }

    static class Route {
        private List<Action> route;
        private int criticalPath;

        public Route(List<Action> route, int criticalPath) {
            this.route = route;
            this.criticalPath = criticalPath;
        }

        public List<Action> getRoute() {
            return route;
        }

        public void setRoute(List<Action> route) {
            this.route = route;
        }

        public int getCriticalPath() {
            return criticalPath;
        }

        public void setCriticalPath(int criticalPath) {
            this.criticalPath = criticalPath;
        }

        public Action getAction() {
            return route.get(route.size() - 1);
        }

        @Override
        public String toString() {
            return "Route{" +
                    "route=" + route +
                    ", criticalPath=" + criticalPath +
                    '}';
        }
    }

    static class Processor {
        private int id;
        private boolean busy;

        public Processor(int id) {
            this.id = id;
            this.busy = false;
        }

        public int getId() {
            return id;
        }

        public boolean isBusy() {
            return busy;
        }

        public void setBusy(boolean busy) {
            this.busy = busy;
        }

        @Override
        public String toString() {
            return "Processor{" +
                    "id=" + id +
                    ", busy=" + busy +
                    '}';
        }
    }
}
