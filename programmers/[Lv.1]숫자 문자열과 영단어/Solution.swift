import Foundation

func solution(_ s:String) -> Int {
    var result : String = s
    let english = ["zero", "one", "two", "three","four","five","six","seven", "eight", "nine"]
    for x in 0 ..< english.count {
        result = result.replacingOccurrences(of: english[x], with: String(x))
    }
    return Int(result)!
}