package fmt.SweepLine;

import java.util.*;

/**
 * Question Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at
 * most? Notice If landing and flying happens at the same time, we consider landing should happen at first. Example For
 * interval list [ [1,10], [2,3], [5,8], [4,7] ] Return 3
 */


class Point {
    int time;
    int flag;

    public Point(int x, int flag) {
        this.time = x;
        this.flag = flag;
    }

}

public class NumberofAirplanesintheSky {


    /**
     * @param airplanes: An interval array
     *
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>(10,
                Comparator.comparingInt(a -> a.time));
        for (Interval interval : airplanes) {
            queue.offer(new Point(interval.start, 1));
            queue.offer(new Point(interval.end, -1));
        }
        int count = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            count += p.flag;
            // if time is the same...
            while (!queue.isEmpty() && queue.peek().time == p.time) {
                p = queue.poll();
                count += p.flag;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public int countOfAirplanes3(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>(10,
                (a, b) -> {
                    if (a.time == b.time) { //order: -1 , 1
                        return a.flag - b.flag;
                    } else { // order: 1.00,2.00
                        return a.time - b.time;
                    }
                });


        for (Interval interval : airplanes) {
            queue.offer(new Point(interval.start, 1));
            queue.offer(new Point(interval.end, -1));
        }

        Iterator<Point> it = queue.iterator();
        while (it.hasNext()) {
            Point cur = it.next();
            System.out.println("[" + cur.time + ", " + cur.flag + "]");
        }

        int count = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            count += p.flag;
            max = Math.max(count, max);
        }
        return max;
    }

    // Memory Limit Exceeded
    public int countOfAirplanes2(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;

        for (Interval flight : airplanes) {
            int start = flight.start;
            int end = flight.end;
            for (int i = start; i < end; i++) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
                max = Math.max(max, map.get(i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Interval i0 = new Interval(1, 10);
        Interval i1 = new Interval(10, 20);
        Interval i2 = new Interval(20, 30);
        Interval i3 = new Interval(30, 40);
        //(1,10),(10,20),(20,30),(30,40)
        List<Interval> list = new ArrayList<>(Arrays.asList(i0, i1, i2, i3));
        NumberofAirplanesintheSky n = new NumberofAirplanesintheSky();

        //        System.out.println(n.countOfAirplanes(list));
        //        System.out.println(n.countOfAirplanes2(list));
        System.out.println(n.countOfAirplanes3(list));


    }
}
