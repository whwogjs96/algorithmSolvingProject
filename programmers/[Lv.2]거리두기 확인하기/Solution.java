import java.lang.Math;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<places.length;i++) {
            char[][] map = new char[5][5];
            for(int j=0;j<places[i].length; j++) {
                char[] location = places[i][j].toCharArray();
                map[j] = location;
            }
            answer[i] = isSocialDistancing(map);
        }
        return answer;
    }
    
    public int ManhattanDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1-r2) + Math.abs(c1 - c2);
    }
    
    public int isSocialDistancing(char[][] map) {
        ArrayList<Person> personLocation = new ArrayList<Person>();
        for(int i=0; i<map.length;i++) {
            for(int j=0;j<map[i].length;j++) {
                if(map[i][j] == 'P') {
                    for(int a= 0; a< personLocation.size(); a++) {
                        Person person = personLocation.get(a);
                        if(ManhattanDistance(i, j, person.i, person.j) <= 2) {
                            if(i == person.i) {
                                if(Math.abs(j - person.j) <= 1) return 0;
                                else {
                                    int bigJ = (j > person.j) ? j : person.j;
                                    if(map[i][bigJ-1] != 'X') return 0;
                                }
                            } else if(j == person.j) {
                                if(Math.abs(i - person.i) <= 1) return 0;
                                else {
                                    int bigI = (i > person.i) ? i : person.i;
                                    if(map[bigI-1][j] != 'X') return 0;
                                }
                            } else {
                                if(i > person.i) {
                                    if(map[i-1][j] !='X') return 0;
                                } else {
                                    if(map[i+1][j] !='X') return 0;
                                }
                                if(j > person.j) {
                                    if(map[i][j-1] !='X') return 0;
                                } else {
                                    if(map[i][j+1] !='X') return 0;
                                }
                            }
                        }
                    }
                    personLocation.add(new Person(i, j));
                }
            }
        }
        return 1;
    }
}

class Person {
    int i, j;
    
    public Person(int i, int j) {
        this.i = i;
        this.j = j;
    }
}