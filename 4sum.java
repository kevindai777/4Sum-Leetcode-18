//Java Solution

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if (sum == target) {
                        List<Integer> temp = helper(nums, i, j, k, l);
                        result.add(new ArrayList<Integer>(temp));
                        
                        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        
                        while (l >= 1 && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
                
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        
        return result;
    }
    
    private List<Integer> helper(int[] nums, int i, int j, int k, int l){
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[i]); 
        temp.add(nums[j]); 
        temp.add(nums[k]); 
        temp.add(nums[l]);
        return temp;
    }
}