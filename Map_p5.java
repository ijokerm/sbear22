import java.util.*;

public class Map_p5 {
   //每个单词对应的次数
    Map<String,Integer>count(String[] words){
        Map<String,Integer>wordTocount=new HashMap<>();
        for(String word:words){
            int c=wordTocount.getOrDefault(word,0);
            wordTocount.put(word,c+1);
        }
        return wordTocount;
    }
//根据次数对应到单词
    Map<Integer, List<String>>remap(Map<String,Integer>wordTocount){
        Map<Integer,List<String>>countToword=new HashMap<>();
        // 按 key-value 映射关系打印
        for(Map.Entry<String,Integer>e:wordTocount.entrySet()){
            String word=e.getKey();
            int count=e.getValue();

            List<String>wordList=countToword.get(count);
            if(wordList==null) {
                wordList = new ArrayList<>();

                countToword.put(count,wordList);
            }
            wordList.add(word);
        }
        return countToword;
    }

    public List<String>topKFrequent(String[] words,int k){
        Map<String,Integer>wordTocount=count(words);
        //得到次数
        Map<Integer,List<String>>countToword=remap(wordTocount);
        //得到次数对应的单词组
        Set<Integer>keys=countToword.keySet();
        int[] counts=new int[keys.size()];
        int i=0;
        for(int key:keys){
            counts[i++]=key;
        }
        Arrays.sort(counts);
        List<String>result=new ArrayList<>();
        int j=0;
        int index=counts.length-1;
        //
        while(j<k){
            int c=counts[index--];
            List<String>wordList=countToword.get(c);
            if(wordList.size()<=k-j){
                result.addAll(wordList);
                j+=wordList.size();
            }else{
                result.addAll(wordList.subList(0,k-j));
                j=k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words={"I","love","A","I","love","me"};
        List<String>r=new Map_p5().topKFrequent(words,3);
        System.out.println(r);

    }

}
