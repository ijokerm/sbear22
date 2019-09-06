import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Map_p4 {
    //坏键盘打字
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String expected=scanner.nextLine();
        String actual=scanner.nextLine();

        Set<Character>set=new HashSet<>();
        char[]a=actual.toUpperCase().toCharArray();
//toCharArray() 将此字符串转换为新的字符数组。
//toUpperCase() 将所有在此字符 String使用默认语言环境的规则大写
        for(char c:a){
            set.add(c);
        }
        char[]b=expected.toUpperCase().toCharArray();
//记录已经打印过的键
        Set<Character>brokenKeys=new HashSet<>();
        for(char c:b){
            if(!set.contains(c)){
                if(!brokenKeys.contains(c)){
                    System.out.println(c);
                    brokenKeys.add(c);
                }
            }
        }

    }
}
