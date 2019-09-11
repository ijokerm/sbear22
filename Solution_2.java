import java.util.*;
class Node{
    int key;
    int val;

    Node next;
}

//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符
// （包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，
// 则需要在最终答案中包含该字符 3 次。
public class Solution_2 {
    public static List<String> commonChars(String[] A){
       //1、统计单词中的字母出现次数
        List<String>result=new ArrayList<>();
        if(A==null||A.length<2){
            return result;
        }
        List<Map<Character,Integer>>list=new ArrayList<>();
        for(String a:A){
            Map<Character,Integer>map=new HashMap<>();
            //切成字符
            for(char c:a.toCharArray()){
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                }
                //int n=map.getOrDefault(c,0);
                //map.put(c,n+1);
            }
            list.add(map);
        }
        System.out.println(list);
        //2、看它里面有没有都出现的字符
        for(char c:list.get(0).keySet()){
            boolean allcontains=true;
            for(int i=1;i<list.size();i++){
                Map<Character,Integer>map=list.get(i);
                if(!map.containsKey(c)){
                    allcontains=false;
                    break;
                }
                continue;
            }
            int min=list.get(0).get(c);
            for(int i=1;i<list.size();i++){
                int n=list.get(0).get(c);
                if(n<min){
                    min=n;
                }
            }
            for(int i=1;i<list.size();i++){
                 result.add(String.valueOf(c));
            }
        }



       /** Set<Character>containKey=list.get(0).keySet();

        for(int i=1;i<list.size();i++){
            containKey.retainAll(list.get(i).keySet());
        }
     Iterator<Character>iterator=containKey.iterator();
        while(iterator.hasNext()){
            Character cur=iterator.next();
            int minCount=list.get(0).get(cur);
            for(int i=1;i<list.size();i++){
                Integer cnt=list.get(i).get(cur);
                if(cnt<minCount){
                    minCount=cnt;
                }
            }
        }
        return result;
        */
       return result;
    }
//哈希



    public static void main(String[] args) {
        String[] s={"bella","label","roller"};
        System.out.println(commonChars(s));
    }
}
