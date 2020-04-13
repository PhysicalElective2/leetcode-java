package solution;

class Solution7 {
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        char [] stringArr = s.toCharArray();
        for(int i=0;i<stringArr.length;i++){
            if(stringArr[i]!=stringArr[stringArr.length-i-1]){
                return false;
            }
        }
        return true;
    }
    public int[] twoSum(int[] nums, int target) {
        //在来一个数组记录下标不
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {//2
        ListNode res=new ListNode((l1.val+l2.val)%10);
        int add=(l1.val+l2.val)/10;
        ListNode m=res;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null&&l2!=null){
            ListNode n=new ListNode((l1.val+l2.val+add)%10);
            add=(l1.val+l2.val+add)/10;
            m.next=n;
            m=n;
            l1=l1.next;
            l2=l2.next;
        }
        while(add>0){
            if(l1!=null){
                ListNode n=new ListNode((l1.val+add)%10);
                add=(l1.val+add)/10;
                m.next=n;
                m=n;
                l1=l1.next;
                continue;
            }
            if(l2!=null){
                ListNode n=new ListNode((l2.val+add)%10);
                add=(l2.val+add)/10;
                m.next=n;
                m=n;
                l2=l2.next;
                continue;
            }
            ListNode n=new ListNode(add);
            add=0;
            m.next=n;
            m=n;
        }
        if(l1!=null){//不对，这里还可能进一
            m.next=l1;
        }
        if(l2!=null){
            m.next=l2;
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return  0;
        }
        int maxL=1;
        int p=0;
        int q=1;//记录的是确实的位置，所以q-p+1=num
        for(int i=1;i<s.length();i++){
            //System.out.println("pq"+p+" "+q);
            int res=s.substring(p,q).indexOf(s.substring(i,i+1));
            q=i+1;//进一位
//            System.out.println(s.substring(p,q));
//             System.out.println(s.substring(i,i+1));
//            System.out.println(res);
//            System.out.println("__________________");
            if(res>=0){
                p=p+res+1;
            }else {
                if(q-p>maxL){
                    maxL=q-p;
                }
            }
        }
        return maxL;
    }
    public boolean isHappy(int n) {
        //如何终至死循环，将每次变换过后的值存入HashSet中
        int unh[]={4, 16, 37, 58, 89,145, 42, 20};
        while(n!=1){
            for (int aa : unh) {
                if (n==aa){
                    return false;
                }
            }
            int sum=0;
          //  System.out.println(n);
            while(n>0){
                sum += (int)Math.pow(n%10,2);
                n/=10;
            }
            n=sum;
            if(n==1){
                return true;
            }
            //是不是还要记录循环
        }
        return false;
    }
    public int[] sumZero(int n) {
        int res[]=new int[n];
        if(n%2==0){
            for(int i=0;i<n/2;i++){
                res[i]=i+1;
                res[n-i-1]=(i+1)*-1;
            }
        }else{
            for(int i=0;i<=n/2;i++){
                res[i]=i+1;
                res[n-i-1]=(i+1)*-1;
            }
            res[n/2]=0;
        }
        return res;

    }
    public double findMedianSortedArraysNO(int[] nums1, int[] nums2) {
        //奇数偶数,还要考虑一个是空的
        if(nums1.length==0){
            if(nums2.length%2==0){//偶数
                return (float)(nums2[nums2.length/2]+nums2[nums2.length/2-1])/2;
            }else {
                return nums2[nums2.length/2];
            }

        }
        if(nums2.length==0){
            if(nums1.length%2==0){//偶数
                return (float)(nums1[nums1.length/2]+nums1[nums1.length/2-1])/2;
            }else {
                return nums1[nums1.length/2];
            }
        }
        int mid;
        if((nums1.length+nums2.length)%2==0){
            mid=(nums1.length+nums2.length)/2;
        }else {
            mid=(nums1.length+nums2.length)/2+1;
        }
        int i=0;
        //pq 都应该从-1 开始
        int p=0;
        int q=0;
        boolean thiss= true;//默认在第一个数组
        while(true){
            i++;//因为只要进入循环，始终会执行这一次，一定会超出
            if(p<nums1.length&&q<nums2.length){
                if(nums1[p]<nums2[q]){
                    p++;//p代表将要比较的下一位。
                    thiss=true;
                }else {
                    thiss =false;
                    q++;
                }
            }else if(p==nums1.length){
                q++;
                thiss=false;
            }else {//q 到达边界了
                p++;
                thiss=true;
            }
            if(i>=mid){
                break;
            }
        }
        //出循环就等于mid 了
        //如果是奇数，还要再找第二个。
        if((nums1.length+nums2.length)%2==0){//偶数
            int second;
            float res;
            //还要再找一个
            if(thiss){
                if(p<nums1.length){
                    second=(nums1[p]<nums2[q]?nums1[p]:nums2[q]);//num 的下一位已经越界了
                }else {
                    second=nums2[q];
                }
                res=(float)(nums1[p-1]+second)/2;
            }else {
                if(q<nums2.length){//这时候p 也已经越界了
                    second=(nums1[p]<nums2[q]?nums1[p]:nums2[q]);//num 的下一位已经越界了
                }else {
                    second=nums1[p];
                }
                res=(float)(nums2[q-1]+second)/2;
            }
            return res;
        }else {//奇数,在那个队列不一定。
            return thiss? nums1[p-1]:nums2[q-1];
        }
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {//别人的代码，直接存两个数，
        int len1 = nums1.length;
        int len2   = nums2.length;
        int middle =  (len1 + len2) / 2;

        int        a = 0;
        int b = 0;

        int then = 0;
        int pre  = 0;

        while (true){
            if (a < len1 && b < len2){
                if (nums1[a] <= nums2[b]){
                    then = nums1[a++];
                }else {
                    then = nums2[b++];
                }
            }else if (a < len1 && b == len2){
                then = nums1[a++];
            }else if (b < len2 && a == len1){
                then = nums2[b++];
            }

            if (a + b > middle){
                break;
            }else {
                pre = then;
            }
        }

        //奇偶
        if ((len1 + len2) % 2 == 0){
            //偶数
            return (Integer.valueOf(pre).doubleValue() + Integer.valueOf(then).doubleValue()) / 2;
        }else {
            //奇数
            return Integer.valueOf(then).doubleValue();
        }

    }
    public double findMedianSortedArrays(int num1[],int num2[]){
        //直接找两个数，不再考虑奇数还是偶数
        int p =0;
        int q =0;
        int mid=(num1.length+num2.length)/2;
        int pre =0;
        int then =0;
        while(true){
            if(p<num1.length&&q<num2.length){
                if(num1[p]<num2[q]){
                    then =num1[p];
                    p++;
                }else{
                    then =num2[q];
                    q++;
                }
            }else if(p==num1.length){
                then =num2[q];
                q++;
            }else{
                then =num1[p];
                p++;
            }
            if (p + q > mid){
                break;
            }else {
                pre = then;
            }
        }
        if((num1.length+num2.length)%2==0){
            return (float)(then+pre)/2;
        }else {
            return then;
        }

    }
}