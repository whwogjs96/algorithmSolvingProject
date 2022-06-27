import java.util.ArrayList;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Integer> data[] = new ArrayList[9];
        //각 숫자를 이미 계산한 적이 있는지 파악하는 변수
        int checked[] = new int[(N==1)?number*10:(int) Math.pow(N, 8)+1];
        data[1] = new ArrayList<Integer>();
        ArrayList<Integer> firstList = data[1];
        int repeat = N;
        firstList.add(N);//1
        if(N==number) return 1;
        for(int i=2;i<=8;i++) { //8번보다 반복 횟수가 큰 경우 -1
            data[i] = new ArrayList<Integer>();
            repeat = repeat*10+N;
            data[i].add(repeat);
            //2번만에 해결되는 경우
            if(number == repeat) return i;
            for(int j=1;j<=i/2;j++) {
                //반복할 리스트 호출
                ArrayList<Integer> prevList1 = data[j];
                ArrayList<Integer> prevList2 = data[i-j];
                for(int x=0;x<prevList1.size();x++) {
                    int prevData1 = prevList1.get(x);
                    for(int y= 0;y<prevList2.size();y++) {
                        int prevData2 = prevList2.get(y);
                        int plus = prevData1 +prevData2;
                        int minus = Math.abs(prevData1 - prevData2);
                        int multi = prevData1 * prevData2;
                        int div = 0;
                        if(prevData2 != 0) {
                            div = (prevData1 > prevData2)? prevData1/prevData2 : prevData2/prevData1;
                        }
                        //현재 만족하는 게 있다면 그게 가장 짧은 것이기 때문에
                        //바로 i 횟수를 리턴
                        if(plus == number || minus == number || multi == number || div == number){
                           return i; 
                        } 
                        //각 데이터를 넣을 때 이미 계산한 숫자인 경우
                        //더 짧게 계산된 숫자가 들어감으로 리스트에 추가하지 않음
                        else {
                            if(plus > 0 && plus <checked.length && checked[plus] == 0){
                                data[i].add(plus);
                                checked[plus] = i+1;
                            }
                            if(multi >0 && multi <checked.length && checked[multi] == 0){
                                data[i].add(multi);
                                checked[multi] = i+1;
                            }
                            if(minus <checked.length && minus >0 && checked[minus] == 0){
                                data[i].add(minus);
                                checked[minus] = i+1;
                            }
                            if(div >0 && div <checked.length &&  checked[div] == 0){
                                data[i].add(div);
                                checked[div] = i+1;
                            }
                        }
                    }
                }
            }
            
        }
        return -1;
    }
}