class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        TimeClass[] timeData = new TimeClass[lines.length];
        for(int i=0;i<lines.length;i++) {
            String[] splitLog = lines[i].split(" ");
            double endTime = timeStamp(splitLog[1]);
            double startTime = getStartTime(endTime, splitLog[2]);
            timeData[i] = new TimeClass(startTime,endTime);
        }

        //초당 처리량은 1초 구간 내에 제일 많이 job이 들어간 경우 최대가 되는데
        //각 구간에서 가장 밀집해 있는 구간을 정할 때, 가장 빠른 endTime을 가진 job을 시작으로 두고
        //1초 이내에 시작되는 작업이 있는 경우가 최대 초당 처리량 구간이 됨
        for(int i =0; i<timeData.length;i++) {
            int count = 1;
            for(int j = i+1;j<timeData.length;j++) {
                //j 번째의 시작 시간이 i 번째의 끝시간과의 차이가 1초 이내인 경우
                //같은 구간에 존재할 수 있어서 초당 처리량의 기준에 부합
                if((timeData[j].startTime - timeData[i].endTime) < 1000) count++;
            }
            //모든 job의 끝에서 처리량을 구해서 그 값이 가장 큰 값을 정답으로 침
            answer = (answer>count)?answer:count;
        }
        return answer;
    }

    //입력 형식에 맞춰 끝 시간을 second time으로 변환하는 메소드
    private double timeStamp(String time) {
        String[] split = time.split(":");

        return (Double.parseDouble(split[0]) * 60 * 60 * 1000)
                + (Double.parseDouble(split[1]) * 60 * 1000)
                + (Double.parseDouble(split[2]) * 1000);
    }

    //입력 형식에 맞춰 시작 시간 구하는 메소드
    private double getStartTime(double endTime, String timeS) {
        return endTime - Double.parseDouble(timeS.substring(0,timeS.length()-1))*1000+1;
    }
}

//시간을 저장하기 위한 data class
class TimeClass{
    double startTime;
    double endTime;

    public TimeClass(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toString() {
        return "startTime: " + startTime+", endTime: " +endTime;
    }
}