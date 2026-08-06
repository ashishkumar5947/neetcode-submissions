/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
     public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        intervals.sort(Comparator.comparingInt((interval) -> interval.start));
        List<Integer> rooms = new ArrayList<>();

        for (Interval meeting : intervals) {
            boolean assigned = false;

            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i) <= meeting.start) {
                    rooms.set(i, meeting.end);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                rooms.add(meeting.end);
            }
        }
        
        return rooms.size();
    }
}
