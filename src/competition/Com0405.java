package competition;

import java.util.Arrays;

public class Com0405 {
    public static void main(String[] args) {
        Com0405 c=new Com0405();
//        c.orchestraLayout(6,1,2);
//        System.out.println(c.purchasePlans(new int[]{2,5,3,5},6));
        String a="ff";
        String b="fsf";
        System.out.println(b.indexOf(a));

    }
    public int magicTower(int[] nums) {
        int res=-1;
        return res;


    }
    public int orchestraLayout(int num, int xPos, int yPos) {
        int sum =num*num;
        int x=0;
        int y=0;
        int[][] xx=new int[num][num];
        for(int[] xxx:xx){
            Arrays.fill(xxx,-1);
        }
        xx[0][0]=1;
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int derection =0;
        int index =1;


        while (index<sum){
            int nextX=x+dx[derection];
            int nextY=y+dy[derection];
            if(0<=nextX&&nextX<num&&0<=nextY&&nextY<num&&xx[nextX][nextY]==-1){
                x=nextX;
                y=nextY;
                xx[x][y]=index%9+1;
                index++;

            }else{
                derection=(derection+1)%4;
            }
        }
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                System.out.print(" "+xx[i][j]);
            }
            System.out.println();
        }
        return xx[xPos][yPos];

    }
    public int purchasePlans2(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int res=0;
        int l=0;
        int r=nums.length-1;
        while (l<r){
            if(nums[l]+nums[r]>target){
                r--;
            }else {
                res+=(r-l);
                l++;
            }
            res=res%mod;
        }
        return res;

    }

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
//            int j = nums.length - 1;
            int l=i+1;
            if(nums[i]+nums[i+1]>target) break;
            int r= nums.length - 1;
            int mid=-1;

            while (l<r){
                mid=(l+r)/2;
                int sum = nums[i]+nums[mid];
                int afersum = nums[i]+nums[mid+1];
                if(sum<=target&&afersum>target){
                    break;
                }else if(sum<=target&&afersum<=target){
                    l=mid;
                }else {
                    r=mid;
                }

            }
            if(mid!=-1){
                res += (mid- i);
            }


        }
        return res % 1000000007;
    }

}
