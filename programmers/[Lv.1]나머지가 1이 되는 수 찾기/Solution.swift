import Foundation

func solution(_ n:Int) -> Int {
    for i in 2...n/2 {if(n%i == 1) {return i}}
    return n-1
}