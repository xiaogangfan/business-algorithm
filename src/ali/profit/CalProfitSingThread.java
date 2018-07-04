package ali.profit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * created by xiaogangfan
 * on 2018/6/12.
 */
public class CalProfitSingThread {

    /**Ԥ��ֵ*/
    private double warnValue = 0.3D;

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        List<Profit> profitList = new ArrayList<>();
        Profit profit1 = new Profit();
        profit1.start = 12L;
        profit1.end = 18L;
        profit1.profit = 0.1D;

        Profit profit2 = new Profit();
        profit2.start = 14L;
        profit2.end = 16L;
        profit2.profit = 0.2D;

        Profit profit3 = new Profit();
        profit3.start = 13L;
        profit3.end = 17L;
        profit3.profit = 0.2D;

        profitList.add(profit1);
        profitList.add(profit2);
        profitList.add(profit3);

        CalProfitSingThread calProfitSingThread = new CalProfitSingThread();
        long startTime1=System.currentTimeMillis();
        List<ProfitTimeNode> profitTime = calProfitSingThread.getProfitTime(profitList);
        long endtime1=System.currentTimeMillis();

        long startTime2=System.currentTimeMillis();
        Map<Interval, List<Profit>> timeUnit = calProfitSingThread.getInterval(profitTime, profitList);
        long endtime2=System.currentTimeMillis();

        long startTime3=System.currentTimeMillis();
        Map<Interval, List<List<Profit>>> allProfitPermutation = calProfitSingThread.getAllProfitPermutation(timeUnit);
        long endtime3=System.currentTimeMillis();

        long startTime4=System.currentTimeMillis();
        Map<Interval, List<List<Profit>>> intervalListMap = calProfitSingThread.calcaluteProfit(allProfitPermutation);
        long endtime4=System.currentTimeMillis();


        long endtime=System.currentTimeMillis();
//        System.out.println("���е�ʱ��� ִ��ʱ��="+(endtime1-startTime1));
//        System.out.println("���е�ʱ��㣺");
//        for (ProfitTimeNode time : profitTime) {
//            System.out.print(JSONObject.toJSON(profitTime));
//        }
//        System.out.println();
//        System.out.println("���е�ʱ��κͶ�Ӧ���Ż� ִ��ʱ��="+(endtime2-startTime2));
//        System.out.println("���е�ʱ��κͶ�Ӧ���Żݣ�");
//        for (Map.Entry<Interval, List<Profit>> entry : timeUnit.entrySet()) {
//            System.out.print("ʱ���="+entry.getKey().toString()+",");
//            for (Profit profit : entry.getValue()) {
//                System.out.print(JSONObject.toJSON(profit));
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println("��Ʒ��Ӧ���е�ʱ��ε�������� ִ��ʱ��="+(endtime3-startTime3));
//        System.out.println("��Ʒ��Ӧ���е�ʱ��ε�������ϣ�");
//        for (Map.Entry<Interval, List<List<Profit>>> entry : allProfitPermutation.entrySet()) {
//            System.out.print("ʱ���="+entry.getKey().toString()+",");
//            System.out.print("���="+ JSONObject.toJSONString(entry.getValue()));
//            System.out.println();
//        }
//
//        System.out.println("ʱ��κͶ�Ӧ ִ��ʱ��="+(endtime4-startTime4));
//        System.out.println("����Ԥ��ֵ���Ż���ϣ�");
//        for (Map.Entry<Interval, List<List<Profit>>> entry : intervalListMap.entrySet()) {
//            System.out.print("ʱ���="+entry.getKey().toString()+",");
//            System.out.print("���="+ JSONObject.toJSONString(entry.getValue()));
//            System.out.println();
//
//        }

        System.out.println("ִ��ʱ��="+(endtime-startTime));

    }


    public List<ProfitTimeNode> getProfitTime(List<Profit> profitList){
        List<ProfitTimeNode> allList = new ArrayList<>(profitList.size()*2);
        for (Profit profit : profitList) {
            allList.add(new ProfitTimeNode(profit.start, "s"));
            allList.add(new ProfitTimeNode(profit.end, "e"));
        }
        Collections.sort(allList, new ProfitTimeComparator());
        return allList;
    }

    public Map<Interval,List<Profit>> getInterval(List<ProfitTimeNode> profitList, List<Profit> profits){
        Map<Interval,List<Profit>> map = new HashMap<>();
        ProfitTimeNode pre = profitList.get(0);
        for (int i = 1; i < profitList.size(); i++) {
            ProfitTimeNode curr = profitList.get(i);
            if(!(pre.status.equals("e") && curr.status.equals("s"))){
                Interval interval = new Interval(pre.time,curr.time);
                List<Profit> list = new ArrayList<>();
                for (Profit profit : profits) {
                    if(profit.isContainTime(pre.time,curr.time)){
                        list.add(profit);
                    }
                }
                if(list.size() > 0){
                    map.put(interval,list);
                }
            }
            pre = curr;
        }

        return map;
    }

    public List<Interval> getInterval(List<ProfitTimeNode> profitList){
        List<Interval> intervalList = new ArrayList<>();
        ProfitTimeNode pre = profitList.get(0);
        for (int i = 1; i < profitList.size(); i++) {
            ProfitTimeNode curr = profitList.get(i);
            if(!(pre.status.equals("e") && curr.status.equals("s"))){
                Interval interval = new Interval(pre.time, curr.time);
                intervalList.add(interval);
            }
            pre = curr;
        }
        return intervalList;
    }

    public Map<Interval,List<List<Profit>>> getAllProfitPermutation(Map<Interval,List<Profit>> map){
        Map<Interval,List<List<Profit>>> result = new HashMap<>();
        for (Map.Entry<Interval, List<Profit>> entry : map.entrySet()) {
            List<List<Profit>> profitList = new ArrayList<>();
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                profitList.addAll(Combine.combinations(entry.getValue(),i+1));
//            }
            profitList.add(entry.getValue());
            result.put(entry.getKey(),profitList);
        }
        return result;
    }

    public Map<Interval,List<List<Profit>>> calcaluteProfit(Map<Interval,List<List<Profit>>> map){
        Map<Interval,List<List<Profit>>> result = new HashMap<>();
        List<List<Profit>> profitValue = new ArrayList<>();
        for (Map.Entry<Interval, List<List<Profit>>> entry : map.entrySet()) {
            for (List<Profit> profits : entry.getValue()) {
                double value = getCombineProfitValue(profits);
                // Ԥ����ֵ
                if(value < warnValue){
                    profitValue.add(profits);
                }
            }
            result.put(entry.getKey(),profitValue);
        }
        return result;
    }

    /**
     * �Ȱ�����Сֵ������
     * @param profits
     * @return
     */
    private double getCombineProfitValue(List<Profit> profits) {
        double result = 0.2D;

        for (Profit profit : profits) {
            if(result>=profit.profit){
                result = profit.profit;
            }
        }

        return result;
    }


}



/**
 * �Ż���
 */
class Profit{
    /**��ʼʱ��*/
    public Long start;
    /**����ʱ��*/
    public Long end;
    /**�Ż�*/
    public double profit;
    public List<Profit> profitList;
    public Boolean isContainTime(Long start,Long end){
        if(start == null) return false;
        if(end == null) return false;
        if(start >= end) return false;

        if(this.start <= start  && end <= this.end){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "[start:"+start+",end:"+end+"profit:"+profit+"]";
    }

}

/**
 * ʱ��
 */
class ProfitTimeNode {
    /**ʱ��*/
    public Long time;
    /**s:start e:end*/
    public String status;
    public ProfitTimeNode(Long time, String status){
        this.time = time;
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
            if (obj instanceof ProfitTimeNode) {
                ProfitTimeNode name = (ProfitTimeNode) obj;
                return (status.equals(name.status) && time.longValue() == name.time.longValue());
            }
            return super.equals(obj);
    }

    @Override
    public String toString() {
        return "[time:"+time+",status:"+status+"]";
    }
}


/**
 * �������
 */
class Combine {
    public static <T> List<List<T>> combinations(List<T> list, int k) {
        if (k == 0 || list.isEmpty()) {
            return Collections.emptyList();
        }
        if (k == 1) {
            return list.stream().map(e -> Stream.of(e).collect(Collectors.toList())).collect(Collectors.toList());
        }
        Map<Boolean, List<T>> headAndTail = split(list, 1);
        List<T> head = headAndTail.get(true);
        List<T> tail = headAndTail.get(false);
        List<List<T>> c1 = combinations(tail, (k - 1)).stream().map(e -> {
            List<T> l = new ArrayList<>();
            l.addAll(head);
            l.addAll(e);
            return l;
        }).collect(Collectors.toList());
        List<List<T>> c2 = combinations(tail, k);
        c1.addAll(c2);
        return c1;
    }

    public static <T> Map<Boolean, List<T>> split(List<T> list, int n) {
        return IntStream
                .range(0, list.size())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, list.get(i)))
                .collect(Collectors.partitioningBy(entry -> entry.getKey() < n, Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toList())));
    }

    public static void main(String[] args) {
        List<String> input = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<List<String>> combinations = combinations(input, 1);
        System.out.println("2-->"+combinations.toString());
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
        return "[start:"+start+",end"+end+"]";
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