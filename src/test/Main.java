package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Stu
{
    int num;
    boolean out; //是否淘汰

    public Stu(int n){
        num = n;
    }

    public void count(int n, int k){
        if(n%k == 0 || n%10==k)
            out = true;
    }
}

class ccf2017122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Queue<Stu> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Stu s = new Stu(i+1);
            queue.offer(s);
        }

        int number = 1, left = n;
        while (!queue.isEmpty()){
            Stu stu = queue.poll();
            stu.count(number++,k);

            if(stu.out){
                queue.remove(stu);
                left--;
            }
            else
                queue.offer(stu);

            if(left == 1){
                System.out.println(queue.poll().num);
                return;
            }
        }
    }
}

//class ccf31 {
//    private static List<String> ans = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n, m;
//
//        while (in.hasNext()) {
//            n = in.nextInt();
//            m = in.nextInt();
//            String[] p = new String[n];
//            String[] r = new String[n];
//            in.nextLine();
//            for (int i = 0; i < n; i++) {
//                String[] split = in.nextLine().split(" ");
//                p[i] = split[0];
//                r[i] = split[1];
//            }
//
//            for (int i = 0; i < m; i++) {
//                String string = in.nextLine();
//                String[] cmd = string.split("/");
//                String[] ans = deal(cmd,p);
//                }
//            }
//        }


//    public static String[] deal(String[] input, String[] p) {
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < p.length; i++) {
//            String[] pattern = p[i].split("/");
//            if (pattern.length >= input.length)
//                return new String[0];
//            for (int j = 1; j < pattern.length; j++) {
//                if(pattern[i].equals(input[i]))
//                    continue;
//                else {
//                    if(pattern[i].equals("<int>") && input[i].matches("[0-9]+"))
//                        ans.add(input[i]);
//                    if(pattern[i].equals("<str>") && )
//                }
//            }
//
//        }
//    }


// }


public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        Map<String, String> rules = new HashMap<>();
        String[] urls = new String[m];
        for (int i = 0; i < n; i++) {
            String string = sc.nextLine();
            String[] sp = string.split(" ");
            rules.put(sp[1],sp[0]);
        }
        for (int i = 0; i < m; i++) {
            urls[i] = sc.nextLine();
        }

        Map<String,String> reg = new HashMap<>();
        reg.put("<int>","([0-9]+)");
        reg.put("<str>","([\\\\w\\\\-\\\\.]+)");
        reg.put("<path>","(?<path>([\\\\w\\\\-\\\\.]+/)+[\\\\w\\\\-\\\\.]+)");

        for (Map.Entry<String,String> entry: rules.entrySet()){
            String rule = entry.getValue();
            rule = rule.replaceAll("<int>",reg.get("<int>"));
            rule = rule.replaceAll("<str>",reg.get("<str>"));
            rule = rule.replaceAll("<path>",reg.get("<path>"));
            rules.put(entry.getKey(),rule);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String str: urls) {
            boolean find = false;
            List<String> row = new ArrayList<>();
            for (Map.Entry<String,String> entry: rules.entrySet()) {
                Pattern pattern = Pattern.compile(entry.getValue());
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()){
                    find = true;
                    //System.out.println(matcher.group(1));
                    row.add(entry.getKey());
                    for (int i = 0; i < matcher.groupCount(); i++) {
                        String a = matcher.group(i+1);
                        row.add(a);
                        if(a.contains("/"))
                            break;
                    }
                    ans.add(row);
                }
                if(find == true)
                    break;
            }
            if(find == false) {
                row.add("404");
                ans.add(row);
            }
        }

        for (List<String> row: ans) {
            for (String term:row) {
                System.out.print(term + " ");
            }
            System.out.println();
        }
    }
}

class ccf1 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0, contin = 0, score = 0;
        while ((score = sc.nextInt()) != 0) {
            if (score == 1) {
                sum += 1;
                contin = 0;
            } else {
                contin++;
                sum += contin * 2;
            }
        }
        System.out.println(sum);
    }
}

class ccf2{
    public static void stuck(int count, int length, int second, ball[] balls){
        for (int i = 1; i <= second; i++) {
            balls[0].pos += balls[0].dir;
            if(balls[0].pos == 0)
                balls[0].dir = -balls[0].dir;

            for (int j = 1; j < count; j++) {
                balls[j].pos += balls[j].dir;
                if(balls[j-1].pos == balls[j].pos){
                    balls[j-1].dir = -balls[j-1].dir;
                    balls[j].dir = -balls[j].dir;
                }
                if(balls[j].pos == length)
                    balls[j].dir = -balls[j].dir;
            }
        }
        Arrays.sort(balls,new orderComp());
        for (int i = 0; i < balls.length; i++) {
            System.out.print(balls[i].pos + " ");
        }
    }

    public static class ball{
        int pos;
        // 1是正向向右，-1是负向向左
        int dir;
        int order;
    }

    public static class ballComp implements Comparator<ball>{
        public int compare(ball a, ball b){
            if (a.pos - b.pos < 0)
                return -1;
            else
                return 1;
        }
    }

    public static class orderComp implements Comparator<ball>{
        public int compare(ball a, ball b){
            if (a.order - b.order < 0)
                return -1;
            else
                return 1;
        }
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(), length = sc.nextInt(), second = sc.nextInt();
        ball[] balls = new ball[count];
        for (int i = 0; i < count; i++) {
            balls[i] = new ball();
            balls[i].pos = sc.nextInt();
            balls[i].dir = 1;
            balls[i].order = i;
        }
        Arrays.sort(balls,new ballComp());
        stuck(count,length,second,balls);

    }
}


class mmmain {

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

        methodDemo_2();


    }


    /**
     * 将日期格式的字符串-->日期对象。
     * 	使用的是DateFormat类中的parse()方法。
     *
     * @throws ParseException
     */
    public  static void methodDemo_3() throws ParseException {
        String str_date = "2012年4月19日";
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG); //Thu Apr 19 00:00:00 CST 2012

        str_date = "2011---8---17";
        dateFormat = new SimpleDateFormat("yyyy---MM---dd");   // Wed Aug 17 00:00:00 CST 2011

        Date date = dateFormat.parse(str_date);
        System.out.println(date);
    }


    /**
     * 对日期对象进行格式化。
     * 将日期对象-->日期格式的字符串。
     * 	使用的是DateFormat类中的format方法。
     */
    public static void methodDemo_2() {
        Date date = new Date();

        //获取日期格式对象。具体着默认的风格。 FULL LONG等可以指定风格。
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);  //2018年8月7日
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //2018年8月7日 下午05时02分04秒

        //如果风格是自定义的如何解决呢？
        dateFormat = new SimpleDateFormat("yyyy--MM--dd"); //2018--08--07
        String str_date = dateFormat.format(date);

        System.out.println(str_date);
    }



    /**
     * 日期对象和毫秒值之间的转换。
     *
     * 毫秒值-->日期对象 ：
     * 	1，通过Date对象的构造方法  new Date(timeMillis);
     *  2，还可以通过setTime设置。
     *  因为可以通过Date对象的方法对该日期中的各个字段(年月日等)进行操作。
     *
     *
     * 日期对象-->毫秒值：
     * 	2，getTime方法。
     * 因为可以通过具体的数值进行运算。
     *
     *
     */
    public static void methodDemo_1() {
        long time = System.currentTimeMillis();//
//		System.out.println(time);//1335671230671

        Date date = new Date();//将当前日期和时间封装成Date对象。
        System.out.println(date);//Sun Apr 29 11:48:02 CST 2012

        Date date2 = new Date(1335664696656l);//将指定毫秒值封装成Date对象。
        System.out.println(date2);
    }



}
