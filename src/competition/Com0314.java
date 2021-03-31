package competition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Com0314 {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diffIndex =new ArrayList<>();
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
               diffIndex.add(i);
            }
            if(diffIndex.size()>2) return false;
        }
        return diffIndex.size()==0||(diffIndex.size()==2&&s1.charAt(diffIndex.get(0))==s2.charAt(diffIndex.get(1)))&&s1.charAt(diffIndex.get(1))==s2.charAt(diffIndex.get(0));



    }
    public int findCenter(int[][] edges) {

        for(int  node: edges[1]){
            for(int  node2: edges[0]){
                if(node==node2) return node;

            }

        }
        return -1;

    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res=0.0;
        PriorityQueue<int[]> queue =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               if(Double.valueOf(o2[0]+1)/Double.valueOf(o2[1]+1) - Double.valueOf(o2[0])/Double.valueOf(o2[1])-(Double.valueOf(o1[0]+1)/Double.valueOf(o1[1]+1) - Double.valueOf(o1[0])/Double.valueOf(o1[1]))>0){
                   return 1;
               }else {
                   return -1;
               }

            }
        });
      for(int i=0;i<classes.length;i++){
          queue.add(classes[i]);
      }

      while (extraStudents>0){
          int[] oneclass=queue.poll();
          oneclass[1]+=1;
          oneclass[0]+=1;
          queue.offer(oneclass);
          extraStudents--;
      }
      while (!queue.isEmpty()){
          int[] poll = queue.poll();
          res += poll[0] * 1.0 / poll[1];

      }
      return res/classes.length;



    }
    public int maximumScore(int[] nums, int k) {
        return 0;


    }
}
