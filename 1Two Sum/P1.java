package Q1_19;

/**
 * Created by DELL on 2015/9/22.
 */

import org.junit.Test;

import java.util.HashMap;
public class P1 {
   /*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution.

            Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].
 思路1：遍历，用haspmap存当前数字之前的数，查询haspmap中有没有另一个数加起来为target
 思路2(输入为排序好的)：两个指针指向头尾，若和大，右指针左移，若和小，左指针右移*/
    public static int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        if(nums==null)
            return res;
        //hashMap提供初始化大小要快些
        HashMap<Integer,Integer> numMap=new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
            int lookingfor=target-nums[i];
            if(numMap.containsKey(lookingfor)){
                res[0]=numMap.get(lookingfor);
                res[1]=i;
                return res;
            }
            numMap.put(nums[i], i);
        }
        return res;
    }
    @Test
    public void test(){
        int nums[];
        int res[];
        int target;
        //功能测试
        nums=new int[]{0,1,2,3,4,5,6,7,8,9};
        target=12;
        res=twoSum(nums,target);
        org.junit.Assert.assertArrayEquals(res,new int[]{5,7});
        //边界测试1：null和0大小数组
        nums=null;
        target=12;
        res=twoSum(nums,target);
        org.junit.Assert.assertArrayEquals(res,new int[]{0,0});
        nums=new int[]{};
        res=twoSum(nums,target);
        org.junit.Assert.assertArrayEquals(res,new int[]{0,0});
        //边界测试2：带重复数字
        nums=new int[]{0,1,6,3,4,5,6,7,8,9};
        target=12;
        res=twoSum(nums,target);
        org.junit.Assert.assertArrayEquals(res,new int[]{2,6});
        //边界测试3：没有解
        nums=new int[]{0,1,6,3,4,5,6,7,8,9};
        target=200;
        res=twoSum(nums,target);
        org.junit.Assert.assertArrayEquals(res,new int[]{0,0});
    }

    //需要排序好
    public static int[] twoSum1(int[] nums, int target) {
        int res[]=new int[2];
        int left=0;
        int right=nums.length-1;
        int tempSun;
        while (left<right){
            tempSun=nums[left]+nums[right];
            if(tempSun==target){
                res[0]=left;
                res[1]=right;
                return  res;
            }
            if(tempSun<target)
                left++;
            else
                right--;
        }
        return res;
    }
}