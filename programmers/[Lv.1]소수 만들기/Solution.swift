import Foundation

func solution(_ nums:[Int]) -> Int {
    var count = 0
    for one in 0 ..< nums.count - 2 {
        for two in one + 1 ..< nums.count - 1 {
            for three in two + 1 ..< nums.count {
                if(isPrime(nums[one] + nums[two] + nums[three])) {count+=1}
            }
        }
    }
    return count
}

func isPrime(_ num : Int) -> Bool {
    for i in 2 ... Int(sqrt(Double(num))) {
        if(num%i == 0) { return false }
    }
    return true
}