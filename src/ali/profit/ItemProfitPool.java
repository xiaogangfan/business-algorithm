package ali.profit;

import org.junit.Test;

import java.util.*;

/**
 * created by xiaogangfan
 * on 2018/7/3.
 */
public class ItemProfitPool {

    @Test
    public void testAddProfit() {
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            Profit profit = new Profit();
            Random rand =new Random();
            Random rand1 =new Random();

            profit.start = ((Integer)rand.nextInt(1000)).longValue();
            profit.end = profit.start+((Integer)rand1.nextInt(50)).longValue();
//            System.out.println("start="+profit.start+",end="+profit.end);

            addProfit(profit);
            if(i == 498){
                startTime = System.currentTimeMillis();
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("ִ��ʱ��:"+(endTime-startTime));
        System.out.println("size:"+map.size());
//        System.out.println("node:"+timeNodeList);
        System.out.println("map:"+map);
    }

    Map<Interval/**Interval*/,Set<Profit>> map = new HashMap<>();
    List<ProfitTimeNode> timeNodeList = new ArrayList<>();
    List<Interval> intervalList = new ArrayList<>();
    List<Interval> tempIntervalList = new ArrayList<>();

    /**
     * ����Ż�
     * @param profit
     */
    public void addProfit (Profit profit){
        /*���ӵ�timeNodeList��������*/
        addTimeNodeListAndSort(profit);
        /*������װʱ���*/
        getInterval();
        /*����ԭ����Map*/
        adjustMap();
        /*��������profit��Interval*/
        addToResult(profit);
    }

    /**
     * ���Ż����ӵ�ʱ��ڵ㲢����
     * @param profit
     */
    private void addTimeNodeListAndSort(Profit profit) {
        /*����ʱ��ڵ�*/
        timeNodeList.add((new ProfitTimeNode(profit.start,"s")));
        timeNodeList.add((new ProfitTimeNode(profit.end,"e")));
        /*����*/
        Collections.sort(timeNodeList, new ProfitTimeComparator());
    }

    /**
     * ÿ�������Ż�֮ǰ�����ϵ�Map����һ�£��ϵ�Interval���ܻᱻsplit�����д���
     */
    private void adjustMap() {
        List<Interval> needDelList = new ArrayList<>();
        List<Interval> intervalNewList = new ArrayList<>();
        Map<Interval/**Interval*/,Set<Profit>> temMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<Interval/**Interval*/,Set<Profit>>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<Interval, Set<Profit>> next = it.next();
            /*����ϵ�Interval�����µ�List Interval �У��������е�Interval����*/
            if(intervalList.contains(next.getKey())){
                continue;
            }
            needDelList.add(next.getKey());
            /*old��Interval���и��������µ�Interval*/
            intervalNewList = findIntervalList(next.getKey().start, next.getKey().end);
            it.remove();/*�ϵ�Interval�������µĵ�List<Interval>�У�����Ҫɾ��*/
            if(intervalNewList.size() == 0){
                continue;
            }
            for (Interval interval : intervalNewList) {
                if(interval.start != interval.end){
                    temMap.put(interval,next.getValue());
                }
            }
        }
        map.putAll(temMap);
    }

    /**
     * Ѱ������timeNode֮�����е�Interval
     */
    private List<Interval> findIntervalList(Long start, Long end) {
        tempIntervalList.clear();
        int i = timeNodeList.indexOf(new ProfitTimeNode(( start).longValue(), "s"));
        int j = timeNodeList.indexOf(new ProfitTimeNode(( end).longValue(), "e"));
        for (;(i>0 && j>0)&&i<j;i++){
            if(timeNodeList.get(i).time.longValue() != timeNodeList.get(i+1).time.longValue()) {
                tempIntervalList.add(new Interval(timeNodeList.get(i).time, timeNodeList.get(i + 1).time));
            }
        }
        return tempIntervalList;
    }

    /**
     * ����List Interval
     * ʹ�������α������timeNodeList�ǰ�ʱ�������
     */
    public void getInterval(){
        intervalList.clear();
        ProfitTimeNode pre = timeNodeList.get(0);
        for (int i = 1; i < timeNodeList.size(); i++) {
            ProfitTimeNode curr = timeNodeList.get(i);
            if(!(pre.status.equals("e") && curr.status.equals("s"))){
                if(pre.time.longValue() != curr.time.longValue()){
                    Interval interval = new Interval(pre.time, curr.time);
                    intervalList.add(interval);
                }
            }
            pre = curr;
        }
    }

    /**
     * �����Żݲ�������������
     */
    private void addToResult(Profit profit) {
        /*���������Żݲ�����Interval*/
        List<Interval> intervalIncrementList = findIntervalList(profit.start, profit.end);
        intervalIncrementList.stream().forEach(row -> {
            if(map.get(row) == null){/*���Ϊ��ֱ������*/
                Set list = new HashSet();
                list.add(profit);
                map.put(row,list);
            }else{/*�����Ϊ�գ���ԭ����List������*/
                if(!map.get(row).contains(profit)){
                    map.get(row).add(profit);
                }
            }
        });
    }


    /**
     * ɾ���Ż�
     * @param map
     * @param profit
     */
    public void delProfit (Map<Interval,List<Profit>> map,Profit profit){
        List<Interval> intervalList = findIntervalList(profit.start, profit.end);
        /*ɾ��Interval�е�profit*/
        intervalList.stream().parallel().forEach(row -> {
            map.get(row).remove(row);
        });
        /*ɾ��timeNode*/
        timeNodeList.remove(new ProfitTimeNode(profit.start,"s"));
        timeNodeList.remove(new ProfitTimeNode(profit.start,"e"));
    }



}
class ProfitTimeComparator implements Comparator<ProfitTimeNode> {
    @Override
    public int compare(ProfitTimeNode o1, ProfitTimeNode o2) {
        if (o1.time < o2.time) {
            return -1;
        }
        if (o1.time > o2.time) {
            return 1;
        }
        return 0;
    }
}

/**
 * ʱ���
 */
class Interval {
    public Long start;
    public Long end;
    private final int PRIME = 37;
    public Interval() {
        start = 0L;
        end = 0L;
    }

    public Interval(Long s, Long e) {
        if(s == e){
            return;
        }
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[start:"+start+",end:"+end+"]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Interval) {
            Interval name = (Interval) obj;
            return (start.longValue()==name.start.longValue()) && (end.longValue() == name.end.longValue());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hashResult = 1;
        hashResult = (hashResult + Long.valueOf(start).hashCode() + Long.valueOf(end).hashCode()) * PRIME;
        return hashResult;
    }
}
