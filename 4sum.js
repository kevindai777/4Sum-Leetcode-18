//Objective is similar to '3Sum' except with 4 elements.

let nums = [1, 0, -1, 0, -2, 2]
let target = 0


//O(n^3) solution (for any future 'k' sum question, the best time complexity
//will always be O(n^(k - 1)))

let result = []
    
nums.sort((a,b) => {
    return a - b
})
    
for (let i = 0; i < nums.length - 3; i++) {
    for (let j = i + 1; j < nums.length - 2; j++) {
        let k = j + 1
        let l = nums.length - 1
            
        while (k < l) {
            let sum = nums[i] + nums[j] + nums[k] + nums[l]
            
            if (sum == target) {
                result.push([nums[i], nums[j], nums[k], nums[l]])
                    
                while (nums[k] == nums[k + 1]) {
                    k++
                }
                    
                while (nums[l] == nums[l - 1]) {
                    l--
                }
                    
                k++
                l--
            } else if (sum < target) {
                k++
            } else {
                l--
            }
        }
        while (nums[j] == nums[j + 1]) {
            j++
        }
    }
    while (nums[i] == nums[i + 1]) {
        i++
    }
}
    
return result