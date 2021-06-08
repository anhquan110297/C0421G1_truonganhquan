package _04_class_and_obj_oop.bai_tap;

public class ClassStopWatch {
    private long startTime;
    private long endTime;

    public ClassStopWatch() {
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long start() {
        return System.currentTimeMillis();
    }

    public long end() {
        return System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        ClassStopWatch stopWatch = new ClassStopWatch();
        stopWatch.start();
        stopWatch.end();
        stopWatch.getElapsedTime();
        System.out.println(stopWatch.getElapsedTime());
    }
}
