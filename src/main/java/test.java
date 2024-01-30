import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.List;

public class test {
    /*优惠采用递进结算即不同使用顺序产生的优惠不同，用户可以选择使用任意数量的优惠券。输入:一个包含所有优惠券标识符的列表。
    例如，[“A"，"B”，“C"]。输出:打印用户可能使用的优惠券的组合例如，[A”，"B”，"C”]
    的所有可能组合和排列包括"A"，"B"，“C"，"AB"，"AC","BC"，"BA","CA","CB"，"ABC”,"ACB"，"BAC "，"BCA"，"CAB"，"CBA"等*/
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');

        func(0, list, new StringBuilder());
    }

    public static void func(int len, List<Character> list, StringBuilder result){
        if (len == list.size()){
            System.out.println(result.toString());
        }
        for (int i = 0; i < list.size(); i++){
            char c = list.get(i);
            func(len+1, list, result);//不使用当前优惠券

            result.append(list.get(i));//使用当前优惠券
            list.remove(i);
            func(len+1, list, result);

            //重置状态
            list.add(c);
            result.deleteCharAt(result.length() - 1);
        }

    }

    public static void func2(List<Character> list, int n, StringBuilder result){
        if (n == list.size()){
            System.out.println(result);
        }

    }
}
